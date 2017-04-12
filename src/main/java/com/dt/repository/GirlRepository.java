package com.dt.repository;

import com.dt.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by RID on 2017/4/12.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{


    public List<Girl> findByAge(Integer age);
}
