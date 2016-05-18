package com.example.retrofit.utils;

import android.util.Log;

/**
 * Logͳһ������
 * 
 * @author way
 * 
 */
public class L {

	private static boolean isLog = true;
	private static final String DEFAULT_TAG = "Debug";

	/**
	 * 调试信息打印
	 *
	 * @param tag
	 *            (打印标记)
	 * @param level
	 *            (打印类型)
	 * @param msg
	 *            (打印内容)
	 * @param tr
	 *            (打印异常)
	 */
	public static void log(String tag, int level, String msg, Throwable tr) {
		if (isLog) {
			if (msg == null && tr == null) {
				return;
			}
			switch (level) {
				case Log.VERBOSE:
					if (tr == null) {
						Log.v(tag, msg);
					} else {
						Log.v(tag, msg, tr);
					}
					break;
				case Log.INFO:
					if (tr == null) {
						Log.i(tag, msg);
					} else {
						Log.i(tag, msg, tr);
					}
					break;
				case Log.DEBUG:
					if (tr == null) {
						Log.d(tag, msg);
					} else {
						Log.d(tag, msg, tr);
					}
					break;
				case Log.WARN:
					if (tr == null) {
						Log.w(tag, msg);
					} else {
						Log.w(tag, msg, tr);
					}
					break;
				case Log.ERROR:
					if (tr == null) {
						Log.e(tag, msg, tr);
					} else {
						Log.e(tag, msg, tr);
					}

					break;
			}
		}
	}

	/**
	 * 信息打印
	 *
	 * @param tag
	 *            (打印标记)
	 * @param level
	 *            (打印类型)
	 * @param msg
	 *            (打印内容)
	 */
	public static void log(String tag, int level, String msg) {
		log(tag, level, msg, null);
	}

	/**
	 * 信息打印(默认打印标记：Debug)
	 *
	 * @param level
	 *            (打印类型)
	 * @param msg
	 *            (打印内容)
	 */
	public static void log(int level, String msg) {
		log(DEFAULT_TAG, level, msg);
	}

	/**
	 * 信息打印(默认打印标记：Debug 默认打印类型：Log.DEBUG)
	 *
	 * @param msg
	 *            (打印内容)
	 */
	public static void log(String msg) {
		log(DEFAULT_TAG, Log.DEBUG, msg);
	}

	/**
	 * 信息打印(默认打印类型：Log.DEBUG)
	 *
	 * @param tag
	 *            (打印标记)
	 * @param msg
	 *            (打印内容)
	 */
	public static void log(String tag, String msg) {
		log(tag, Log.DEBUG, msg);
	}

	/**
	 * 异常打印(默认打印标记：Debug 默认打印类型：Log.ERROR)
	 *
	 * @param msg
	 */
	public static void log(Throwable msg) {
		log(DEFAULT_TAG, Log.ERROR, "", msg);
	}

	/**
	 * 设置是否打印
	 *
	 * @param isDebug
	 */
	public static void setIsDebug(boolean isDebug) {
		isLog = isDebug;
	}
}