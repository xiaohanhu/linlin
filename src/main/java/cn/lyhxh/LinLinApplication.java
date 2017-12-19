package cn.lyhxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lyhxh.dao")
public class LinLinApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LinLinApplication.class, args);
    }

}
