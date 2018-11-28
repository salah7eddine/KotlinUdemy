fun main(arrgs:Array<String>){
    var x=85
    when(x){
        1,2 ->{
            println("value is 1 or 2")
        }
        in 10..40 ->{
            println("value in range 10..40")
        }
        !in 10..40 ->{
            println("value is not in range 10..40")
        }
        in 80..90 ->{
            println("value in range 80..90")
        }
        else ->{
            print("value is out of range ")
        }
    }
}