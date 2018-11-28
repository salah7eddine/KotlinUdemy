fun main(args:Array<String>){

    var setElement= setOf(1,23,45,67,47,45,23,1)// we can't change and add also

    for (element in setElement){
        println(element)
    }

    println("-------------------- M")
    var setElementM= mutableSetOf(1,23,45,67,47,45,23,1)

    setElementM.add(77)
    setElementM.add(12)

    for (element in setElementM){
        println(element)
    }
}