package com.tv.common;/**
 * Created by HUXU on 2017/10/30.
 */

/**
 * 字符串处理
 *
 * @author huxu
 * @create 2017-10-30 11:06
 **/

public class StringBuilderHolder {

    private final StringBuilder sb;

    public StringBuilderHolder(int capacity) {
        sb = new StringBuilder(capacity);
    }

    /**
     * 重置StringBuilder内部的writerIndex, 而char[]保留不动.
     */
    public StringBuilder getStringBuilder() {
        sb.setLength(0);
        return sb;
    }

}
