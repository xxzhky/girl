package com.dt.repository.p;

import com.dt.domain.p.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RID on 2017/4/14.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
