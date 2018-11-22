package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.demo.entity.UserInfo
import com.example.demo.entity.UserSimpleInfo
import com.example.demo.repository.UserMapper
import com.example.demo.service.IUserService

@Service
class UserServiceImpl : IUserService {
    @Autowired
    lateinit var userDao: UserMapper

    override fun queryUserList(userInfo: UserInfo): List<UserInfo> {
        return userDao.queryUserList(userInfo);
    }

    override fun insertUser(userInfo: UserInfo): Int {
        return userDao.insertUser(userInfo);
    }
    
    override fun getUserSimpleInfo(userId: Long): UserSimpleInfo {
        return userDao.getUserSimpleInfo(userId);
    }
    
    override fun getUserSimpleInfoByUserId(userId: Long): UserSimpleInfo {
        return userDao.getUserSimpleInfoById(userId);
    }
    
    override fun queryUserSimpleList(userInfo: UserSimpleInfo): List<UserSimpleInfo> {
        return userDao.queryUserSimpleList(userInfo);
    }
    
    override fun queryUserSimpleListByPage(offset:Int?,limit:Int?): List<UserSimpleInfo> {
        return userDao.queryUserSimpleListByPage(offset,limit)
    }
    
    override fun queryUserSimpleLPage(offset:Int?,limit:Int?): List<UserSimpleInfo> {
        return userDao.queryUserSimplePage(offset,limit)
    }
}