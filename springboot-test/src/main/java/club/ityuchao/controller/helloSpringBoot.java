package club.ityuchao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class helloSpringBoot {

    @Autowired
    private DataSource dataSource;

    @GetMapping("hello")
    public String hello(){
        System.out.println(dataSource);
        return "hello springboot!";
    }

}
