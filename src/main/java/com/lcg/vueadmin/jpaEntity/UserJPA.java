package com.lcg.vueadmin.jpaEntity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpa_user")
@Data
public class UserJPA {
    @Id
    @GeneratedValue
    private long id;

    private String userName;

    private String password;

    private long userId;
}
