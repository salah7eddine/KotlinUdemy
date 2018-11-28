fun sum(n1:Int,n2:Int):Int{
    //block
    var sum=n1+n2
    return sum
}
fun sum(n1:Int,n2:Int,n3:Int):Int{
    //block
    var sum=n1+n2+n3
    return sum
}
fun sum(n1:Int,n2:Int,n3:Int,n4:Int):Int{
    //block
    var sum=n1+n2+n3+n4
    return sum
}

fun main(args:Array<String>){
    var sumNumber2=sum(10,20)
    println("la somme est $sumNumber2")

    var sumNumber3=sum(10,20,30)
    println("la somme est $sumNumber3 ")

    var sumNumber4=sum(10,20,30,40)
    println("la somme est $sumNumber4 ")
}