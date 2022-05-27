package com.ydp.shardingserver.status;

/**
 * 回包状态
 * @ClassName StatusCodeEnum
 * @Author ydp
 * @Version
 * @Date 2021/12/1
 */
public enum StatusCodeEnum {
    /**
     * 正常
     */
    success(0),
    /**
     * 保存失败
     */
    save_fail(50001),
    /**
     * 查询失败
     */
    query_fail(50002),
    /**
     * 限流
     */
    rate_limit(40001),
    ;

    private int code;

    StatusCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
