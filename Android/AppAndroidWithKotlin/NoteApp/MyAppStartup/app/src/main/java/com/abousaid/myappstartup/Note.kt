package com.abousaid.myappstartup

import android.provider.Settings
import java.util.*

/**
 * Created by Admin on 11/20/2018.
 */


class Note{
    var noteID:Int?=null
    var noteDate:String?= Settings.ACTION_DATE_SETTINGS // Date of the android we must do it
    var noteName:String?=null
    var noteDes:String?=null


    constructor(noteID:Int,noteName:String,noteDes:String){
        this.noteID=noteID
        this.noteDes=noteDes
        this.noteName=noteName
    }
}