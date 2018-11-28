package OOP

enum class Direction{
    NORTH,SOUTH,EAST,WEST,a,v,c,d
}

fun main(args:Array<String>){
    var userdirect=Direction.SOUTH

    if (userdirect==Direction.NORTH){
        println("he went to north")
    }else{
        println("i don't know where he went")
    }

}