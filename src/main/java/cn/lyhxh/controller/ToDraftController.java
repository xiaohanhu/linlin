package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
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
@RequestMapping(value = "/toDraft")
public class ToDraftController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ToDraftService toDraftService;
    /**
     * 保存起草类型
     * @param toDraft
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ReturnBase<String> save(@RequestBody ToDraft toDraft) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(toDraft.getTitle())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文档标题");
                return result;
            }if (StringUtils.isEmpty(toDraft.getContent())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文档内容");
                return result;
            }if (StringUtils.isEmpty(toDraft.getDraftNumber())) {
                result.setRetCode(-1);
                result.setRetMsg("请输入文号");
                return result;
            }if (StringUtils.isEmpty(toDraft.getTypeNumber())) {
                result.setRetCode(-1);
                result.setRetMsg("请选择文档类型");
                return result;
            }
            toDraftService.save(toDraft);
            result.setRetCode(1);
            result.setRetMsg("起草成功！");
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[toDraft-save]", e);
            return result;
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageInfo<ToDraft> list(@RequestBody ToDraft toDraft,
                                  @RequestParam(required = false, defaultValue = "0")Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10")Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ToDraft> toDraftList = toDraftService.list(toDraft);
        PageInfo<ToDraft> pageInfo = new PageInfo<>(toDraftList);
        return pageInfo;
    }
}
