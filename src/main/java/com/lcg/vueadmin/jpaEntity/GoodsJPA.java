package com.lcg.vueadmin.jpaEntity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpa_goods")
@Data
public class GoodsJPA {

    @GeneratedValue
    @Id
    private long id;

    private String goodsName;

    private long userId;

    private String brandName;
}
