package com.test;

import java.util.Date;

public class MessageTime {
	/**
	 * 显示时间，如果与当前时间差别小于一天，则自动用**秒(分，小时)前，如果大于一天则用format规定的格式显示
	 * 
	 * @author wxy
	 * @param ctime
	 *            时间
	 * @param format
	 *            格式 格式描述:例如:yyyy-MM-dd yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String showTime(Date ctime, String format) {
		String r = "";
		if (ctime == null)
			return r;
		if (format == null)
			format = "yyyy-MM-dd HH:mm";

		long nowtimelong = System.currentTimeMillis();
		long ctimelong = ctime.getTime();
		long result = Math.abs(nowtimelong - ctimelong);

		if (result < 60000) // 一分钟内
		{
			long seconds = result / 1000;
			r = seconds + "秒钟前";
		} else if (result >= 60000 && result < 3600000) // 一小时内
		{
			long seconds = result / 60000;
			r = seconds + "分钟前";
		} else if (result >= 3600000 && result < 86400000) // 一天内
		{
			long seconds = result / 3600000;
			r = seconds + "小时前";
		} else// 日期格式
		{
//			r = DateTime.formatTime(ctime, format);
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(MessageTime.showTime(new Date(), null));

	}
}
