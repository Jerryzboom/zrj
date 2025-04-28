package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Order_Record_Mapper;
import tzb.Pojo.Order_Record;
import tzb.Service.Order_Record_Service;

import java.util.List;

@Service
public class Order_Record_Service_Impl implements Order_Record_Service {

    @Autowired
    private Order_Record_Mapper orderRecordMapper;

    @Override
    public Order_Record selectByOrId(Integer orId) {
        return orderRecordMapper.selectByOrId(orId);
    }

    @Override
    public Integer insertOrderRecord(Order_Record orderRecord) {
        return orderRecordMapper.insertOrderRecord(orderRecord);
    }

    @Override
    public Integer updateOrderRecord(Order_Record orderRecord) {
        return orderRecordMapper.updateOrderRecord(orderRecord);
    }

    @Override
    public Integer deleteByOrId(Integer orId) {
        return orderRecordMapper.deleteByOrId(orId);
    }

    @Override
    public List<Order_Record> selectAllOrderRecords() {
        return orderRecordMapper.selectAllOrderRecords();
    }
}
