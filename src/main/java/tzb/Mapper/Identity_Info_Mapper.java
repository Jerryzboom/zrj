package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Identity_Info;
import java.util.List;

@Mapper
public interface Identity_Info_Mapper extends BaseMapper<Identity_Info> {

    // 自定义方法：根据 iiId 查询 Identity_Info
    @Select("SELECT * FROM identity_info WHERE ii_id = #{iiId}")
    Identity_Info selectByIiId(Integer iiId);

    // 自定义方法：插入新的 Identity_Info
    @Insert("INSERT INTO identity_info (ii_id, ii_type) VALUES (#{iiId}, #{iiType})")
    Integer insertIdentity(Identity_Info identityInfo);

    // 自定义方法：更新 Identity_Info
    @Update("UPDATE identity_info SET ii_type = #{iiType} WHERE ii_id = #{iiId}")
    Integer updateIdentity(Identity_Info identityInfo);

    // 自定义方法：根据 iiId 删除 Identity_Info
    @Delete("DELETE FROM identity_info WHERE ii_id = #{iiId}")
    Integer deleteByIiId(Integer iiId);

    // 自定义方法：查询所有 Identity_Info 列表
    @Select("SELECT * FROM identity_info")
    List<Identity_Info> selectAllIdentities();
}
