### Repl input demoing product-collections
```scala
```
### Construct a CollSeq
```scala
scala> //Use CollSeq factory to pick correct implementation

scala> val data=CollSeq(("A",2,3.1),("B",3,4.0),("C",4,5.2))
data: org.catch22.collections.immutable.CollSeq3[String,Int,Double] = 
CollSeq((A,2,3.1),
        (B,3,4.0),
        (C,4,5.2))

```
### Extract a column
```scala
scala> //CollSeq3 is also a Product3.  Extract a column like this:

scala> data._1
res0: Seq[String] = List(A, B, C)

```
### Extract a row
```scala
scala> //CollSeq3 is also an IndexedSeq.  Extract a row like this:

scala> data(1)
res1: Product3[String,Int,Double] = (B,3,4.0)

```
### Add a column
```scala
scala> //Use flatZip to add a column:

scala> val newCol=data._1
newCol: Seq[String] = List(A, B, C)

scala> val newData=data flatZip newCol
newData: org.catch22.collections.immutable.CollSeq4[String,Int,Double,String] = 
CollSeq((A,2,3.1,A),
        (B,3,4.0,B),
        (C,4,5.2,C))

```
### Splice columns together
```scala
scala> //Implicit conversions allow you to assemble a CollSeq from Seqs

scala> val col1=Seq("South Africa","Botswana","Zimbabwe","Zambia","Mozambique","Namibia")
col1: Seq[String] = List(South Africa, Botswana, Zimbabwe, Zambia, Mozambique, Namibia)

scala> val col2=Seq(40,5,12,14,8,4)
col2: Seq[Int] = List(40, 5, 12, 14, 8, 4)

scala> val col3=Seq("English","English","English","English","Portuguese","English")
col3: Seq[String] = List(English, English, English, English, Portuguese, English)

scala> val countryData=col1 flatZip col2 flatZip col3
countryData: org.catch22.collections.immutable.CollSeq3[String,Int,String] = 
CollSeq((South Africa,40,English),
        (Botswana,5,English),
        (Zimbabwe,12,English),
        (Zambia,14,English),
        (Mozambique,8,Portuguese),
        (Namibia,4,English))

```
### Map
```scala
scala> //map, drop, filter etc return a CollSeq where possible

scala> val data3=CollSeq((3,1,2),
     | (4,2,3),
     | (5,3,4))
data3: org.catch22.collections.immutable.CollSeq3[Int,Int,Int] = 
CollSeq((3,1,2),
        (4,2,3),
        (5,3,4))

scala> data3.map(t=>(t._1+1,t._2-1,t._3.toDouble))
res2: org.catch22.collections.immutable.CollSeq3[Int,Int,Double] = 
CollSeq((4,0,2.0),
        (5,1,3.0),
        (6,2,4.0))

```
### Row Lookup
```scala
scala> //You can lookup a row by constructing a Map

scala> val data= CollSeq(("Zesa",10,20),
     |                   ("Eskom",5,11),
     |                   ("Sars",16,13))
data: org.catch22.collections.immutable.CollSeq3[String,Int,Int] = 
CollSeq((Zesa,10,20),
        (Eskom,5,11),
        (Sars,16,13))

scala> val lookup= data._1.zip(data).toMap
lookup: scala.collection.immutable.Map[String,Product3[String,Int,Int]] = Map(Zesa -> (Zesa,10,20), Eskom -> (Eskom,5,11), Sars -> (Sars,16,13))

scala> lookup("Sars")
res3: Product3[String,Int,Int] = (Sars,16,13)

scala> // Alternatively depending on performance requirements use filter:

scala> data.filter(_._1=="Sars").head
res4: Product3[String,Int,Int] = (Sars,16,13)

scala> //## Sliding

scala> // You can use the sliding method to access the rows 'above' in a functional way

scala> // example of difference between adjacent rows:

scala> val data= Seq(1,2,3,5,8,13,21,33)
data: Seq[Int] = List(1, 2, 3, 5, 8, 13, 21, 33)

scala> val diff2= data.sliding(2).toList.map(x=>x(1)-x(0))
diff2: List[Int] = List(1, 1, 2, 3, 5, 8, 12)

scala> //or for the 3rd minus the 1st, 4th minus 2nd etc...

scala> val diff3= data.sliding(3).toList.map(x=>x(2)-x(0))
diff3: List[Int] = List(2, 3, 5, 8, 13, 20)

scala> //## I/O

scala> //## Parser factory

scala> val parser=CsvParser[String,Int,Int,Int]
parser: org.catch22.collections.io.CsvParser4[String,Int,Int,Int] = org.catch22.collections.io.CsvParser4@b92ba0

scala> //## Read a file

scala> val abilData=parser.parseFile("abil.csv",hasHeader=true,delimiter="\t")
abilData: org.catch22.collections.immutable.CollSeq4[String,Int,Int,Int] = 
CollSeq((30-APR-12,3885,3922,3859),
        (02-MAY-12,3880,3915,3857),
        (03-MAY-12,3920,3948,3874),
        (04-MAY-12,3909,3952,3885),
        (07-MAY-12,3853,3900,3825),
        (08-MAY-12,3770,3851,3755),
        (09-MAY-12,3700,3782,3666),
        (10-MAY-12,3732,3745,3658),
        (11-MAY-12,3760,3765,3703),
        (14-MAY-12,3660,3750,3655),
        (15-MAY-12,3650,3685,3627),
        (16-MAY-12,3661,3663,3555),
        (17-MAY-12,3620,3690,3600),
        (18-MAY-12,3545,3595,3542),
        (21-MAY-12,3602,3608,3546),
        (22-MAY-12,3650,3675,3615),
        (23-MAY-12,3566,3655,3566),
        (24-MAY-12,3632,3645,3586),
        (25-MAY-12,3610,3665,3583),
        (28-MAY-12,3591,3647,3582),
 ...
scala> //## Additional types

scala> // Parser recognises Strings, Booleans and most numeric types out of the box.

scala> // To add support for an additional type T you make a function 

scala> // (String)=>T which is wrapped in class GeneralConverter available

scala> // as an implicit parameter.

scala> import java.util.Date
import java.util.Date

scala> implicit val dmy = new DateConverter("dd-MMM-yy")
dmy: org.catch22.collections.io.DateConverter = org.catch22.collections.io.DateConverter@be3133

scala> val p=CsvParser[Date,Int,Int,Int,Int]
p: org.catch22.collections.io.CsvParser5[java.util.Date,Int,Int,Int,Int] = org.catch22.collections.io.CsvParser5@86bcd7

scala> val prices=p.parseFile("abil.csv", hasHeader=true, delimiter="\t")
prices: org.catch22.collections.immutable.CollSeq5[java.util.Date,Int,Int,Int,Int] = 
CollSeq((Mon Apr 30 00:00:00 AST 2012,3885,3922,3859,4296459),
        (Wed May 02 00:00:00 AST 2012,3880,3915,3857,3127464),
        (Thu May 03 00:00:00 AST 2012,3920,3948,3874,3080823),
        (Fri May 04 00:00:00 AST 2012,3909,3952,3885,2313354),
        (Mon May 07 00:00:00 AST 2012,3853,3900,3825,1508802),
        (Tue May 08 00:00:00 AST 2012,3770,3851,3755,2935654),
        (Wed May 09 00:00:00 AST 2012,3700,3782,3666,2982119),
        (Thu May 10 00:00:00 AST 2012,3732,3745,3658,3516968),
        (Fri May 11 00:00:00 AST 2012,3760,3765,3703,3133930),
        (Mon May 14 00:00:00 AST 2012,3660,3750,3655,1677313),
        (Tue May 15 00:00:00 AST 2012,3650,3685,3627,2982854),
        (Wed May 1...
scala> //calculate 5 period moving average

scala> val movingAverage= prices._2.sliding(5).toList.map(_.mean)
movingAverage: List[Double] = List(3889.4, 3866.4, 3830.4, 3792.8, 3763.0, 3724.4, 3700.4, 3692.6, 3670.2, 3627.2, 3615.6, 3615.6, 3596.6, 3599.0, 3612.0, 3609.8, 3605.6, 3611.0, 3611.0, 3606.0, 3614.2, 3612.4, 3629.0, 3634.6, 3659.4, 3661.0, 3657.2, 3645.2, 3628.4, 3616.4, 3632.8, 3668.8, 3702.6, 3745.4, 3781.0, 3779.6, 3755.4, 3727.4, 3689.4, 3650.2, 3638.8, 3641.8, 3648.2, 3663.2, 3671.0, 3649.4, 3624.4, 3595.0, 3559.0, 3518.0, 3505.8, 3495.8, 3505.8, 3531.2, 3570.8, 3589.0, 3613.0, 3620.8, 3624.4, 3635.4, 3661.0, 3667.0, 3686.6, 3703.6, 3720.0, 3722.4, 3692.4, 3619.0, 3553.4, 3473.4, 3413.2, 3400.0, 3422.8, 3427.4, 3433.6, 3434.0, 3425.6, 3403.8, 3396.6, 3388.6, 3376.0, 3353.6, 3318.6, 3291.8, 3260.6, 3240.0, 3225.0, 3226.0, 3218.2, 3232.2, 3219.6, 3226.0, 3234.0, 3251.0, 3271.0, 33...
scala> //## Calculate aircraft moment

scala> val aircraftLoading=CollSeq(("Row1",86,214),("Row4",168,314),("FwdCargo",204,378)) //Flight Station, Mass kg, Arm in
aircraftLoading: org.catch22.collections.immutable.CollSeq3[String,Int,Int] = 
CollSeq((Row1,86,214),
        (Row4,168,314),
        (FwdCargo,204,378))

scala> val pounds = aircraftLoading._2.map(_ * 2.2)  //convert kg -> lb
pounds: Seq[Double] = List(189.20000000000002, 369.6, 448.8)

scala> val moment = pounds.zip(aircraftLoading._3).map(x=>x._1*x._2)
moment: Seq[Double] = List(40488.8, 116054.40000000001, 169646.4)

scala> moment.sum
res5: Double = 326189.6
```