package com.tyw.mongodb;

import com.tyw.domian.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author : tboss
 * @description : TODO
 * @date : 2018/10/22
 */


public interface  UserMongoDB extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
