package OOP

abstract class CreditCard(){
    fun CreditID():String{
        return "2434356FGF45354345"
    }
    abstract fun newCredit()
}

class UserInfo():CreditCard(){
    fun getInfo():String{
        return CreditID()
    }

    override fun newCredit() {
        println("new cart created")
    }
}
fun main(args:Array<String>){
   // var credit=CreditCard()
    //println(credit.CreditID())

    var user =UserInfo()
    println(user.getInfo())
    user.newCredit()
}