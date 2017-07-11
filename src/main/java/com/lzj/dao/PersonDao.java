package com.lzj.dao;

import com.lzj.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by win7 on 2017-07-11.
 */
@RepositoryRestResource(path = "person")
public interface PersonDao extends JpaRepository<Person,Integer>{
    //表示不可通过http方法调用，调用会报405
    @RestResource(exported = false)
    @Override
    public void delete(Integer integer);
    //根据方法来访问
    //http://localhost:8080/person/search/findByName?name=li
    //path 指定访问路径    rel 在查询出来显示的link路径  @Param 等待注入的参数
    @RestResource(path = "findByName",rel = "findByName")
    public Person findPersonByName(@Param("name") String name);
}
