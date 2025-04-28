package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Operator_Info;

import java.util.List;

@Mapper
public interface Operator_Info_Mapper extends BaseMapper<Operator_Info> {

    // 自定义方法：根据 oi_id 查询 Operator_Info
    @Select("SELECT * FROM operator_info WHERE oi_id = #{oiId}")
    Operator_Info selectByOiId(Integer oiId);

    // 自定义方法：插入新的 Operator_Info
    @Insert("INSERT INTO operator_info (oi_id, oi_name, oi_phone_number, oi_email, oi_password, oi_address, ii_id) " +
            "VALUES (#{oiId}, #{oiName}, #{oiPhoneNumber}, #{oiEmail}, #{oiPassword}, #{oiAddress}, #{iiId})")
    Integer insertOperator(Operator_Info operatorInfo);

    // 自定义方法：更新 Operator_Info
    @Update("UPDATE operator_info SET oi_name = #{oiName}, oi_phone_number = #{oiPhoneNumber}, " +
            "oi_email = #{oiEmail}, oi_password = #{oiPassword}, oi_address = #{oiAddress}, ii_id = #{iiId} " +
            "WHERE oi_id = #{oiId}")
    Integer updateOperator(Operator_Info operatorInfo);

    // 自定义方法：根据 oi_id 删除 Operator_Info
    @Delete("DELETE FROM operator_info WHERE oi_id = #{oiId}")
    Integer deleteByOiId(Integer oiId);

    // 自定义方法：查询所有 Operator_Info 列表
    @Select("SELECT * FROM operator_info")
    List<Operator_Info> selectAllOperators();
}
