package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Client_Info;

import java.util.List;

@Service
public interface Client_Info_Service {
    // 自定义方法：根据 ci_id 查询 Client_Info
    Client_Info selectByCiId(Integer ci_id);
    Integer insertDefaultCLient(Client_Info clientInfo);
    // 自定义方法：插入新的 Client_Info
    Integer insertClient(Client_Info clientInfo);

    // 自定义方法：更新 Client_Info
    Integer updateClient(Client_Info clientInfo);

    // 自定义方法：根据 ci_id 删除 Client_Info
    int deleteByCiId(Integer ci_id);

    // 自定义方法：查询所有 Client_Info 列表
    List<Client_Info> selectAllClients();
}
