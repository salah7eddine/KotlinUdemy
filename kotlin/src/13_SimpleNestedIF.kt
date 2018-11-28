
fun main(args:Array<String>){
    print("enter your grade: ")
    var grade= readLine()!!.toDouble()
    if(grade>=90){
        //block of code
        if(grade<93){
            println("you are A- level")
        }else{
            println("you are A+ level")
        }
    }
    if(grade>=80&&grade<90){
        //block of code
        if(grade<83){
            println("you are B- level")
        }else{
            println("you are B+ level")
        }
    }

    println("you enter grade $grade.....")
}