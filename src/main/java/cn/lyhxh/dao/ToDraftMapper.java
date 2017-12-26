package cn.lyhxh.dao;

import cn.lyhxh.model.ToDraft;
import cn.lyhxh.model.ToDraftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToDraftMapper {
    long countByExample(ToDraftExample example);

    int deleteByExample(ToDraftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ToDraft record);

    int insertSelective(ToDraft record);

    List<ToDraft> selectByExampleWithBLOBs(ToDraftExample example);

    List<ToDraft> selectByExample(ToDraftExample example);

    ToDraft selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ToDraft record, @Param("example") ToDraftExample example);

    int updateByExampleWithBLOBs(@Param("record") ToDraft record, @Param("example") ToDraftExample example);

    int updateByExample(@Param("record") ToDraft record, @Param("example") ToDraftExample example);

    int updateByPrimaryKeySelective(ToDraft record);

    int updateByPrimaryKeyWithBLOBs(ToDraft record);

    int updateByPrimaryKey(ToDraft record);
}