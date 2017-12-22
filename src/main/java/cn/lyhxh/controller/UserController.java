package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
import cn.lyhxh.model.User;
import cn.lyhxh.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    /**
     * 注册新用户
     * @param user
     * @return
     */
    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public ReturnBase<String> save(@RequestBody User user){
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(user.getMobile()) ||11 != user.getMobile().length()) {
                result.setRstCode(-1);
                result.setRetMsg("请输入正确的手机号！");
                return result;
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                result.setRstCode(-1);
                result.setRetMsg("请设置密码！");
                return result;
            }
            userService.save(user);
            result.setRstCode(1);
            result.setRetMsg("注册成功！");
            return result;
        }catch (Exception e){
            result.setRstCode(-1);
            result.setRetMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 查询用户列表
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list" ,method = RequestMethod.GET)
    public PageInfo<User> list(@RequestBody User user,
                                     @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.list(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "edit" ,method =RequestMethod.POST)
    public ReturnBase<String> edit(@RequestBody User user){
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(user.getId())){
                result.setRstCode(-1);
                result.setRetMsg("请输入用户id");
            }
            userService.edit(user);
            result.setRstCode(1);
            result.setRetMsg("修改成功");
        }catch (Exception e) {
            result.setRstCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[user-edit]" ,e);
        }
        return result;
    }

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public ReturnBase<String> remove(@RequestParam(required = true)Integer userId) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (null == userId){
                result.setRstCode(-1);
                result.setRetMsg("请输入用户id");
                return result;
            }
            userService.remove(userId);
            result.setRstCode(-1);
            result.setRetMsg("删除成功！");
        }catch (Exception e) {
            result.setRstCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[user-remove]", e);
        }
        return result;
    }

}
