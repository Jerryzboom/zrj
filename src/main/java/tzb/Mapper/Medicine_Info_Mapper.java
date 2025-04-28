package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Medicine_Info;
import java.util.Date;
import java.util.List;

@Mapper
public interface Medicine_Info_Mapper extends BaseMapper<Medicine_Info> {

    // 自定义方法：根据 miId 查询 Medicine_Info
    @Select("SELECT * FROM medicine_info WHERE mi_id = #{miId}")
    Medicine_Info selectByMiId(Integer miId);

    // 自定义方法：插入新的 Medicine_Info
    @Insert("INSERT INTO medicine_info (mi_id, mi_name, mi_dose, mi_storage_state, mi_born_date, mi_expiry, mi_pici_number, fi_id, mi_type, mi_purchase_price, mi_sale_price) " +
            "VALUES (#{miId}, #{miName}, #{miDose}, #{miStorageState}, #{miBornDate}, #{miExpiry}, #{miPiciNumber}, #{fiId}, #{miType}, #{miPurchasePrice}, #{miSalePrice})")
    Integer insertMedicine(Medicine_Info medicineInfo);

    // 自定义方法：更新 Medicine_Info
    @Update("UPDATE medicine_info SET mi_name = #{miName}, mi_dose = #{miDose}, mi_storage_state = #{miStorageState}, " +
            "mi_born_date = #{miBornDate}, mi_expiry = #{miExpiry}, mi_pici_number = #{miPiciNumber}, fi_id = #{fiId}, " +
            "mi_type = #{miType}, mi_purchase_price = #{miPurchasePrice}, mi_sale_price = #{miSalePrice} " +
            "WHERE mi_id = #{miId}")
    Integer updateMedicine(Medicine_Info medicineInfo);

    // 自定义方法：根据 miId 删除 Medicine_Info
    @Delete("DELETE FROM medicine_info WHERE mi_id = #{miId}")
    Integer deleteByMiId(Integer miId);

    // 自定义方法：查询所有 Medicine_Info 列表
    @Select("SELECT * FROM medicine_info")
    List<Medicine_Info> selectAllMedicines();
}
