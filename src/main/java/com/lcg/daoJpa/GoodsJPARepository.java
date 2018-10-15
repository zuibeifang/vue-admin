package com.lcg.daoJpa;

import com.lcg.jpaEntity.GoodsJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsJPARepository extends JpaRepository<GoodsJPA,Long> {
}
