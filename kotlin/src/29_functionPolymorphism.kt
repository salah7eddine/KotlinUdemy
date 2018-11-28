fun show(name:String):Unit{
    println("Name is "+name)
}

fun show(num:Int):Unit{
    println("num : "+num)
}

fun show(numD:Double):Unit{
    println("num : "+numD)
}

fun main(args:Array<String>){
    show("Salah")
    show(14)
    show(14.7)
}