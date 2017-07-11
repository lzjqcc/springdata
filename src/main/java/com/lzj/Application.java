package com.lzj;

import com.lzj.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

/**
 * Created by win7 on 2017-07-11.
 */
//http://docs.spring.io/spring-data/rest/docs/current/reference/html/#_changing_the_base_uri
@SpringBootApplication
public class Application {
    @Bean
    public ResourceProcessor<Resource<Person>> personProcessor(){
        return new ResourceProcessor<Resource<Person>>() {
            @Override
            public Resource<Person> process(Resource<Person> personResource) {
                personResource.add(new Link("http://localhost:8080/people","added-link"));
                return personResource;
            }
        };
    }
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}
