fun sum(n1:Double,n2:Double):Double{

    //block
    var sum=n1+n2

    return sum

}

fun <T> dispaly(n:Int):Unit{
    println("n:$n")
}

fun main(args:Array<String>){

    var r =sum(10.23,19.57)
    println("r:$r")

    r =sum(6.3,54.7)
    println("r:$r")

    r =sum(20.19,13.67)
    println("r:$r")

    dispaly<Any>(10)
    dispaly<Any>(22)
}