package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Order_Record;

import java.util.List;
@Service
public interface Order_Record_Service {

    // 自定义方法：根据 orId 查询 Order_Record
    Order_Record selectByOrId(Integer orId);

    // 自定义方法：插入新的 Order_Record
    Integer insertOrderRecord(Order_Record orderRecord);

    // 自定义方法：更新 Order_Record
    Integer updateOrderRecord(Order_Record orderRecord);

    // 自定义方法：根据 orId 删除 Order_Record
    Integer deleteByOrId(Integer orId);

    // 自定义方法：查询所有 Order_Record 列表
    List<Order_Record> selectAllOrderRecords();
}
