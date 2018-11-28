fun main(args:Array<String>){

    var map= hashMapOf(1 to "Salah",2 to "Hamza",3 to "Meryem")

    map.put(4,"Familya")

    println(map.get(4))

    println(map[4])

    var ar= arrayOf(1,10,12,22)

    println("ar[0] : "+ar[0])

    var list= listOf(12,22,33,44) // about list we can't change the value of attribut
    var list2= mutableListOf(12,23,34,12)

    list2[3]=0

    println("list1")
    for (item in list){
        println(item)
    }
    println("list2")
    for (item in list2){
        println(item)
    }
}