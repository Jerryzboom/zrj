package tzb.Controller.Operator_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Operator_Info;
import tzb.Service.Operator_Info_Service_Impl;

import java.util.List;

@RestController
@RequestMapping("/operator_info")
public class Oi_Update {
    @Autowired
    private Operator_Info_Service_Impl operator_info_service_impl;

    @PostMapping("/update_Operator_Info_By_oiId")
    public ResponseEntity<Integer> updateOperator(@RequestBody Operator_Info operatorInfo) {
        Integer result = operator_info_service_impl.updateOperator(operatorInfo);
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
