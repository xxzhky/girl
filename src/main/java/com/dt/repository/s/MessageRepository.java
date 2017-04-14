package com.dt.repository.s;

import com.dt.domain.s.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RID on 2017/4/14.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
