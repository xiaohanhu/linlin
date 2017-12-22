package cn.lyhxh.service;

import cn.lyhxh.model.User;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    List<User> list(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void edit(User user);

    /**
     * 删除用户信息
     * @param userId
     */
    void remove(Integer userId);
}
