package resp;

import lombok.Data;

@Data
public class CommonResult<T> {
    private T date;
    private Integer code;
    private String message;
}
