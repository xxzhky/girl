package com.dt.servive;

import com.dt.domain.Girl;
import com.dt.domain.Result;
import com.dt.enums.ResultEnum;
import com.dt.exception.GirlException;
import com.dt.repository.GirlRepository;
import com.dt.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by RID on 2017/4/12.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void batchSave() {
        Girl girl= new Girl();
        girl.setAge(21);
        girl.setCupSize("F");
        girlRepository.save(girl);

        Girl girl2= new Girl();
        girl2.setAge(22);
        girl2.setCupSize("E");
        girlRepository.save(girl2);

    }

    public Result getAge(Integer id){

        Girl girl= girlRepository.findOne(id);
        int age= girl.getAge();
        if (age<10){
            //throw new GirlException(100,"the girl in the primary school.");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>=10&& age<16){
//            throw new GirlException(200,"the girl in the middle school.");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            return ResultUtil.ok(girl);
        }
    }

    public Girl findOneGirl(Integer id){

        return girlRepository.findOne(id);

    }

}
