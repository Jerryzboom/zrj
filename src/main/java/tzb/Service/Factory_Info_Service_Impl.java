package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Factory_Info_Mapper;
import tzb.Pojo.Factory_Info;
import java.util.List;

@Service
public class Factory_Info_Service_Impl implements Factory_Info_Service {

    @Autowired
    private Factory_Info_Mapper factory_info_mapper;

    @Override
    public Factory_Info selectByFiId(Integer fiId) {
        return factory_info_mapper.selectByFiId(fiId);
    }

    @Override
    public Integer insertFactory(Factory_Info factoryInfo) {
        return factory_info_mapper.insertFactory(factoryInfo);
    }

    @Override
    public Integer updateFactory(Factory_Info factoryInfo) {
        return factory_info_mapper.updateFactory(factoryInfo);
    }

    @Override
    public Integer deleteByFiId(Integer fiId) {
        return factory_info_mapper.deleteByFiId(fiId);
    }

    @Override
    public List<Factory_Info> selectAllFactories() {
        return factory_info_mapper.selectAllFactories();
    }
}
