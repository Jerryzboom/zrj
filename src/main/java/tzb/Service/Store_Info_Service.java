package tzb.Service;

import tzb.Pojo.Store_Info;

import java.util.List;

public interface Store_Info_Service {

    // 自定义方法：根据 siId 查询 Store_Info
    Store_Info selectBySiId(Integer siId);

    // 自定义方法：插入新的 Store_Info
    Integer insertStoreInfo(Store_Info storeInfo);

    // 自定义方法：更新 Store_Info
    Integer updateStoreInfo(Store_Info storeInfo);

    // 自定义方法：根据 siId 删除 Store_Info
    Integer deleteBySiId(Integer siId);

    // 自定义方法：查询所有 Store_Info 列表
    List<Store_Info> selectAllStoreInfos();
}
