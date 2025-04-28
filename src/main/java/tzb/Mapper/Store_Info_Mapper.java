package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Store_Info;

import java.util.List;

@Mapper
public interface Store_Info_Mapper extends BaseMapper<Store_Info> {

    // 自定义方法：根据 siId 查询 Store_Info
    @Select("SELECT * FROM store_info WHERE si_id = #{siId}")
    Store_Info selectBySiId(Integer siId);

    // 自定义方法：插入新的 Store_Info
    @Insert("INSERT INTO store_info (si_id, mi_id, si_mi_number) " +
            "VALUES (#{siId}, #{miId}, #{siMiNumber})")
    Integer insertStoreInfo(Store_Info storeInfo);

    // 自定义方法：更新 Store_Info
    @Update("UPDATE store_info SET mi_id = #{miId}, si_mi_number = #{siMiNumber} " +
            "WHERE si_id = #{siId}")
    Integer updateStoreInfo(Store_Info storeInfo);

    // 自定义方法：根据 siId 删除 Store_Info
    @Delete("DELETE FROM store_info WHERE si_id = #{siId}")
    Integer deleteBySiId(Integer siId);

    // 自定义方法：查询所有 Store_Info 列表
    @Select("SELECT * FROM store_info")
    List<Store_Info> selectAllStoreInfos();
}
