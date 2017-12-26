package cn.lyhxh.dao;

import cn.lyhxh.model.FileType;
import cn.lyhxh.model.FileTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileTypeMapper {
    long countByExample(FileTypeExample example);

    int deleteByExample(FileTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileType record);

    int insertSelective(FileType record);

    List<FileType> selectByExample(FileTypeExample example);

    FileType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileType record, @Param("example") FileTypeExample example);

    int updateByExample(@Param("record") FileType record, @Param("example") FileTypeExample example);

    int updateByPrimaryKeySelective(FileType record);

    int updateByPrimaryKey(FileType record);
}