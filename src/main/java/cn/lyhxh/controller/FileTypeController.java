package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
import cn.lyhxh.model.FileType;
import cn.lyhxh.service.FileTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fileType")

public class FileTypeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FileTypeService fileTypeService;

    /**
     * 文件类型添加
     * @param fileType
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ReturnBase<String> save(@RequestBody FileType fileType) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(fileType.getName())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文件类型");
                return  result;
            }
            if (StringUtils.isEmpty(fileType.getDesc())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文件类型描述");
                return  result;
            }
            fileTypeService.save(fileType);
            result.setRetCode(1);
            result.setRetMsg("文件类型保存成功");
            return  result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[fileType-save]", e);
        }
        return  result;
    }

    /**
     * 分页查询文档类型
     * @param fileType
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ReturnBase<PageInfo<FileType>> list(@RequestBody FileType fileType,
                               @RequestParam(required = false, defaultValue = "0")Integer pageNum,
                               @RequestParam(required = false, defaultValue = "10")Integer pageSize) {
        ReturnBase<PageInfo<FileType>> result = new ReturnBase<>();
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<FileType> fileTypeList = fileTypeService.list(fileType);
            PageInfo<FileType> pageInfo = new PageInfo<>(fileTypeList);
            result.setRetCode(1);
            result.setRetMsg("查询成功");
            result.setResult(pageInfo);
        } catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg("查询失败");
            logger.error("file-type list {}", e.getMessage());
        }
        return result;
    }

    /**
     * 修改文档类型
     * @param fileType
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ReturnBase<String> edit(@RequestBody FileType fileType) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(fileType.getId())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文档类型id");
                return  result;
            }
            fileTypeService.edit(fileType);
            result.setRetCode(1);
            result.setRetMsg("文档类型修改成功！");
            return  result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[fileType-edit]", e);
            return  result;
        }
    }

    /**
     * 删除文档类型
     * @param id
     * @return
     */
    @RequestMapping(value = "remove/{id}", method = RequestMethod.POST)
    public ReturnBase<String> remove(@PathVariable Integer id) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            fileTypeService.remove(id);
            result.setRetCode(1);
            result.setRetMsg("删除成功");
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[fileType-remove]", e);
        }
        return result;
    }
}
