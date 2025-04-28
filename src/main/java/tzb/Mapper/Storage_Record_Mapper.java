package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Storage_Record;

import java.util.List;

@Mapper
public interface Storage_Record_Mapper extends BaseMapper<Storage_Record> {

    // 自定义方法：根据 srId 查询 Storage_Record
    @Select("SELECT * FROM storage_record WHERE sr_id = #{srId}")
    Storage_Record selectBySrId(Integer srId);

    // 自定义方法：插入新的 Storage_Record
    @Insert("INSERT INTO storage_record (sr_id, si_id, mi_id, oi_id, sr_purchase_date, sr_purchase_number) " +
            "VALUES (#{srId}, #{siId}, #{miId}, #{oiId}, #{srPurchaseDate}, #{srPurchaseNumber})")
    Integer insertStorageRecord(Storage_Record storageRecord);

    // 自定义方法：更新 Storage_Record
    @Update("UPDATE storage_record SET si_id = #{siId}, mi_id = #{miId}, oi_id = #{oiId}, " +
            "sr_purchase_date = #{srPurchaseDate}, sr_purchase_number = #{srPurchaseNumber} " +
            "WHERE sr_id = #{srId}")
    Integer updateStorageRecord(Storage_Record storageRecord);

    // 自定义方法：根据 srId 删除 Storage_Record
    @Delete("DELETE FROM storage_record WHERE sr_id = #{srId}")
    Integer deleteBySrId(Integer srId);

    // 自定义方法：查询所有 Storage_Record 列表
    @Select("SELECT * FROM storage_record")
    List<Storage_Record> selectAllStorageRecords();
}
