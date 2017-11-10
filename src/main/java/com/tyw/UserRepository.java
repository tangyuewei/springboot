package com.tyw;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tboss on 2017/11/10.
 */

public interface UserRepository extends JpaRepository<User,Integer> {

}
