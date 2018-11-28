
fun main(args:Array<String>){
    print("enter your grade: ")
    var grade= readLine()!!.toDouble()
    if(grade>90){
        //block of code
        grade+=3
        println("You are in A level")
    }
    if (grade>=50&&grade<70){
        grade=grade+10
        print("you get extra 10 point")
    }
    println("you enter grade $grade")
}