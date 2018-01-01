package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
import cn.lyhxh.dto.ResultDto;
import cn.lyhxh.exception.BusinessRuntimeException;
import cn.lyhxh.exception.CheckErrorCodeEnum;
import cn.lyhxh.model.ToDraft;
import cn.lyhxh.service.ToDraftService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 起草控制器
 */
@RestController
@RequestMapping(value = "toDraft")
public class ToDraftController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ToDraftService toDraftService;

    /**
     * 保存起草文件
     * @param toDraft
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResultDto save(@RequestBody ToDraft toDraft) {
        ResultDto result = new ResultDto();
        try {
            if (StringUtils.isEmpty(toDraft.getTitle())) {
                result.setStatus("-1");
                result.setMessage("请输入文档标题");
                return result;
            }
            if (StringUtils.isEmpty(toDraft.getContent())) {
                result.setStatus("-1");
                result.setMessage("请输入文档内容");
                return result;
            }
            if (StringUtils.isEmpty(toDraft.getTypeNumber())) {
                result.setStatus("-1");
                result.setMessage("请选择文档类型");
                return result;
            }
            toDraftService.save(toDraft);
            result.setMessage("起草成功！");
            return result;
        }catch (Exception e) {
            result.setStatus("-1");
            result.setMessage(e.getMessage());
            logger.error("[toDraft-save]", e);
            return result;
        }
    }

    /**
     * 查询起草文件
     * @param toDraft
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultDto list(@RequestBody ToDraft toDraft,
                                  @RequestParam(required = false, defaultValue = "0")Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10")Integer pageSize) {
        ResultDto result = new ResultDto();
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<ToDraft> toDraftList = toDraftService.list(toDraft);
            PageInfo<ToDraft> pageInfo = new PageInfo<>(toDraftList);
            result.setMessage("查询成功");
            result.setData(pageInfo);
        }catch (Exception e){
            result.setStatus("-1");
            result.setMessage("查询失败");
            logger.error("to-draft list {}", e.getMessage());
        }
        return result;
    }

    /**
     * 修改起草文件
     * @param toDraft
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public ResultDto edit(@RequestBody ToDraft toDraft) {
        ResultDto result = new ResultDto();
        try {
            if (null == toDraft.getId()) {
                result.setStatus("-1");
                result.setMessage("请输入文件id");
                return result;
            }
            toDraftService.edit(toDraft);
            result.setMessage("起草文件修改成功");
            return result;
        }catch (Exception e) {
            result.setStatus("-1");
            result.setMessage("修改失败");
            logger.error("to-draft edit {}", e.getMessage());
        }
        return result;
    }

    /**
     * 逻辑删除起草文件
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResultDto remove(@PathVariable Integer id) {
        ResultDto result = new ResultDto();
        try {
            if (null == id) {
                throw new BusinessRuntimeException(CheckErrorCodeEnum.S000101);
            }
            toDraftService.remove(id);
        }catch (BusinessRuntimeException e) {
            result.setStatus(e.getErrorCode());
            result.setMessage(e.getErrorMessage());
            logger.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultDto findById(@PathVariable Integer id) {
        ResultDto result = new ResultDto();
        try {
            if (null == id) {
                throw new BusinessRuntimeException(CheckErrorCodeEnum.S000101);
            }
            ToDraft toDraft = toDraftService.findById(id);
            result.setData(toDraft);
        }catch (BusinessRuntimeException e) {
            result.setStatus(e.getErrorCode());
            result.setMessage(e.getErrorMessage());
            logger.error(e.getMessage());
        }
        return result;
    }
}
