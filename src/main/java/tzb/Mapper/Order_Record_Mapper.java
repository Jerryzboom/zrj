package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Order_Record;

import java.util.List;

@Mapper
public interface Order_Record_Mapper extends BaseMapper<Order_Record> {

    // 自定义方法：根据 orId 查询 Order_Record
    @Select("SELECT * FROM order_record WHERE or_id = #{orId}")
    Order_Record selectByOrId(Integer orId);

    // 自定义方法：插入新的 Order_Record
    @Insert("INSERT INTO order_record (or_id, mi_id, ci_id, or_sale_date, or_all_price, oi_id) " +
            "VALUES (#{orId}, #{miId}, #{ciId}, #{orSaleDate}, #{orAllPrice}, #{oiId})")
    Integer insertOrderRecord(Order_Record orderRecord);

    // 自定义方法：更新 Order_Record
    @Update("UPDATE order_record SET mi_id = #{miId}, ci_id = #{ciId}, or_sale_date = #{orSaleDate}, " +
            "or_all_price = #{orAllPrice}, oi_id = #{oiId} WHERE or_id = #{orId}")
    Integer updateOrderRecord(Order_Record orderRecord);

    // 自定义方法：根据 orId 删除 Order_Record
    @Delete("DELETE FROM order_record WHERE or_id = #{orId}")
    Integer deleteByOrId(Integer orId);

    // 自定义方法：查询所有 Order_Record 列表
    @Select("SELECT * FROM order_record")
    List<Order_Record> selectAllOrderRecords();
}
