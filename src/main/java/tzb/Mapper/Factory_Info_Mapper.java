package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Factory_Info;
import java.util.List;

@Mapper
public interface Factory_Info_Mapper extends BaseMapper<Factory_Info> {

    // 自定义方法：根据 fiId 查询 Factory_Info
    @Select("SELECT * FROM factory_info WHERE fi_id = #{fiId}")
    Factory_Info selectByFiId(Integer fiId);

    // 自定义方法：插入新的 Factory_Info
    @Insert("INSERT INTO factory_info (fi_id, fi_name, fi_phone_number, fi_address) " +
            "VALUES (#{fiId}, #{fiName}, #{fiPhoneNumber}, #{fiAddress})")
    Integer insertFactory(Factory_Info factoryInfo);

    // 自定义方法：更新 Factory_Info
    @Update("UPDATE factory_info SET fi_name = #{fiName}, fi_phone_number = #{fiPhoneNumber}, " +
            "fi_address = #{fiAddress} WHERE fi_id = #{fiId}")
    Integer updateFactory(Factory_Info factoryInfo);

    // 自定义方法：根据 fiId 删除 Factory_Info
    @Delete("DELETE FROM factory_info WHERE fi_id = #{fiId}")
    Integer deleteByFiId(Integer fiId);

    // 自定义方法：查询所有 Factory_Info 列表
    @Select("SELECT * FROM factory_info")
    List<Factory_Info> selectAllFactories();
}
