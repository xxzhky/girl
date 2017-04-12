package com.dt.controller;

import com.dt.domain.Girl;
import com.dt.domain.Result;
import com.dt.repository.GirlRepository;
import com.dt.servive.GirlService;
import com.dt.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by RID on 2017/4/12.
 */
@RestController
public class GirlController {

    private Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> GirlsList(){
        return girlRepository.findAll();
    }


    @PostMapping("/girls")
    public Girl girlAdd (@RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){
        Girl girl= new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);

    }

    @PostMapping("/girlsin")
    public Result<Girl> girlAdd1 (@Valid Girl girl, BindingResult bindingResult){
        //Result result= new Result();
        if (bindingResult.hasErrors()){
            String errMsg=bindingResult.getFieldError().getDefaultMessage();
            logger.error(errMsg);

            return ResultUtil.err(-1, errMsg);
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.ok(girlRepository.save(girl));

    }

    @GetMapping("/girls/{id}")
    public Girl queryGirl (@PathVariable("id") Integer id){

        return girlRepository.findOne(id);
    }

    @PutMapping("/girls/{id}")
    public Girl updateGirl (@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){

        Girl girl= new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void delGirl (@PathVariable("id") Integer id){

         girlRepository.delete(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> queryByGirlAge (@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }


    @GetMapping("/girls/save2")
    public void GirlsSave(){
        girlService.batchSave();
    }


    @GetMapping("/girls/getage/{id}")
    public Result getGirlAge(@PathVariable("id") Integer id){
        return girlService.getAge(id);
    }

}
