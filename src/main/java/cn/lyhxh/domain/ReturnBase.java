package cn.lyhxh.domain;

public class ReturnBase<T> {

    private Integer rstCode;

    private String retMsg;

    private T result;

    public Integer getRstCode() {
        return rstCode;
    }

    public void setRstCode(Integer rstCode) {
        this.rstCode = rstCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
