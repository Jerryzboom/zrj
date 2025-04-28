package tzb.Controller.Factory_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Factory_Info;
import tzb.Service.Factory_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/factory_info")
public class Fi_Select {
    @Autowired
    private Factory_Info_Service_Impl factory_info_service_impl;

    @PostMapping("/select_All_Factory_Info")
    public List<Factory_Info> select_All_Factory_Info() {
        return factory_info_service_impl.selectAllFactories();
    }

    @PostMapping("/select_Factory_Info_By_Serach_Value")
    public List<Factory_Info> select_Factory_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Factory_Info> list = factory_info_service_impl.selectAllFactories();
        List<Factory_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Factory_Info factory_info : list) {
            if(csv.check_search_val(factory_info.getFiId().toString(), searchValue) || csv.check_search_val(factory_info.getFiAddress(), searchValue) || csv.check_search_val(factory_info.getFiName(), searchValue) || csv.check_search_val(factory_info.getFiPhoneNumber(), searchValue)) {
                ans.add(factory_info);
            }
        }
        return ans;
    }
}
