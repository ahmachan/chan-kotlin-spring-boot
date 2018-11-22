package com.example.demo.controller

import javax.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*
import com.alibaba.fastjson.JSONArray;
import java.util.HashMap;

import com.example.demo.entity.UserInfo
import com.example.demo.entity.UserSimpleInfo
import com.example.demo.repository.UserMapper
import com.example.demo.service.IUserService
import com.example.common.utils.ApiResponseUtil
import com.example.common.utils.TokenUtil

@RestController
class UserController {
    @Autowired
    lateinit var userService: IUserService
    
    @GetMapping("/users/{userId}")
    fun queryUserById(@PathVariable userId: String): Any? {
        //var userInfo = UserInfo(userId = userId.toLong(), username = null,
        //        passwd = null,nickname=null,age=0,gender=1,address=null,status=1,addTime=0)
        var userInfo = UserInfo(userId = userId.toLong(), username = null,nickname=null)
        var userList = userService.queryUserList(userInfo)
        val userRes = userList[0]
        return ApiResponseUtil.SuccessResponse("OK",userRes)
    }
    
    @GetMapping("/users/list")
    fun queryUserList(): Any? {
        val userInfo = UserInfo(userId = null, username = null,nickname=null)
        val userList = userService.queryUserList(userInfo)
        
        return ApiResponseUtil.SuccessResponse("OK",userList)
    }    

    
    @GetMapping("/users/querypage")
    fun queryUserSimpleListByPage(
        //@RequestParam offset:Int?,
        @RequestParam(value="offset",defaultValue="0") offset:Int?,
        @RequestParam(value="limit",defaultValue="5") limit:Int?
    ):Any? {        
        val userRes=userService.queryUserSimpleListByPage(offset,limit)
        var preUserId:Long=1024;
        var tokenMsg = TokenUtil.generateToken(preUserId)
        val r = ApiResponseUtil.SuccessResponse(tokenMsg,userRes) 
        return r
    }
 
    @GetMapping("/users/pages")   
    fun queryUserSimplePages(
            offset:Int?,
            limit:Int?
    ):Any? {
        
        val userRes = userService.queryUserSimpleLPage(offset,limit)        
        
        return ApiResponseUtil.SuccessResponse("OK",userRes)
    }
    
    @GetMapping("/users/pages/simple")
    fun queryUserSimplePagesV02(       
        @RequestParam(value="offset",defaultValue="0") offset:Int?,
        @RequestParam(value="limit",defaultValue="5") limit:Int?
    ):Any? {
          
       userService.queryUserSimpleLPage(offset,limit).let {
            //成功
            return ApiResponseUtil.SuccessResponse("OK",this)
        }   
        
        //return ApiResponseUtil.FailureResponse("failed","10024")
    }
    
    
    @GetMapping("/users/details")
    fun getUserDetails(id : Long) : Any {
        val user = userService.getUserSimpleInfo(id)
   
        //return ApiResponseUtil.SuccessResponse("OK",user)
        return ApiResponseUtil.SuccessResponse(data=user,msg="OK")  
    }
    
    @GetMapping("/users/{userId}/details")
    fun getUserDetailsByUserId(@PathVariable userId : Long) : Any {
        val userDetails=userService.getUserSimpleInfoByUserId(userId)
        
        return ApiResponseUtil.SuccessResponse(msg="OK",data=userDetails)  
    }
    
    @GetMapping("/users/{userId}/bizkey")
    fun queryUserBizkeyById(@PathVariable userId: String?): String {
        var userList = "user bizkey: "+userId?.toLong()
        return userList
    }
}
