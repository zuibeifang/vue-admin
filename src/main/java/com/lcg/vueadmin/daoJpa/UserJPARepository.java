package com.lcg.vueadmin.daoJpa;

import com.lcg.vueadmin.jpaEntity.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserJPARepository extends JpaRepository<UserJPA,Long> {

    //====================================================================
    /**
     * @Modifying注解的使用
     * （1）可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作。 注意： JPQL 不支持使用 INSERT；
     * （2）在 @Query 注解中编写 JPQL 语句， 但必须使用 @Modifying 进行修饰. 以通知 SpringData， 这是一个 UPDATE 或 DELETE 操作
     * （3）UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作；
     * （4）默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。 他们不能完成修改操作。
     */
    //====================================================================


    /**
     * 单标条件查询
     * nativeQuery  指的是使用原生的SQL进行查询
     * @param id
     * @return
     */
    @Query(value = "select ju.* from jpa_user ju where id=?1",nativeQuery = true)
    UserJPA findUserByUserId(Long id);

    /**
     * 单表多条件查询
     * @return
     */
    @Query(value="select ju.* from jpa_user ju where id=?1 and user_name like concat('%',?2,'%')",nativeQuery = true)
    UserJPA findByMoreCondition(long id, String username);

    /**
     * 单表多条件查询,将查询参数封装到实体类中
     * @return
     */
    @Query(value="select ju.* from jpa_user ju where ju.id=:#{#userJPA.id} and ju.user_name like CONCAT('%',:#{#userJPA.userName},'%')",nativeQuery = true)
    UserJPA findByConditionEntity(@Param("userJPA") UserJPA userJPA);

    /**
     * 单表多条件查询,将查询参数封装到map中
     * @return
     */
    @Query(value="select ju.* from jpa_user ju where ju.id=:id and ju.user_name like CONCAT('%',:userName,'%')",nativeQuery = true)
    UserJPA findByConditionMap(Map<String, Object> mapp);

    /**
     * 单表查询使用in的时候怎么传值
     * @return
     */
    @Query(value="select ju.* from jpa_user ju where ju.id in(:ids,:id)",nativeQuery = true)
    List<UserJPA> findByConditionWithIn(@Param("ids") List<Long> ids, @Param("id") Long id);


    /**
     *范围查询返回 LIST
     * @param id
     * @return
     */
    @Query(value="select ju.* from jpa_user ju where id > ?1 ",nativeQuery = true)
    List<UserJPA> findByRange(long id);


    //多表条件查询



    //动态条件查询



    //分页查询





}
