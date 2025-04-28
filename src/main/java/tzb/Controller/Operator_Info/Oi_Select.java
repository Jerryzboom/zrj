package tzb.Controller.Operator_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Operator_Info;
import tzb.Service.Operator_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operator_info")
public class Oi_Select {
    @Autowired
    private Operator_Info_Service_Impl operator_info_service_impl;

    @PostMapping("/select_All_Operator_Info")
    public List<Operator_Info> select_All_Operator_Info() {
        return operator_info_service_impl.selectAllOperators();
    }

    @PostMapping("/select_Operator_Info_By_Serach_Value")
    public List<Operator_Info> select_Operator_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Operator_Info> list = operator_info_service_impl.selectAllOperators();
        List<Operator_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Operator_Info operator_info : list) {
            if(csv.check_search_val(operator_info.getOiPassword(), searchValue) || csv.check_search_val(operator_info.getOiId().toString(), searchValue) || csv.check_search_val(operator_info.getOiEmail(), searchValue) || csv.check_search_val(operator_info.getOiAddress(), searchValue) || csv.check_search_val(operator_info.getOiName(), searchValue) || csv.check_search_val(operator_info.getOiPhoneNumber(), searchValue)) {
                ans.add(operator_info);
            }
        }
        return ans;
    }
}
