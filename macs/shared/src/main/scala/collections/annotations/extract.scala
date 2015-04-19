package collections.annotations

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.blackbox



@compileTimeOnly("enable macro paradise to expand macro annotations")
class extract extends StaticAnnotation {
   def macroTransform(annottees: Any*) = macro extractMacro.impl
 }


object extractMacro {
  def impl(c: blackbox.Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._

    def companion( classDecl: ClassDef,compDeclOpt: Option[ModuleDef] = None) = {
      val q"case class $className(..$fields) extends ..$bases { ..$body }" = classDecl
      val names:Seq[ValDef] =  fields
      val vals = names.map { case v =>   q"lazy val ${(v.name+"s"):TermName}:Seq[${v.tpt}] = args.map(a=>a.${v.name}).toSeq"     }
      q"""
          object ${className.toTermName}
          {
            class Columns(args:Seq[${className.toTypeName}]) extends collections.annotations.CaseColSeq[${className.toTypeName}](args){
              ..$vals
            }

            def asFrame(args:${className.toTypeName}*):Columns= new Columns(args)
          }
        """
    }

    def updatedDecl(classDecl: ClassDef, compDeclOpt: Option[ModuleDef] = None) = {
      //val (className,fields) = extractNameWithFields(classDecl)
      val compDecl = companion(classDecl,compDeclOpt)

      c.Expr(q"""
        $classDecl
        $compDecl
      """)
    }
    annottees.map(_.tree) match
    {
      case  (classDecl: ClassDef) :: Nil => updatedDecl(classDecl,None)
      case (classDecl: ClassDef) :: (compDecl: ModuleDef) :: Nil => updatedDecl(classDecl,Some(compDecl))
      case _ => c.abort(c.enclosingPosition, "Invalid annottee")
    }

  }

}
