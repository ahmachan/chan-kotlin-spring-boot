package com.example.demo.entity

data class UserInfo(
        //如果不加默认值,则会抛出"kotlin mybatis:No constructor found in void matching"错误
        val userId: Long?=0,
        val username: String?="",
        //val passwd: String?="",
        val nickname: String?=""
        //val age : Int=0,
        //val gender:Int=1,
        //val address:String?
        //val status: Int = 1,
        //val addTime:Int = 0
)
