package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Identity_Info_Mapper;
import tzb.Pojo.Identity_Info;
import java.util.List;

@Service
public class Identity_Info_Service_Impl implements Identity_Info_Service {

    @Autowired
    private Identity_Info_Mapper identity_info_mapper;

    @Override
    public Identity_Info selectByIiId(Integer iiId) {
        return identity_info_mapper.selectByIiId(iiId);
    }

    @Override
    public Integer insertIdentity(Identity_Info identityInfo) {
        return identity_info_mapper.insertIdentity(identityInfo);
    }

    @Override
    public Integer updateIdentity(Identity_Info identityInfo) {
        return identity_info_mapper.updateIdentity(identityInfo);
    }

    @Override
    public Integer deleteByIiId(Integer iiId) {
        return identity_info_mapper.deleteByIiId(iiId);
    }

    @Override
    public List<Identity_Info> selectAllIdentities() {
        return identity_info_mapper.selectAllIdentities();
    }
}
