package com.tv.util;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.common.Const;
import com.tv.common.StringBuilderHolder;

/**
 * 字符串工具类
 *
 * @author huxu
 * @create 2017-10-30 11:03
 **/

public class FnwStr {

    private static final ThreadLocal<StringBuilderHolder> BUD_HOLDER = new ThreadLocal<StringBuilderHolder>() {
        @Override
        protected StringBuilderHolder initialValue() {
            return new StringBuilderHolder(256);
        }
    };

    /**
     * 字符串拼接
     *
     * @param elements
     * @return
     */
    public static <T> String join(final T... elements) {
        return join(elements, null);
    }

    /**
     * 区别StringUtils的join方法，这里skipNulls
     *
     * @param array
     * @param separator
     * @return
     */
    public static String join(final Object[] array, final String separator) {
        if (array == null) {
            return null;
        }

        if (array.length == 0) {
            return Const.EMPTY;
        }

        String sep = separator;
        if (sep == null) {
            sep = Const.EMPTY;
        }

        final StringBuilder buf = BUD_HOLDER.get().getStringBuilder();

        // 是否拼接分隔符的标记
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (flag) {
                    buf.append(sep).append(array[i]);
                } else {
                    buf.append(array[i]);
                    flag = true;
                }
            }
        }
        return buf.toString();
    }

    /**
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs) {
        if (cs == null) {
            return true;
        }
        int strLen = cs.length();
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static String trimToEmpty(String str) {
        return str == null ? Const.EMPTY : str.trim();
    }

    private FnwStr() {
    }
}
