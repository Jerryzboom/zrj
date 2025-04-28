package tzb.Controller.Medicine_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Pojo.Medicine_Info;
import tzb.Service.Medicine_Info_Service_Impl;

@RestController
@RequestMapping("/medicine_info")
public class Mi_Delete {
    @Autowired
    private Medicine_Info_Service_Impl medicine_info_service_impl;
    @PostMapping("/delete_Medicine_Info_By_miId")
    public ResponseEntity<Integer> updateClient(@RequestBody Medicine_Info medicineInfo) {
        Integer result = medicine_info_service_impl.deleteByMiId(medicineInfo.getFiId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
