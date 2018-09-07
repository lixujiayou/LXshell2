package com.lx.shell2.utils.tools;

import android.util.Log;

import com.lx.shell2.BuildConfig;

import timber.log.Timber;

/**
 * @auther lixu
 * Created by lixu on 2018/8/18.
 */
public class LogUtils {
    private static final String TAG = "LXSHELL_2";
    private static boolean allowD = true;
    private static boolean allowE = true;
    private static boolean allowI = true;
    private static boolean allowV = true;
    private static boolean allowW = true;

    static {
            allowD = allowE = allowI = allowV = allowW = BuildConfig.LOG_DEBUG;
    }

    private LogUtils() {
    }

    /**
     * 开启Log
     *
     * @author ZhongDaFeng
     */
    public static void openLog(boolean flag) {
        allowD = flag;
        allowE = flag;
        allowI = flag;
        allowV = flag;
        allowW = flag;
    }

    public static void d(String content) {
        if (!allowD) {
            return;
        }
        Timber.d(content);
    }

    public static void e(String content) {
        if (!allowE)
            return;
        Timber.e(content);
    }
    public static void e(Exception content) {
        if (!allowE)
            return;
        Timber.e(content);
    }

    public static void i(String content) {
        if (!allowI)
            return;
        Timber.i(content);
    }

    public static void v(String content) {
        if (!allowV)
            return;
        Timber.v(content);
    }

    public static void w(String content) {
        if (!allowW)
            return;
        Timber.w(content);
    }

}
