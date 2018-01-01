package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
import cn.lyhxh.model.Audit;
import cn.lyhxh.service.AuditService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "audit")
public class AuditController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AuditService auditService;

    /**
     * 保存审核
     * @param audit
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ReturnBase<String> save(@RequestBody Audit audit) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(audit.getOpinion())) {
                result.setRetCode(-1);
                result.setRetMsg("审核人请填写同意或者不同意！");
                return result;
            }
            auditService.save(audit);
            result.setRetCode(1);
            result.setRetMsg("审核保存成功");
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg("审核保存失败");
            logger.error("audit-error save {}", e.getMessage());
            return result;
        }
    }

    /**
     * 分页查询审核
     * @param audit
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ReturnBase<PageInfo<Audit>> list(@RequestBody Audit audit,
                                            @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ReturnBase<PageInfo<Audit>> result = new ReturnBase<>();
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<Audit> auditList = auditService.list(audit);
            PageInfo<Audit> pageInfo = new PageInfo<>(auditList);
            result.setRetCode(1);
            result.setRetMsg("查询审核成功");
            result.setResult(pageInfo);
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg("查询审核失败");
            logger.error("audit list {}", e.getMessage());
        }
        return result;
    }

    /**
     * 修改审核文档
     * @param audit
     * @param id
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ReturnBase<String> edit(@RequestBody Audit audit,
                                   @RequestParam(required = true) Integer id) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            auditService.edit(audit);
            result.setRetCode(1);
            result.setRetMsg("修改审核成功");
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg("修改审核失败");
            logger.error("audit edit {}", e.getMessage());
        }
        return result;
    }

}
