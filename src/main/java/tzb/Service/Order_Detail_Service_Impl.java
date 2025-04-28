package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Order_Detail_Mapper;
import tzb.Pojo.Order_Detail;
import tzb.Service.Order_Detail_Service;

import java.util.List;

@Service
public class Order_Detail_Service_Impl implements Order_Detail_Service {

    @Autowired
    private Order_Detail_Mapper orderDetailMapper;

    @Override
    public Order_Detail selectByOdId(Integer odId) {
        return orderDetailMapper.selectByOdId(odId);
    }

    @Override
    public Integer insertOrderDetail(Order_Detail orderDetail) {
        return orderDetailMapper.insertOrderDetail(orderDetail);
    }

    @Override
    public Integer updateOrderDetail(Order_Detail orderDetail) {
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }

    @Override
    public Integer deleteByOdId(Integer odId) {
        return orderDetailMapper.deleteByOdId(odId);
    }

    @Override
    public List<Order_Detail> selectAllOrderDetails() {
        return orderDetailMapper.selectAllOrderDetails();
    }
}
