package tzb.Controller.Order_Record;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Order_Record;
import tzb.Service.Order_Record_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order_record")
public class Or_Select {
    @Autowired
    private Order_Record_Service_Impl order_record_service_impl;

    @PostMapping("/select_All_Order_Record")
    public List<Order_Record> select_All_Order_Record() {
        return order_record_service_impl.selectAllOrderRecords();
    }

    @PostMapping("/select_Order_Record_By_Serach_Value")
    public List<Order_Record> select_Order_Record_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Order_Record> list = order_record_service_impl.selectAllOrderRecords();
        List<Order_Record> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Order_Record order_record : list) {
            if(csv.check_search_val(String.valueOf(order_record.getOrSaleDate()), searchValue) || csv.check_search_val(order_record.getOrId().toString(), searchValue) || csv.check_search_val(order_record.getOrAllPrice().toString(), searchValue)) {
                ans.add(order_record);
            }
        }
        return ans;
    }
}
