package resp;

import exception.IBizException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class APIResult<T> {
    private Integer status;
    private String message;
    private T data;

    public APIResult() {
        this.status = IResponseStatusMsg.APIEnum.SUCCESS.getCode();
    }

    public APIResult(T data) {
        this();
        this.data = data;
    }

    public APIResult(Exception e){
        if (e instanceof IBizException){
            IBizException ex = (IBizException) e;
            this.status = ex.getCode();
            this.message = ex.getMessage();
        }else {
            this.status = IResponseStatusMsg.APIEnum.SERVER_ERROR.getCode();
            this.message = e.getMessage();
        }
    }
}
