package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tzb.Mapper.Client_Info_Mapper;
import tzb.Pojo.Client_Info;
import java.util.List;
import java.util.Map;

@Service
public class Client_Info_Service_Impl implements Client_Info_Service {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client_Info> selectAllClients() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("CALL GetAllClientInfo()");
        return rows.stream().map(row -> {
            Client_Info clientInfo = new Client_Info(1, "default", 0, "default", "default", "default");
            clientInfo.setCiId((int) row.get("ci_id"));
            clientInfo.setCiName((String) row.get("ci_name"));
            clientInfo.setCiAge((int) row.get("ci_age"));
            clientInfo.setCiPhoneNumber((String) row.get("ci_phone_number"));
            clientInfo.setCiEmail((String) row.get("ci_email"));
            clientInfo.setCiAddress((String) row.get("ci_address"));
            return clientInfo;
        }).toList();
    }
    @Autowired
    private Client_Info_Mapper client_info_mapper;

    @Override
    public Client_Info selectByCiId(Integer ci_id) {
        return client_info_mapper.selectByCiId(ci_id);
    }

    @Override
    public Integer insertDefaultCLient(Client_Info clientInfo) {
        return client_info_mapper.insertDefaultCLient(clientInfo);
    }

    @Override
    public Integer insertClient(Client_Info clientInfo) {
        return client_info_mapper.insertClient(clientInfo);
    }

    @Override
    public Integer updateClient(Client_Info clientInfo) {
        return client_info_mapper.updateClient(clientInfo);
    }

    @Override
    public int deleteByCiId(Integer ci_id) {
        return client_info_mapper.deleteByCiId(ci_id);
    }

//    @Override
//    public List<Client_Info> selectAllClients() {
//        return client_info_mapper.selectAllClients();
//    }
}
