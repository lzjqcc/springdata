package com.lzj.domain;

import com.lzj.domain.Person;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by win7 on 2017-07-11.
 */

/**
 *
 * spring data rest如何找到定义的 projection

 How does Spring Data REST finds projection definitions?
 将@Projection注解的接口放到实体类中

 Any @Projection interface found in the same package as your entity definitions (or one of it’s sub-packages) is registered.
 调用 RepositoryRestConfiguration.getProjectionConfiguration().addProjection(…)方法注册

 You can manually register via RepositoryRestConfiguration.getProjectionConfiguration().addProjection(…).
访问url:http://localhost:8080/person/5?projection=noage
 http://localhost:8080/profile/person 获取profile配置文件  用于查看存在的projection

 "type" : "SEMANTIC",
 "descriptors" : [ {
 "name" : "noName",
 "type" : "SEMANTIC",
 "descriptors" : [ {
 "name" : "address",
 "type" : "SEMANTIC"
 }, {
 "name" : "age",
 "type" : "SEMANTIC"
 } ]


 */
//这个是用来指定哪些数据能够封装成json
    //这种做法弥补了@JsonIgnore指定的属性不能通过http put 方法保存数据
@Projection(name = "noName",types = Person.class)
public interface NoPersonName {
    String getAddress();//将会输出
    String getAge();//将会输出
}
