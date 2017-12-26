package cn.lyhxh.service.impl;

import cn.lyhxh.dao.FileTypeMapper;
import cn.lyhxh.model.FileType;
import cn.lyhxh.model.FileTypeExample;
import cn.lyhxh.service.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTypeServiceImpl implements FileTypeService {

    @Autowired
    FileTypeMapper fileTypeMapper;

    @Override
    public void save(FileType fileType) {
        fileTypeMapper.insertSelective(fileType);
    }

    @Override
    public void edit(FileType fileType) {
        fileTypeMapper.updateByPrimaryKeySelective(fileType);
    }

    @Override
    public List<FileType> list(FileType fileType) {
        FileTypeExample example = new FileTypeExample();
//        FileTypeExample.Criteria criteria = example.createCriteria();
        return fileTypeMapper.selectByExample(example);
    }

    @Override
    public void remove(Integer id) {
        fileTypeMapper.deleteByPrimaryKey(id);
    }
}
