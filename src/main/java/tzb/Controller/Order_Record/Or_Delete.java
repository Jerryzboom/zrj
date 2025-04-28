package tzb.Controller.Order_Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Order_Record;
import tzb.Service.Order_Record_Service_Impl;


@RestController
@RequestMapping("/order_record")
public class Or_Delete {
    @Autowired
    private Order_Record_Service_Impl order_record_service_impl;

    @PostMapping("/delete_Order_Record_By_orId")
    public ResponseEntity<Integer> updateOrder(@RequestBody Order_Record orderRecord) {
        Integer result = order_record_service_impl.deleteByOrId(orderRecord.getOrId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
