package com.tyw.repository.master;

import com.tyw.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tboss on 2017/11/10.
 */

public interface UserRepositoryMaster extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

}
