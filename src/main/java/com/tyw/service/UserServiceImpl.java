package com.tyw.service;

/*import com.tyw.db.DataSourceEnum;
import com.tyw.db.DynamicDataSource;*/

import com.tyw.domian.User;
import com.tyw.repository.master.UserRepositoryMaster;
import com.tyw.repository.slave.UserRepositorySlave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/*import static com.tyw.db.DynamicDataSource.getDataSource;*/

/**
 * Created by tboss on 2017/11/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryMaster master;
    @Autowired
    private UserRepositorySlave slave;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public User findOne(Integer id){
        /*DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
        User user = userRepository.findOne(id);
        DynamicDataSource.clearDataSource();*/
        User user = redisTemplate.opsForValue().get(id+"");
        if(user == null ){
            user = slave.findOne(id);
        }
        return user;
    }

    @Override
    @Transactional
    public User save(User user) {
        /*DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
        User users = userRepository.save(user);
        DynamicDataSource.clearDataSource();*/
        User users = master.save(user);
        redisTemplate.opsForValue().set(user.getId().toString(), user);
        return users;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        /*DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
        userRepository.delete(id);
        DynamicDataSource.clearDataSource();*/
        master.delete(id);
    }

    @Override
    public List<User> findAll() {
       /* System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+getDataSource());
        DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        List<User> list = userRepository.findAll();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+getDataSource());
        DynamicDataSource.clearDataSource();*/
        List<User> list = slave.findAll();
        return list;
    }
}
