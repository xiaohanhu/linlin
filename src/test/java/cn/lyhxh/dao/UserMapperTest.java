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
