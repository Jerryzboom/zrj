package tzb.Controller.Store_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Store_Info;
import tzb.Service.Store_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store_info")
public class Si_Select {
    @Autowired
    private Store_Info_Service_Impl store_info_service_impl;

    @PostMapping("/select_All_Store_Info")
    public List<Store_Info> select_All_Store_Info() {
        return store_info_service_impl.selectAllStoreInfos();
    }

    @PostMapping("/select_Store_Info_By_Serach_Value")
    public List<Store_Info> select_Store_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Store_Info> list = store_info_service_impl.selectAllStoreInfos();
        List<Store_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Store_Info store_info : list) {
            if(csv.check_search_val(store_info.getSiId().toString(), searchValue) || csv.check_search_val(store_info.getSiMiNumber().toString(), searchValue)) {
                ans.add(store_info);
            }
        }
        return ans;
    }
}
