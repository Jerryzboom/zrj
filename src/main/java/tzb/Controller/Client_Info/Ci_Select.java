package tzb.Controller.Client_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Service.Client_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client_info")
public class Ci_Select {
    @Autowired
    private Client_Info_Service_Impl client_info_service_impl;

    @PostMapping("/select_All_Client_Info")
    public List<Client_Info> select_All_Client_Info() {
        return client_info_service_impl.selectAllClients();
    }

    @PostMapping("/select_Client_Info_By_Serach_Value")
    public List<Client_Info> select_Client_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Client_Info> list = client_info_service_impl.selectAllClients();
        List<Client_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Client_Info client_info : list) {
            if(csv.check_search_val(client_info.getCiAge().toString(), searchValue) || csv.check_search_val(client_info.getCiId().toString(), searchValue) || csv.check_search_val(client_info.getCiEmail(), searchValue) || csv.check_search_val(client_info.getCiAddress(), searchValue) || csv.check_search_val(client_info.getCiName(), searchValue) || csv.check_search_val(client_info.getCiPhoneNumber(), searchValue)) {
                ans.add(client_info);
            }
        }
        return ans;
    }
}
