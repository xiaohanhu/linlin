package cn.lyhxh.exception;

public class DataException extends RuntimeException {

    private String errorCode;

    private String errorMessage;

    public DataException() {
    }

    public DataException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public DataException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataException{");
        sb.append("errorCode=\'").append(this.errorCode).append('\'');
        sb.append(", errorMessage=\'").append(this.errorMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
