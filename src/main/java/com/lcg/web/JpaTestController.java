package com.lcg.web;

import com.lcg.daoJpa.UserJPARepository;
import com.lcg.jpaEntity.UserJPA;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpa")
public class JpaTestController {

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private EntityManager entityManager;


    @RequestMapping("/insert")
    public String insert(){

        UserJPA userJpa=new UserJPA ();
        userJpa.setUserName ( "张三" );
        userJpa.setPassword ( "123456" );
        userJPARepository.save ( userJpa );

        UserJPA userJpa1=new UserJPA ();
        userJpa1.setUserName ( "zhang六" );
        userJpa1.setPassword ( "123456" );
        userJPARepository.save ( userJpa1 );

        UserJPA userJpa2=new UserJPA ();
        userJpa2.setUserName ( "wangwu" );
        userJpa2.setPassword ( "789456" );
        userJPARepository.save ( userJpa2 );

        return "ok";
    }

    @RequestMapping("/query")
    public List<Map<String,Object>> queryList(){

        UserJPA userJPA= userJPARepository.findOne ( 1L );
        UserJPA userJPA2= userJPARepository.findUserByUserId ( 1L );
        System.out.println ("ooooooooo-->"+userJPA2.getId ());

        UserJPA userJPA3=userJPARepository.findByMoreCondition ( 1L,"zhang" );

        UserJPA uj=new UserJPA ();
        uj.setId ( 1L );
        uj.setUserName ( "zhang" );
        UserJPA userJPA4= userJPARepository.findByConditionEntity ( uj );

        Map<String,Object> map1=new HashMap<>();
        map1.put ("id",1L);
        map1.put ("userName","zhang");
        //UserJPA userJPA5= userJPARepository.findByConditionMap ( map1 );

        List<UserJPA> userJPAList=userJPARepository.findByRange ( 2L );


        //JPA返回map类型的结果集start
        String sql="select * from jpa_user where id=?1";
        List<Map<String,Object>> listmap=entityManager.createNativeQuery ( sql ).setParameter ( 1,1L )
                                                 .unwrap(org.hibernate.Query.class)
                                                 .setResultTransformer ( Transformers.ALIAS_TO_ENTITY_MAP )
                                                 .list ();

        //JPA返回map类型的结果集end

        //JPA多表返回List<Map<String,Object>>   START
        String sql2="select ju.user_name,jg.goods_name from jpa_user ju left join jpa_goods jg on ju.id=jg.user_id  where ju.id >= ?1";
        List<Map<String,Object>> listmap1=entityManager.createNativeQuery ( sql2 )
                .setParameter ( 1,1L )
                .unwrap ( org.hibernate.Query.class )
                .setResultTransformer ( Transformers.ALIAS_TO_ENTITY_MAP ).list ();

        //JPA多表返回List<Map<String,Object>>   end



        List<Long> list1=new ArrayList<> (  );
        list1.add ( 1L );
        list1.add ( 2L);
        List<UserJPA> userJPAList2=userJPARepository.findByConditionWithIn ( list1,3L );

        List<Map<String,Object>> list=new ArrayList<Map<String,Object>> (  );
        Map<String,Object> map=new HashMap<String,Object> ();
        //map.put ( "1",userJPA2);
        //map.put ( "2",userJPA3);
        map.put ( "3",userJPAList);
        map.put ( "4",userJPA4);
        //map.put ( "5",userJPA5);
        map.put ( "6",userJPAList2 );
        map.put ( "7",listmap );
        map.put ( "8",listmap1 );
        list.add (  map);



        return list;
    }

}
