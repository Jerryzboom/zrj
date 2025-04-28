package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Storage_Record_Mapper;
import tzb.Pojo.Storage_Record;
import tzb.Service.Storage_Record_Service;

import java.util.List;

@Service
public class Storage_Record_Service_Impl implements Storage_Record_Service {

    @Autowired
    private Storage_Record_Mapper storageRecordMapper;

    @Override
    public Storage_Record selectBySrId(Integer srId) {
        return storageRecordMapper.selectBySrId(srId);
    }

    @Override
    public Integer insertStorageRecord(Storage_Record storageRecord) {
        return storageRecordMapper.insertStorageRecord(storageRecord);
    }

    @Override
    public Integer updateStorageRecord(Storage_Record storageRecord) {
        return storageRecordMapper.updateStorageRecord(storageRecord);
    }

    @Override
    public Integer deleteBySrId(Integer srId) {
        return storageRecordMapper.deleteBySrId(srId);
    }

    @Override
    public List<Storage_Record> selectAllStorageRecords() {
        return storageRecordMapper.selectAllStorageRecords();
    }
}
