package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Identity_Info;
import java.util.List;
@Service
public interface Identity_Info_Service {

    // 自定义方法：根据 iiId 查询 Identity_Info
    Identity_Info selectByIiId(Integer iiId);

    // 自定义方法：插入新的 Identity_Info
    Integer insertIdentity(Identity_Info identityInfo);

    // 自定义方法：更新 Identity_Info
    Integer updateIdentity(Identity_Info identityInfo);

    // 自定义方法：根据 iiId 删除 Identity_Info
    Integer deleteByIiId(Integer iiId);

    // 自定义方法：查询所有 Identity_Info 列表
    List<Identity_Info> selectAllIdentities();
}
