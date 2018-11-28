fun main(args:Array<String>){
    loop@ for(count in 1..10){

        for(count2 in 1..5){
            println("count2  :$count2")
            if(count2==2){
                break@loop // continue
            }
        }

    }
    println("loop done")
}