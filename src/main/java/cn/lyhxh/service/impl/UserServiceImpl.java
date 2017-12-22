package cn.lyhxh.service.impl;

import cn.lyhxh.dao.UserMapper;
import cn.lyhxh.model.User;
import cn.lyhxh.model.UserExample;
import cn.lyhxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> list(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(user.getId())) {
            criteria.andIdEqualTo(user.getId());
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public void edit(User user) {
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void remove(Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setDeleteTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

}
