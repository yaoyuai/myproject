package com.course.service.impl;

import com.course.mapper.ChooseInfoMapper;
import com.course.mapper.ExerInfoMapper;
import com.course.qo.ChooseInfoQo;
import com.course.qo.ExerInfoQo;
import com.course.service.ChooseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChooseInfoServiceImpl  implements ChooseInfoService {

    @Autowired
    private ChooseInfoMapper chooseInfoMapper;
    @Autowired
    private ExerInfoMapper exerInfoMapper;

    @Override
    public int addChoose(String[] chooseContent, String exerId,String exerAnswer) {

        int result=0;
        String str="";
        ExerInfoQo exerInfoQo=new ExerInfoQo();
        if(exerAnswer==null || exerAnswer.equals("")){



        }else{
            String[] split = exerAnswer.split(",");
            List<Integer> integerList=new ArrayList<>();

            for (String s : chooseContent) {
                ChooseInfoQo chooseInfoQo=new ChooseInfoQo();
                chooseInfoQo.setChooseContent(s);
                chooseInfoQo.setExerId(exerId);
                result=chooseInfoMapper.addChoose(chooseInfoQo);
                int id=chooseInfoMapper.selectMaxId();
                integerList.add(id);
            }

            for(int i=0;i<split.length;i++){
                str+=integerList.get(Integer.parseInt(split[i])-1);
                if(i!=split.length-1){
                    str+=",";
                }
            }
            exerInfoQo.setExerAnswer(str);
        }

        exerInfoQo.setExerId(exerId);
        result= exerInfoMapper.updateAnswer(exerInfoQo);
        return result;
    }
}
