package com.lushiqi.kinokocrm.commonutils.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements IResultCode {

    SUCCESS(20000,"操作成功した"),

    ERROR(20001,"エラー"),

    LOGIN_ERROR(20014,"ユーザ名またはパスワードが間違っています"),
    ;

    private Integer code;

    private String msg;
}
