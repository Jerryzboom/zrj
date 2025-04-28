package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Medicine_Info_Mapper;
import tzb.Pojo.Medicine_Info;
import java.util.List;

@Service
public class Medicine_Info_Service_Impl implements Medicine_Info_Service {

    @Autowired
    private Medicine_Info_Mapper medicine_info_mapper;

    @Override
    public Medicine_Info selectByMiId(Integer miId) {
        return medicine_info_mapper.selectByMiId(miId);
    }

    @Override
    public Integer insertMedicine(Medicine_Info medicineInfo) {
        return medicine_info_mapper.insertMedicine(medicineInfo);
    }

    @Override
    public Integer updateMedicine(Medicine_Info medicineInfo) {
        return medicine_info_mapper.updateMedicine(medicineInfo);
    }

    @Override
    public Integer deleteByMiId(Integer miId) {
        return medicine_info_mapper.deleteByMiId(miId);
    }

    @Override
    public List<Medicine_Info> selectAllMedicines() {
        return medicine_info_mapper.selectAllMedicines();
    }
}
