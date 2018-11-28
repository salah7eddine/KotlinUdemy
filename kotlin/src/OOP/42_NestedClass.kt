package OOP

class Outer{
    private val name:String?=null
    inner class Nested{
        fun Show(){
            println(name)
        }
    }
}

fun main(args:Array<String>){
    var outer =Outer()
    var nested=outer.Nested()
    nested.Show()
}