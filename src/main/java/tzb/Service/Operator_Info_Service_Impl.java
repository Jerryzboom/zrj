package tzb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.Mapper.Operator_Info_Mapper;
import tzb.Pojo.Operator_Info;
import tzb.Service.Operator_Info_Service;

import java.util.List;

@Service
public class Operator_Info_Service_Impl implements Operator_Info_Service {

    @Autowired
    private Operator_Info_Mapper operatorInfoMapper;

    @Override
    public Operator_Info selectByOiId(Integer oiId) {
        return operatorInfoMapper.selectByOiId(oiId);
    }

    @Override
    public Integer insertOperator(Operator_Info operatorInfo) {
        return operatorInfoMapper.insertOperator(operatorInfo);
    }

    @Override
    public Integer updateOperator(Operator_Info operatorInfo) {
        return operatorInfoMapper.updateOperator(operatorInfo);
    }

    @Override
    public Integer deleteByOiId(Integer oiId) {
        return operatorInfoMapper.deleteByOiId(oiId);
    }

    @Override
    public List<Operator_Info> selectAllOperators() {
        return operatorInfoMapper.selectAllOperators();
    }
}
