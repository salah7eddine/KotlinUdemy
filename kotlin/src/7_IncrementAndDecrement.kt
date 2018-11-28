import java.time.Year

/*
* Operations rules |Priorities rules
* 1- ()
* 2- ++, -- before var
* 3- ^
* 4- *,/
* 5- +,-
* 6- =
* 7- ++,-- After var
*/

fun main(args:Array<String>){

    var x=10
    var y=11

    var z=++x+y //++x=x+1

    println("z : $z")

    var m=x+++y

    println("m : $m")
}