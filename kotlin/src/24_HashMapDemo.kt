
fun main(args:Array<String>){

    var map=HashMap<Int,String>()//HashMap

    map.put(1,"Salah")
    map.put(2,"Hamza")
    map.put(3,"Meryem")
    map.put(4,"Familya")

    println("---------------")

    println(map.get(3))

    println("---------------")
    for (k in map.keys){
        println(map.get(k))
    }

    println("---------------")
    map.put(4,"la famille")

    for (k in map.keys){
        println(map.get(k))
    }
    println("---------------")
}