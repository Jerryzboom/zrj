package tzb.Controller.Factory_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Factory_Info;
import tzb.Pojo.Factory_Info;
import tzb.Service.Factory_Info_Service_Impl;

@RestController
@RequestMapping("/factory_info")
public class Fi_Update {
    @Autowired
    private Factory_Info_Service_Impl factory_info_service_impl;
    @PostMapping("/update_Factory_Info_By_fiId")
    public ResponseEntity<Integer> updateFactory(@RequestBody Factory_Info FactoryInfo) {
        Integer result = factory_info_service_impl.updateFactory(FactoryInfo);
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
