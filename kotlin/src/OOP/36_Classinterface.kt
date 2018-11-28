package OOP

interface op{
    fun sum(n1:Int,n2:Int){println(n1+n2)}
    fun div(n1:Int,n2:Int){println(n1/n2)}
}

class userOp:op{
    override fun sum(n1: Int, n2: Int) {
        println("La somme est "+ n1+n2)
    }

    override fun div(n1: Int, n2: Int) {
        println("La division est "+ n1/n2)
    }
}

class adminOp:op{
    override fun sum(n1: Int, n2: Int) {
        println("La somme est "+(n1+n2-2))
    }

    override fun div(n1: Int, n2: Int) {
        println("La division est "+(n1/n2-2))
    }
}

class ManagerOp:op{

}

fun main(args:Array<String>){
    //TODO: test all the method

    var adminop=adminOp()
    adminop.sum(10,11)
}