package com.betrip.project.models

class LoginUser(val id:Int,val name:String,val age:Int,val dni:String,
                     val email:String, val phoneNumber:String, val pfp:String,
                     val roles:Array<String>, val token:String)