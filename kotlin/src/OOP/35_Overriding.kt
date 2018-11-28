package OOP

open class Operations1(){

    open fun sum(n1:Int,n2:Int):Int{
        return n1+n2
    }

    fun div(n1:Int,n2:Int):Int{
        return n1/n2
    }
}

//this and super
class MultiOperations1():Operations(){

    override fun sum(n1:Int,n2:Int):Int{
        return n1+n2*3
    }

    fun sub(n1:Int,n2:Int):Int{
        return n1-n2
    }
    fun multi(n1:Int,n2:Int):Int{
        return n1*n2
    }

}

fun main(args:Array<String>){
    var op=Operations1()
    var sum=op.sum(10,15)
    println("sum : "+sum)
    var div =op.div(12,10)
    println("div : "+div)

    println("----------------")
    var op2=MultiOperations1()
    sum=op2.sum(10,15)
    println("sum : "+sum)
    div =op2.div(12,10)
    println("div : "+div)

}