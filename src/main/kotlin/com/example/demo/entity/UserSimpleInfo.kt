package com.example.demo.entity
/*
data class UserSimpleInfo(
        //如果不加默认值,则会抛出"kotlin mybatis:No constructor found in void matching"错误
     val id: Long?=0,
     var username: String?="",
     var nickname: String?=""
)
*/

import lombok.Data
import java.util.*

@Data
class UserSimpleInfo{
    var id: Long? = 0
    var username: String? = null
    var nickname: String? = null
}
       