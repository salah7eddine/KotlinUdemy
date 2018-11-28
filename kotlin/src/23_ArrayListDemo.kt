
fun main(args:Array<String>){
    var arrayList=ArrayList<String>()
    arrayList.add("Salam")
    arrayList.add("Salama")
    arrayList.add("Saloma")
    arrayList.add("Salala")
    arrayList.add("Sssaall")

    println("First name : "+arrayList.get(0))

    arrayList.set(0,"Hamza Abousaid")

    println("\n All element\n")
    for (item in arrayList){
        println(item)
    }

    //Search
    if(arrayList.contains("Salama")){
        println("\n name is found \n")
    }else{
        println("\n name is not found\n")
    }

    println("\nall element by index\n")
    for (index in 0..arrayList.size-1){
        println(arrayList.get(index))
    }


}