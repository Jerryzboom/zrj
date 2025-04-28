package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Medicine_Info;
import java.util.List;
@Service
public interface Medicine_Info_Service {

    // 自定义方法：根据 miId 查询 Medicine_Info
    Medicine_Info selectByMiId(Integer miId);

    // 自定义方法：插入新的 Medicine_Info
    Integer insertMedicine(Medicine_Info medicineInfo);

    // 自定义方法：更新 Medicine_Info
    Integer updateMedicine(Medicine_Info medicineInfo);

    // 自定义方法：根据 miId 删除 Medicine_Info
    Integer deleteByMiId(Integer miId);

    // 自定义方法：查询所有 Medicine_Info 列表
    List<Medicine_Info> selectAllMedicines();
}
