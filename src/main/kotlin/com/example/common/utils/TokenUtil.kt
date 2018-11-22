package com.example.common.utils
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.stereotype.Component
import java.util.*

/** 生成Token工具类
 */
class TokenUtil {

    companion object {

        //有效时常
        val expTime = 86400000

        val secret = "secret"

        /**
         * 生成Token
         */
        fun generateToken(userId:Long?) : String {
            val tokenTime = Date().time + expTime
            return "${userId.toString()}:$tokenTime:${DigestUtils.md5Hex("${userId.toString()}:$tokenTime:$secret")}"
        }

        //校验Token
        fun validationToken(token : String, userId:Long?) : Boolean {

            val arr = token.split(":")
            //过期时间
            val tokenTime = arr[1]
            //加密字符串
            val md5hex = arr[2]

            //过期
            if (Date().time > tokenTime.toLong()) return false

            //未通过验证
            if (!md5hex.equals(DigestUtils.md5Hex("${userId.toString()}:$tokenTime:$secret"))) return false

            //通过验证
            return true
        }
    }

}