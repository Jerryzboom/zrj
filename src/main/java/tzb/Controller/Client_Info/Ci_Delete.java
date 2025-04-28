package tzb.Controller.Client_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Service.Client_Info_Service_Impl;

import java.util.List;

@RestController
@RequestMapping("/client_info")
public class Ci_Delete {
    @Autowired
    private Client_Info_Service_Impl client_info_service_impl;

    @PostMapping("/delete_Client_Info_By_ciId")
    public ResponseEntity<Integer> updateClient(@RequestBody Client_Info clientInfo) {
        Integer result = client_info_service_impl.deleteByCiId(clientInfo.getCiId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
