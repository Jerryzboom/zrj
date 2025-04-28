package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Client_Info;
import java.util.List;

@Mapper
public interface Client_Info_Mapper extends BaseMapper<Client_Info> {

    // 自定义方法：根据 ci_id 查询 Client_Info
    @Select("SELECT * FROM client_info WHERE ci_id = #{ciId}")
    Client_Info selectByCiId(Integer ciId);

    @Insert("insert into client_info (ci_id, ci_name, ci_age, ci_phone_number, ci_email, ci_address)" +
            "VALUES (default, #{ciName}, #{ciAge}, #{ciPhoneNumber}, #{ciEmail}, #{ciAddress})")
    Integer insertDefaultCLient(Client_Info clientInfo);
    // 自定义方法：插入新的 Client_Info
    @Insert("INSERT INTO client_info (ci_id, ci_name, ci_age, ci_phone_number, ci_email, ci_address) " +
            "VALUES (#{ciId}, #{ciName}, #{ciAge}, #{ciPhoneNumber}, #{ciEmail}, #{ciAddress})")
    Integer insertClient(Client_Info clientInfo);

    // 自定义方法：更新 Client_Info
    @Update("UPDATE client_info SET ci_name = #{ciName}, ci_age = #{ciAge}, ci_phone_number = #{ciPhoneNumber}, " +
            "ci_email = #{ciEmail}, ci_address = #{ciAddress} WHERE ci_id = #{ciId}")
    Integer updateClient(Client_Info clientInfo);

    // 自定义方法：根据 ci_id 删除 Client_Info
    @Delete("DELETE FROM client_info WHERE ci_id = #{ciId}")
    int deleteByCiId(Integer ciId);

    // 自定义方法：查询所有 Client_Info 列表
    @Select("SELECT * FROM client_info")
    List<Client_Info> selectAllClients();
}
