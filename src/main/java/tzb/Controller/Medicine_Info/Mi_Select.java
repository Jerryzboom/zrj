package tzb.Controller.Medicine_Info;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Medicine_Info;
import tzb.Service.Medicine_Info_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicine_info")
public class Mi_Select {
    @Autowired
    private Medicine_Info_Service_Impl medicine_info_service_impl;

    @PostMapping("/select_All_Medicine_Info")
    public List<Medicine_Info> select_All_Medicine_Info() {
        return medicine_info_service_impl.selectAllMedicines();
    }

    @PostMapping("/select_Medicine_Info_By_Serach_Value")
    public List<Medicine_Info> select_Medicine_Info_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Medicine_Info> list = medicine_info_service_impl.selectAllMedicines();
        List<Medicine_Info> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Medicine_Info medicine_info : list) {
            if(csv.check_search_val(medicine_info.getMiId().toString(), searchValue) || csv.check_search_val(medicine_info.getMiDose(), searchValue) || csv.check_search_val(medicine_info.getMiName(), searchValue) || csv.check_search_val(medicine_info.getMiStorageState().toString(), searchValue) || csv.check_search_val(String.valueOf(medicine_info.getMiBornDate()), searchValue) || csv.check_search_val(String.valueOf(medicine_info.getMiExpiry()), searchValue) || csv.check_search_val(medicine_info.getMiPiciNumber(), searchValue) || csv.check_search_val(medicine_info.getMiType(), searchValue) || csv.check_search_val(medicine_info.getMiPurchasePrice().toString(), searchValue) || csv.check_search_val(medicine_info.getMiSalePrice().toString(), searchValue)) {
                ans.add(medicine_info);
            }
        }
        return ans;
    }
}
