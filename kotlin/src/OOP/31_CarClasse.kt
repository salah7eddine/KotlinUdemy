package OOP

class   Car(Type:String,Model:Int,Price:Double,MilesDrive:Int,Owner:String){
    var Owner:String?=null
    var Price:Double?=null
    var MilesDrive:Int?=null
    var Model:Int?=null
    var Type:String?=null

    init {
        println("Type "+Type)
        println("Model "+Model)
        println("Price "+Price)
        println("MilesDrive "+MilesDrive)
        println("Owner "+Owner)

        this.Owner=Owner
        this.Price=Price
        this.MilesDrive=MilesDrive
        this.Model=Model
        this.Type=Type
    }

    fun GetPrice():Double?{
        return this.Price!!-(this.MilesDrive!!.toDouble()*10)
    }
    fun GetOwner():String?{
        return this.Owner
    }
}

fun main(args:Array<String>){
    var huCar=Car("BMW",2016,1000.0,105,"Salah-Eddine")
    println("--------------------------------------------------------")
    println("Get Owner : "+huCar.GetOwner())
    println("Get Prices : "+huCar.GetPrice())

    println("--------------------------------------------------------")

    var huCar1=Car("AUDI",2014,1600.0,15,"Abousaid")
    println("--------------------------------------------------------")
    println("Get Owner : "+huCar1.GetOwner())
    println("Get Prices : "+huCar1.GetPrice())
}