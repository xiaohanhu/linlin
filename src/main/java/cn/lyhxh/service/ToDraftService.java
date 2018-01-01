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

    /**
     * 修改起草文件
     * @param toDraft
     */
    void edit(ToDraft toDraft);

    /**
     * 逻辑删除起草公文
     * @param id
     */
    void remove(Integer id);

    /**
     * 根据Id查询发文信息
     * @param id
     * @return
     */
    ToDraft findById(Integer id);
}
