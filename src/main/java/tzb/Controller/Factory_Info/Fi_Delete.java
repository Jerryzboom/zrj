package tzb.Controller.Factory_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Pojo.Factory_Info;
import tzb.Service.Factory_Info_Service_Impl;

@RestController
@RequestMapping("/factory_info")
public class Fi_Delete {
    @Autowired
    private Factory_Info_Service_Impl factory_info_service_impl;
    @PostMapping("/delete_Factory_Info_By_fiId")
    public ResponseEntity<Integer> updateClient(@RequestBody Factory_Info factoryInfo) {
        Integer result = factory_info_service_impl.deleteByFiId(factoryInfo.getFiId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
