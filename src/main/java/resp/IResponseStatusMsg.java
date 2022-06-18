package resp;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public interface IResponseStatusMsg extends IEnumItem<Integer, String> {
    Integer getCode();

    String getMessage();

    public static enum APIEnum implements IResponseStatusMsg {
        SUCCESS(0, "成功"),
        FAILED(1001, "失败"),
        SERVER_ERROR(1002, "服务器好像开小差了"),
        METHOD_WITHOUT_IMPLEMENT(1003, "该方法暂未实现"),
        RESP_FIELD_VALID(1004, "返回值字段校验失败"),
        DB_ERROR(1005, "数据库调用失败"),
        BUSINESS_LOGIC_ERROR(1006, "业务逻辑异常"),
        JSON_PARSE_FAILED(1007, "json转换异常"),
        FILE_IO_FAILED(1008, "文件读写异常"),
        PARAM_ERROR(2001, "参数错误"),
        SYNC_OP_ERROR(2002, "操作频繁, 请稍候再试"),
        SENSITIVE_WORD(2003, "存在敏感词汇"),
        SPRING_REQUEST_RESOLVER(2004, "非法的请求参数格式"),
        OLD_VERSION(2005, "当前版本太低了，请下载最新版本应用"),
        REQUEST_FREQ_RETRICT(2006, "接口访问频率超出限制"),
        AUTHORITY_EXCEED(2007, "越权访问"),
        ILLEGAL_REQUEST_SOURCE(2008, "不合法的请求来源"),
        EOF_BROKEN_PIPE(2009, "客户端主动断开连接"),
        EXIST_RISK(2010, "存在风险"),
        DATA_NOT_EXIST(2011, "数据不存在"),
        STATUS_UNEXPECTED(2012, "数据状态不正确"),
        CONTENT_UNEXPECTED(2013, "数据内容不正确");

        private Integer code;
        private String message;

        private APIEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static boolean isSuccess(Integer code) {
            return SUCCESS.equalByCode(code);
        }
    }
}

