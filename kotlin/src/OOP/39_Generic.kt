package OOP

class UserAdmins<T>(credit:T){
    init {
        println(credit)
    }
}

fun<T> display(process: T){
    println(process)
}

fun main(args:Array<String>){
    var userAdmin=UserAdmins<String>("Abousaid")
    var userAdmin2=UserAdmins<Int>(14)
    var userAdmin3=UserAdmins<Double>(123.3)

    display<Int>(22)
    display<String>("process user")

}