package bean;

/**
 * 授权类型
 */
public enum PgcgoGrantType {
    WITHDRAW("withdraw","代扣"),TRANSFER("transfer","转账"),ALL("all","所有");

    private String code;
    private String msg;

    PgcgoGrantType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
