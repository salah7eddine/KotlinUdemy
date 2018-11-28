import java.util.*

fun main(args:Array<String>){
    //input
    print("enter your DB : ")
    var DOB:Int= readLine()!!.toInt()

    //process
    var year=Calendar.getInstance().get(Calendar.YEAR)
    var age=year-DOB

    //output
    println("your age is $age years")

}