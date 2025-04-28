package tzb.Controller.Identity_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Identity_Info;
import tzb.Pojo.Identity_Info;
import tzb.Service.Identity_Info_Service_Impl;

@RestController
@RequestMapping("/identity_info")
public class Ii_Update {
    @Autowired
    private Identity_Info_Service_Impl identity_info_service_impl;
    @PostMapping("/update_Identity_Info_By_iiId")
    public ResponseEntity<Integer> updateIdentity(@RequestBody Identity_Info IdentityInfo) {
        Integer result = identity_info_service_impl.updateIdentity(IdentityInfo);
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
