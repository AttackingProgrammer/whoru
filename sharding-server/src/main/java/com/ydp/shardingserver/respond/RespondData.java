package com.ydp.shardingserver.respond;

import com.ydp.shardingserver.status.StatusCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

/**
 * 回包
 * @ClassName RespondData
 * @Author ydp
 * @Version
 * @Date 2021/12/1
 */
@Getter
@Setter
public class RespondData<T> {

    /**
     * 请求id
     */
    private String requestId;
    /**
     * 回包状态
     */
    private int code;

    /**
     * 信息
     */
    private String msg;
    /**
     * 回包对象
     */
    private T res;

    public RespondData(StatusCodeEnum code, String msg, T res) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        this.requestId = uuid;
        this.code = code.getCode();
        this.msg = msg;
        this.res = res;
    }

    public RespondData(StatusCodeEnum code, String msg) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        this.requestId = uuid;
        this.code = code.getCode();
        this.msg = msg;
    }
}
