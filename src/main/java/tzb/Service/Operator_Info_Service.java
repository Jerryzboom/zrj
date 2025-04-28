package tzb.Service;

import org.springframework.stereotype.Service;
import tzb.Pojo.Operator_Info;

import java.util.List;
@Service
public interface Operator_Info_Service {

    // 自定义方法：根据 oi_id 查询 Operator_Info
    Operator_Info selectByOiId(Integer oiId);

    // 自定义方法：插入新的 Operator_Info
    Integer insertOperator(Operator_Info operatorInfo);

    // 自定义方法：更新 Operator_Info
    Integer updateOperator(Operator_Info operatorInfo);

    // 自定义方法：根据 oi_id 删除 Operator_Info
    Integer deleteByOiId(Integer oiId);

    // 自定义方法：查询所有 Operator_Info 列表
    List<Operator_Info> selectAllOperators();
}
