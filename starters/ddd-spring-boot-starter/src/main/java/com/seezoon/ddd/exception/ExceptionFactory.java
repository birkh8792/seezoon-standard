package com.seezoon.ddd.exception;

/**
 * factory for exception
 *
 * @author huangdengfeng
 */
public class ExceptionFactory {

    public static BizException bizException(String msg) {
        return new BizException(msg);
    }

    public static BizException bizException(String code, String msg) {
        return new BizException(code, msg);
    }

    public static SysException sysException(String msg) {
        return new SysException(msg);
    }

    public static SysException sysException(String code, String msg) {
        return new SysException(code, msg);
    }

    public static SysException sysException(String msg, Throwable e) {
        return new SysException(msg, e);
    }

    public static SysException sysException(String code, String msg, Throwable e) {
        return new SysException(code, msg, e);
    }
}
