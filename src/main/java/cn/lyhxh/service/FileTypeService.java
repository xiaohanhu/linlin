package cn.lyhxh.service;

import cn.lyhxh.model.FileType;

import java.util.List;

/**
 * 文档类型服务
 */
public interface FileTypeService {
    /**
     * 保存文档类型
     * @param fileType
     */
    void save(FileType fileType);

    /**
     * 修改文档类型
     * @param fileType
     */
    void edit(FileType fileType);

    /**
     * 查询文档类型
     * @param fileType
     * @return
     */
    List<FileType> list(FileType fileType);

    /**
     * 删除文档类型
     * @param id
     */
    void remove(Integer id);
}
