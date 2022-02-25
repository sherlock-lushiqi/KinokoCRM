package com.lushiqi.kinokocrm.commonutils.result;

public interface IResultCode {

    /**
     *  获取响应码
     * @return 响应码
     */
    Integer getCode();


    /**
     * 获取响应信息
     *
     * @return 响应信息
     */
    String getMsg();
}
