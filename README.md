# linlin
Spring Boot

### 基本环境

```
E:\ws\linlin>mvn -v
Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T15:58:13+08:00)
Maven home: D:\Soft\apache-maven-3.5.2\bin\..
Java version: 1.8.0_151, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_151\jre
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

### [基本项目搭建](https://github.com/xiaohanhu/linlin/tree/build)
- 创建maven项目
- 添加pom依赖(pom.xml)
    ```
    <properties>
        <java.version>1.8</java.version>
    </properties>

    <!-- Inherit defaults from Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>

    <!-- Add typical dependencies for a web application -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <!-- Package as an executable jar -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

    ```
    
- 写程序入口

    ```
    @SpringBootApplication
    public class LinLinApplication {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(LinLinApplication.class, args);
        }
    
    }

    ```
    
- 验证项目搭建是否成功
    - 编写控制器
    
    ```
    @RestController
    public class HelloController {
    
        @RequestMapping("/")
        public String hello() {
            return "Hello World!";
        }
    }

    ```
    
    - 启动项目
    - 浏览器访问 `http://localhost:8080/`
    - `Hello World!`出现表示创建成功

### [集成MyBatis](https://github.com/xiaohanhu/linlin/tree/mybatis)
- 编写application文件
    - 利用MyBatis Genetator生成model,dao,mapper并加入到项目中
    - 添加pom依赖
    
    ```
    <!-- MyBatis -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis-spring-boot-starter.version}</version>
    </dependency>
    <!-- MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql-connector-java.version}</version>
    </dependency>
    ```
    
    - 添加数据源和Mybatis配置
    
    ```
    # Datasource
    spring.datasource.name=jdbc:mysql://rm-uf6299f3z1tfatkixo.mysql.rds.aliyuncs.com:3306/test?useUnicode=true&characterEncoding=utf-8
    spring.datasource.username=root
    spring.datasource.password=Lgf123456
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
            
    # Mybatis
    mybatis.mapper-locations=classpath:mapper/*Mapper.xml
    mybatis.type-aliases-package=cn.lyhxh.model
    mybatis.configuration.mapUnderscoreToCamelCase=true
    mybatis.configuration.useColumnLabel=true
    
    # Logger
    logging.level.root=WARN,INFO
    logging.level.org.springframework.web=DEBUG
    logging.level.sample.mybatis.mapper=TRACE
    # 显示mysql语句到控制台
    logging.level.cn.lyhxh.dao=TRACE
    ```
    
    - 程序入口添加dao扫描 `@MapperScan("cn.lyhxh.dao")`
    
    - 验证MyBatis集成
        - 加入pom依赖
        
        ```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        ```
    - 直接测试dao层
    
    ```
    package cn.lyhxh.dao;


    import cn.lyhxh.model.User;
    import cn.lyhxh.model.UserExample;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;
    
    import java.util.List;
    
    @SpringBootTest
    @RunWith(SpringRunner.class)
    public class UserMapperTest {
    
        Logger logger = LoggerFactory.getLogger(getClass());
    
        @Autowired
        UserMapper userMapper;
    
        @Test
        public void selectByExample() {
            UserExample example = new UserExample();
            List<User> userList = userMapper.selectByExample(example);
            logger.info("user list size {}", userList.size());
        }
    }
    ```
    
    - 控制台出现`user list size 7` 表示成功(数据库已有数据)