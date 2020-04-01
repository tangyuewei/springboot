package com.tyw.domian;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tboss on 2017/11/10.
 */
@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer Id;
    private String username;
    private String password;
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date update_time;
    /**
     * @see com.tyw.domian.UserState
     * */
    private String state;

}
