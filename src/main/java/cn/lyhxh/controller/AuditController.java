package cn.lyhxh.controller;

import cn.lyhxh.domain.ReturnBase;
import cn.lyhxh.model.Audit;
import cn.lyhxh.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AuditService auditService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ReturnBase<String> save(@RequestBody Audit audit) {
        ReturnBase<String> result = new ReturnBase<>();
        try {
            if (StringUtils.isEmpty(audit.getOpinion())) {
                result.setRetCode(-1);
                result.setRetMsg("请填写同意或者不同意！");
                return result;
            }
            auditService.save(audit);
            result.setRetCode(1);
            result.setRetMsg("保存成功");
            return result;
        }catch (Exception e) {
            result.setRetCode(-1);
            result.setRetMsg(e.getMessage());
            logger.error("[audit-error]", e);
            return result;
        }
    }
}
