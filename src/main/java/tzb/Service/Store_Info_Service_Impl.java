package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Store_Info_Mapper;
import tzb.Pojo.Store_Info;
import tzb.Service.Store_Info_Service;

import java.util.List;

@Service
public class Store_Info_Service_Impl implements Store_Info_Service {

    @Autowired
    private Store_Info_Mapper storeInfoMapper;

    @Override
    public Store_Info selectBySiId(Integer siId) {
        return storeInfoMapper.selectBySiId(siId);
    }

    @Override
    public Integer insertStoreInfo(Store_Info storeInfo) {
        return storeInfoMapper.insertStoreInfo(storeInfo);
    }

    @Override
    public Integer updateStoreInfo(Store_Info storeInfo) {
        return storeInfoMapper.updateStoreInfo(storeInfo);
    }

    @Override
    public Integer deleteBySiId(Integer siId) {
        return storeInfoMapper.deleteBySiId(siId);
    }

    @Override
    public List<Store_Info> selectAllStoreInfos() {
        return storeInfoMapper.selectAllStoreInfos();
    }
}
