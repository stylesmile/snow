//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.Stylesmile.common.Exception;

public class PlatformException extends RuntimeException {
    private static final long serialVersionUID = -6315329503841905147L;
    public static final int CANNOT_GET_CONNECTION = 0;
    public static final int SQL_EXCEPTION = 1;
    public static final int CANNOT_GET_SQL = 2;
    public static final int MAPPING_ERROR = 3;
    public static final int ID_EXPECTED_ONE_ERROR = 4;
    public static final int NOT_UNIQUE_ERROR = 5;
    public static final int SQL_SCRIPT_ERROR = 6;
    public static final int ID_NOT_FOUND = 7;
    public static final int TABLE_NOT_EXIST = 8;
    public static final int OBJECT_INSTANCE_ERROR = 9;
    public static final int UNKNOW_MAPPER_SQL_TYPE = 10;
    public static final int ERROR_MAPPER_PARAMEER = 11;
    public static final int UNIQUE_EXCEPT_ERROR = 12;
    public static final int TAIL_CALL_ERROR = 13;
    public static final int ID_VALUE_ERROR = 14;
    public static final int ID_AUTOGEN_ERROR = 15;
    public static final int ORM_ERROR = 16;
    public static final int ORM_LAZY_ERROR = 17;
    public static final int TEMPLATE_PAGE_PARAS_ERROR = 18;
    public static final int GET_OBJECT_PROPERTY_ERROR = 19;
    public static final int QUERY_CONDITION_ERROR = 20;
    public static final int QUERY_SQL_ERROR = 21;
    int code;

    public PlatformException(int code) {
        this.code = code;
    }

    public PlatformException(int code, Exception e) {
        super(e);
        this.code = code;
    }

    public PlatformException(int code, String msg, Exception e) {
        super(msg, e);
        this.code = code;
    }

    public PlatformException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
