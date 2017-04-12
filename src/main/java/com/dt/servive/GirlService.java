package com.dt.servive;

import com.dt.domain.Girl;
import com.dt.repository.GirlRepository;
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
}
