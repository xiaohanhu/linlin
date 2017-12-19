### 集成MyBatis
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