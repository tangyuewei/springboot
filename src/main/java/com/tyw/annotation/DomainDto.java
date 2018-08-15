package com.tyw.annotation;
/*
* @Description :
* @Date : 2018/8/14  16:30  
* */
@Table("user")
public class DomainDto {
    @Column("id")
    private String id;

    @Column("username")
    private String name;

    @Column("password")
    private String password;

    public DomainDto(String id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
