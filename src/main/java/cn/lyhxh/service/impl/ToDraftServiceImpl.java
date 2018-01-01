package cn.lyhxh.service.impl;

import cn.lyhxh.dao.ToDraftMapper;
import cn.lyhxh.exception.BusinessRuntimeException;
import cn.lyhxh.exception.CheckErrorCodeEnum;
import cn.lyhxh.model.ToDraft;
import cn.lyhxh.model.ToDraftExample;
import cn.lyhxh.service.ToDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToDraftServiceImpl implements ToDraftService {

    @Autowired
    ToDraftMapper toDraftMapper;
    @Override
    public void save(ToDraft toDraft) {
        toDraft.setCreateTime(new Date());
        toDraft.setSendTime(new Date());
        toDraftMapper.insertSelective(toDraft);
    }

    @Override
    public List<ToDraft> list(ToDraft toDraft) {
        ToDraftExample example = new ToDraftExample();
       // ToDraftExample.Criteria criteria = example.createCriteria();
        return toDraftMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void edit(ToDraft toDraft) {
        toDraft.setUpdateTime(new Date());
        toDraftMapper.updateByPrimaryKeyWithBLOBs(toDraft);}

    @Override
    public void remove(Integer id) {
//        toDraftMapper.selectByPrimaryKey(id).setDeleteTime(new Date());
        ToDraft draft = toDraftMapper.selectByPrimaryKey(id);
        if (null != draft) {
            draft.setDeleteTime(new Date());
            toDraftMapper.updateByPrimaryKey(draft);
        } else {
            throw new BusinessRuntimeException(CheckErrorCodeEnum.O010501);
        }
    }

    @Override
    public ToDraft findById(Integer id) {
        return toDraftMapper.selectByPrimaryKey(id);
    }
}
