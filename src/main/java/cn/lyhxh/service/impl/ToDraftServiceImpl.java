package cn.lyhxh.service.impl;

import cn.lyhxh.dao.ToDraftMapper;
import cn.lyhxh.model.ToDraft;
import cn.lyhxh.model.ToDraftExample;
import cn.lyhxh.service.ToDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDraftServiceImpl implements ToDraftService {

    @Autowired
    ToDraftMapper toDraftMapper;
    @Override
    public void save(ToDraft toDraft) {
        toDraftMapper.insertSelective(toDraft);
    }

    @Override
    public List<ToDraft> list(ToDraft toDraft) {
        ToDraftExample example = new ToDraftExample();
        return toDraftMapper.selectByExample(example);
    }
}
