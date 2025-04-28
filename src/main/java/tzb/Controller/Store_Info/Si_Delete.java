package tzb.Controller.Store_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Store_Info;
import tzb.Service.Store_Info_Service_Impl;

import java.util.List;

@RestController
@RequestMapping("/store_info")
public class Si_Delete {
    @Autowired
    private Store_Info_Service_Impl store_info_service_impl;

    @PostMapping("/delete_Store_Info_By_siId")
    public ResponseEntity<Integer> updateStore(@RequestBody Store_Info storeInfo) {
        Integer result = store_info_service_impl.deleteBySiId(storeInfo.getSiId());
        if (result != 1) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
