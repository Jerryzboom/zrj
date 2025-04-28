package tzb.Controller.Order_Detail;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Order_Detail;
import tzb.Service.Order_Detail_Service_Impl;
import tzb.Utils.Check_Search_Val;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order_detail")
public class Od_Select {
    @Autowired
    private Order_Detail_Service_Impl order_detail_service_impl;

    @PostMapping("/select_All_Order_Detail")
    public List<Order_Detail> select_All_Order_Detail() {
        return order_detail_service_impl.selectAllOrderDetails();
    }

    @PostMapping("/select_Order_Detail_By_Serach_Value")
    public List<Order_Detail> select_Order_Detail_By_Serach_Value(HttpServletRequest request) {
        String searchValue = request.getParameter("searchValue");
        List<Order_Detail> list = order_detail_service_impl.selectAllOrderDetails();
        List<Order_Detail> ans = new ArrayList<>();
        Check_Search_Val csv = new Check_Search_Val();
        for(Order_Detail order_detail : list) {
            if(csv.check_search_val(order_detail.getOdPayPrice().toString(), searchValue) || csv.check_search_val(order_detail.getOdId().toString(), searchValue) ) {
                ans.add(order_detail);
            }
        }
        return ans;
    }
}
