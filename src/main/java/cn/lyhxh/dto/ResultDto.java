package cn.lyhxh.dto;

import java.io.Serializable;

/**
 * 返回结果实体
 */
public class ResultDto implements Serializable {

    /**
     * 返回状态 默认成功状态
     */
    private String status = "000000";

    /**
     * 返回信息
     */
    private String message="";

    private Object data;

    public ResultDto() {
        super();
    }

    public ResultDto(Object data) {
        super();
        this.data = data;
    }

    public ResultDto(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ResultDto(String status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
