package com.example.demo.repository

//import org.apache.ibatis.annotations.Insert
//import org.apache.ibatis.annotations.Mapper
//import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.*
import com.example.demo.entity.UserInfo
import com.example.demo.entity.UserSimpleInfo


@Mapper
interface UserMapper {
    @Select("""<script>
        select id as userId,username,nickname from t_user where 1=1
        <if test='username != null'> AND username like #{username}%</if>
        <if test='userId != null'> AND id = #{userId}</if>
        </script>""")
    fun queryUserList(userInfo: UserInfo): List<UserInfo>
    
    @Select("select id,username,nickname from t_user")
    fun queryUserSimpleList(userInfo: UserSimpleInfo):List<UserSimpleInfo>;
    
    //根据id获取用户信息
    @Select("select id,username,nickname from t_user where id = #{userId}")
    fun getUserSimpleInfoById(userId: Long): UserSimpleInfo
    
    @Select("select id,username,nickname from t_user where id = #{id}")
    fun getUserSimpleInfo(@Param("id") id : Long): UserSimpleInfo
    
    @Select("select id,username,nickname from t_user where id>0 limit #{offset},#{limit}")
    fun queryUserSimpleListByPage(@Param("offset") offset: Int?,@Param("limit") limit:Int?):List<UserSimpleInfo>;

    @Select("select id,username,nickname from t_user where id>0 limit #{offset},#{limit}")
    fun queryUserSimplePage(@Param("offset") offset: Int?,@Param("limit") limit:Int?):List<UserSimpleInfo>;
    
    @Insert("""
        insert into t_user (username, passwd,nickname,age,gender,address,status,add_time)
            values (#{username}, #{passwd}, #{nickname},#{age},#{gender},#{address},#{status},#{addTime})
        """)
    fun insertUser(userInfo: UserInfo): Int
}
