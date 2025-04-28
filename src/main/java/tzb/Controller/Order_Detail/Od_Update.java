package tzb.Controller.Order_Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Order_Detail;
import tzb.Service.Order_Detail_Service_Impl;

import java.util.List;

@RestController
@RequestMapping("/order_detail")
public class Od_Update {
    @Autowired
    private Order_Detail_Service_Impl order_detail_service_impl;

    @PostMapping("/update_Order_Detail_By_odId")
    public ResponseEntity<Integer> updateOrder(@RequestBody Order_Detail orderDetail) {
        Integer result = order_detail_service_impl.updateOrderDetail(orderDetail);
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
