package com.tyw;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tboss on 2017/11/10.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long Id;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Integer state;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User() {
    }
}