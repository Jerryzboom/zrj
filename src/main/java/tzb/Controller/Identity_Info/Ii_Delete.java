package tzb.Controller.Identity_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Pojo.Identity_Info;
import tzb.Service.Identity_Info_Service_Impl;

@RestController
@RequestMapping("/identity_info")
public class Ii_Delete {
    @Autowired
    private Identity_Info_Service_Impl identity_info_service_impl;
    @PostMapping("/delete_Identity_Info_By_iiId")
    public ResponseEntity<Integer> updateClient(@RequestBody Identity_Info identityInfo) {
        Integer result = identity_info_service_impl.deleteByIiId(identityInfo.getIiId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
