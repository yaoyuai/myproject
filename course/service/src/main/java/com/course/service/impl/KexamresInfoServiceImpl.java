package com.course.service.impl;
import com.course.mapper.KexamresInfoMapper;
import com.course.mapper.ZcontentInfoMapper;
import com.course.pojo.KexamresInfo;
import com.course.qo.KexamresInfoQo;
import com.course.qo.ZcontentInfoQo;
import com.course.service.KexamresInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KexamresInfoServiceImpl implements KexamresInfoService {

    @Autowired
    private KexamresInfoMapper kexamresInfoMapper;
    @Autowired
    private ZcontentInfoMapper zcontentInfoMapper;

    @Override
    public int addKexamResInfo(KexamresInfoQo kexamresInfoQo) {
        if(kexamresInfoQo.getStudentId()==null){
            return -1;
        }
        if(kexamresInfoQo.getExamId()==null){
            return -1;
        }
        int result=kexamresInfoMapper.addKexamResInfo(kexamresInfoQo);
        if(kexamresInfoQo.getZexamContent()!=null){//判断是否有填空题
            String[] split = kexamresInfoQo.getZexamContent().split(",");
            for (String s : split) {
                String[] split1 = s.split("-");
                ZcontentInfoQo zcontentInfoQo=new ZcontentInfoQo();
                zcontentInfoQo.setStudentId(kexamresInfoQo.getStudentId());
                zcontentInfoQo.setExerId(split1[0]);
                zcontentInfoQo.setZcontentAnswer(split1[1]);
                zcontentInfoQo.setExamId(kexamresInfoQo.getExamId());
                result=zcontentInfoMapper.addZcontentInfo(zcontentInfoQo);
            }
        }
        return result;
    }

    @Override
    public KexamresInfo selectHasKexamInfo(KexamresInfoQo kexamresInfoQo) {
        return kexamresInfoMapper.selectHasKexamInfo(kexamresInfoQo);
    }

    @Override
    public int countZuoDaNum(KexamresInfoQo kexamresInfoQo) {
        return kexamresInfoMapper.countZuoDaNum(kexamresInfoQo);
    }

    @Override
    public List<Integer> sumAllScore(KexamresInfoQo kexamresInfoQo) {
        return kexamresInfoMapper.sumAllScore(kexamresInfoQo);
    }

    @Override
    public Integer sumOneExamScore(KexamresInfoQo kexamresInfoQo) {
        return kexamresInfoMapper.sumOneExamScore(kexamresInfoQo);
    }
}
