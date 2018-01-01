package cn.lyhxh.service;

import cn.lyhxh.model.Audit;

import java.util.List;

public interface AuditService {

    /**
     * 保存审查
     * @param audit
     */
    void save(Audit audit);

    /**
     * 分页查询审核文件
     * @param audit
     * @return
     */
    List<Audit> list(Audit audit);

    /**
     * 修改审核文件
     * @param audit
     */
    void edit(Audit audit);
}
