package cn.lyhxh.service.impl;

import cn.lyhxh.dao.AuditMapper;
import cn.lyhxh.model.Audit;
import cn.lyhxh.model.AuditExample;
import cn.lyhxh.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Override
    public void save(Audit audit) {
        auditMapper.insertSelective(audit);
    }

    @Override
    public List<Audit> list(Audit audit) {
        AuditExample example = new AuditExample();
        return auditMapper.selectByExample(example);
    }

    @Override
    public void edit(Audit audit) {
//        AuditExample example = new AuditExample();
//        AuditExample.Criteria criteria = example.createCriteria();
//            if (!StringUtils.isEmpty(audit.getId())) {
//                criteria.andIdEqualTo(audit.getId());
//            }
//            auditMapper.updateByExampleSelective(audit, example);
        auditMapper.updateByPrimaryKeySelective(audit);
    }
}
