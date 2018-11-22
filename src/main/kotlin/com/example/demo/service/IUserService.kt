package com.example.demo.service

import com.example.demo.entity.UserInfo
import com.example.demo.entity.UserSimpleInfo

interface IUserService{
    fun queryUserList(userInfo: UserInfo): List<UserInfo>
    fun insertUser(userInfo: UserInfo): Int
   
    fun getUserSimpleInfo(userId: Long): UserSimpleInfo
    fun getUserSimpleInfoByUserId(userId: Long): UserSimpleInfo
    fun queryUserSimpleList(userInfo: UserSimpleInfo): List<UserSimpleInfo>
    fun queryUserSimpleLPage(offset:Int?,limit:Int?): List<UserSimpleInfo>
    fun queryUserSimpleListByPage(offset:Int?,limit:Int?): List<UserSimpleInfo>
    
}