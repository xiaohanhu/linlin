package cn.lyhxh.service;

import cn.lyhxh.model.ToDraft;

import java.util.List;

public interface ToDraftService {

    /**
     * 保存起草文件
     * @param toDraft
     */
    void save(ToDraft toDraft);

    /**
     * 查询起草文件
     * @param toDraft
     * @return
     */
    List<ToDraft> list(ToDraft toDraft);
}
