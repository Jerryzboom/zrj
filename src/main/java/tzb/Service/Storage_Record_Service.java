package tzb.Service;

import tzb.Pojo.Storage_Record;

import java.util.List;

public interface Storage_Record_Service {

    // 自定义方法：根据 srId 查询 Storage_Record
    Storage_Record selectBySrId(Integer srId);

    // 自定义方法：插入新的 Storage_Record
    Integer insertStorageRecord(Storage_Record storageRecord);

    // 自定义方法：更新 Storage_Record
    Integer updateStorageRecord(Storage_Record storageRecord);

    // 自定义方法：根据 srId 删除 Storage_Record
    Integer deleteBySrId(Integer srId);

    // 自定义方法：查询所有 Storage_Record 列表
    List<Storage_Record> selectAllStorageRecords();
}
