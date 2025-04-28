package tzb.Controller.Client_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.Pojo.Client_Info;
import tzb.Service.Client_Info_Service_Impl;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/client_info")
public class Ci_Insert {
    @Autowired
    private Client_Info_Service_Impl client_info_service_impl;
    @PostMapping("/insertClient")
    public Integer insertDefaultClient(@RequestBody Client_Info client_info) {
        List<Client_Info> list = client_info_service_impl.selectAllClients();
        HashSet<Integer> set = new HashSet<>();
        for (Client_Info ci : list) {
            set.add(ci.getCiId());
        }
        int mex = 1;
        while(set.contains(mex)) {
            mex += 1;
        }
        client_info.setCiId(mex);
        return client_info_service_impl.insertClient(client_info);
    }
}
