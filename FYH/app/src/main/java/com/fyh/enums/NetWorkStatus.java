package com.fyh.enums;

/**
 * Created by Cbt on 2016/12/23.
 */
public interface NetWorkStatus {
    String S_500 = "未知错误";
    String S_501 ="密码错误";
    String S_404 = "数据未找到";
    String S_405 = "数据已经存在";
    String S_200 = "成功";
    String S_300 = "token过期";
    String S_301 = "token已经使用";
    String S_502 = "验证码错误";
    String S_310 = "传入参数不合规";
}
