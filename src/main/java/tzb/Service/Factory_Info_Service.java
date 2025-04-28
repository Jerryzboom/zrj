package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Factory_Info;
import java.util.List;
@Service
public interface Factory_Info_Service {

    // 自定义方法：根据 fiId 查询 Factory_Info
    Factory_Info selectByFiId(Integer fiId);

    // 自定义方法：插入新的 Factory_Info
    Integer insertFactory(Factory_Info factoryInfo);

    // 自定义方法：更新 Factory_Info
    Integer updateFactory(Factory_Info factoryInfo);

    // 自定义方法：根据 fiId 删除 Factory_Info
    Integer deleteByFiId(Integer fiId);

    // 自定义方法：查询所有 Factory_Info 列表
    List<Factory_Info> selectAllFactories();
}
