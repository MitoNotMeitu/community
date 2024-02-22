package life.majiang.community.mapper;


import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;

//与数据库通信/传输用mapper对象
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);//@Select中的#{}内的参数，会将下面这个方法中的形参自动传进去（只有参数是-类对象-的时候会自动传，不是的时候，就如这行所写，需要加@Param的注解）

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id = #{id}")
    void update(User user);//sql的update语句，value的值类型无要求，就是数据库中对应的值的类型，所以无需特别处理
}
