# linlin
Spring Boot
### 基本项目搭建
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
