package tzb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import tzb.Pojo.Order_Detail;

import java.util.List;

@Mapper
public interface Order_Detail_Mapper extends BaseMapper<Order_Detail> {

    // 自定义方法：根据 odId 查询 Order_Detail
    @Select("SELECT * FROM order_detail WHERE od_id = #{odId}")
    Order_Detail selectByOdId(Integer odId);

    // 自定义方法：插入新的 Order_Detail
    @Insert("INSERT INTO order_detail (od_id, mi_id, fi_id, od_state, od_pay_price) " +
            "VALUES (#{odId}, #{miId}, #{fiId}, #{odState}, #{odPayPrice})")
    Integer insertOrderDetail(Order_Detail orderDetail);

    // 自定义方法：更新 Order_Detail
    @Update("UPDATE order_detail SET mi_id = #{miId}, fi_id = #{fiId}, od_state = #{odState}, od_pay_price = #{odPayPrice} " +
            "WHERE od_id = #{odId}")
    Integer updateOrderDetail(Order_Detail orderDetail);

    // 自定义方法：根据 odId 删除 Order_Detail
    @Delete("DELETE FROM order_detail WHERE od_id = #{odId}")
    Integer deleteByOdId(Integer odId);

    // 自定义方法：查询所有 Order_Detail 列表
    @Select("SELECT * FROM order_detail")
    List<Order_Detail> selectAllOrderDetails();
}
