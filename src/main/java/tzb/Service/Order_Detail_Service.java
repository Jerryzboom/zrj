package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Order_Detail;
import java.util.List;
@Service
public interface Order_Detail_Service{

    // 自定义方法：根据 odId 查询 Order_Detail
    Order_Detail selectByOdId(Integer odId);

    // 自定义方法：插入新的 Order_Detail
    Integer insertOrderDetail(Order_Detail orderDetail);

    // 自定义方法：更新 Order_Detail
    Integer updateOrderDetail(Order_Detail orderDetail);

    // 自定义方法：根据 odId 删除 Order_Detail
    Integer deleteByOdId(Integer odId);

    // 自定义方法：查询所有 Order_Detail 列表
    List<Order_Detail> selectAllOrderDetails();
}
