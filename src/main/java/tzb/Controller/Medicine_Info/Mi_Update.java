package tzb.Controller.Medicine_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Medicine_Info;
import tzb.Pojo.Medicine_Info;
import tzb.Service.Medicine_Info_Service_Impl;

@RestController
@RequestMapping("/medicine_info")
public class Mi_Update {
    @Autowired
    private Medicine_Info_Service_Impl medicine_info_service_impl;
    @PostMapping("/update_Medicine_Info_By_miId")
    public ResponseEntity<Integer> updateMedicine(@RequestBody Medicine_Info MedicineInfo) {
        Integer result = medicine_info_service_impl.updateMedicine(MedicineInfo);
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
