package cn.lyhxh.dao;

import cn.lyhxh.model.Audit;
import cn.lyhxh.model.AuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuditMapper {
    long countByExample(AuditExample example);

    int deleteByExample(AuditExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Audit record);

    int insertSelective(Audit record);

    List<Audit> selectByExample(AuditExample example);

    Audit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Audit record, @Param("example") AuditExample example);

    int updateByExample(@Param("record") Audit record, @Param("example") AuditExample example);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}