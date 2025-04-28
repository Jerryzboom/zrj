package tzb.Controller.Identity_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Identity_Info;
import tzb.Service.Identity_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/identity_info")
public class Ii_Select {
    @Autowired
    private Identity_Info_Service_Impl identity_info_service_impl;

    @PostMapping("/select_All_Identity_Info")
    public List<Identity_Info> select_All_Identity_Info() {
        return identity_info_service_impl.selectAllIdentities();
    }

    @PostMapping("/select_Identity_Info_By_Serach_Value")
    public List<Identity_Info> select_Identity_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Identity_Info> list = identity_info_service_impl.selectAllIdentities();
        List<Identity_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Identity_Info identity_info : list) {
            if(csv.check_search_val(identity_info.getIiId().toString(), searchValue) || csv.check_search_val(identity_info.getIiType(), searchValue)) {
                ans.add(identity_info);
            }
        }
        return ans;
    }
}
