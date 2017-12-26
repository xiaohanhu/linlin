package cn.lyhxh.service.impl;

import cn.lyhxh.dao.AuditMapper;
import cn.lyhxh.model.Audit;
import cn.lyhxh.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Override
    public void save(Audit audit) {
        auditMapper.insertSelective(audit);
    }
}
