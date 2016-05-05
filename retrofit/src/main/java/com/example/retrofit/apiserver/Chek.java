package com.example.retrofit.apiserver;


//加密规则
public class Chek {

	public static String checkisfromphone() {

		String str = Md5.stringToMD5(System.currentTimeMillis() + "");
		str = str.substring(8, 24);

		String str1 = str.substring(0, 2);
		String str2 = str.substring(2, 4);
		String str3 = str.substring(4, 6);
		String str4 = str.substring(6, 10);
		String str5 = str.substring(10, 12);
		String str6 = str.substring(12, 14);
		String str7 = str.substring(14, 16);

		String xx = "FH" + str5 + "TTZ" + str1 + "BL" + str7 + "WJ" + str2
				+ "YY" + str4 + "GL" + str3 + "GY" + str6;

		String ss = Md5.stringToMD5(xx);
		ss = ss.substring(16, 32) + ss.substring(0, 16);
		ss = ss.substring(0, 8) + ss.substring(17, 32) + ss.substring(8, 17);
		String s = "Token=" + ss + "&Seed=" + str;
		return s;

	}

	public static String[] getCheckParams() {
		String str = Md5.stringToMD5(System.currentTimeMillis() + "");
		str = str.substring(8, 24);

		String str1 = str.substring(0, 2);
		String str2 = str.substring(2, 4);
		String str3 = str.substring(4, 6);
		String str4 = str.substring(6, 10);
		String str5 = str.substring(10, 12);
		String str6 = str.substring(12, 14);
		String str7 = str.substring(14, 16);

		String xx = "FH" + str5 + "TTZ" + str1 + "BL" + str7 + "WJ" + str2
				+ "YY" + str4 + "GL" + str3 + "GY" + str6;

		String ss = Md5.stringToMD5(xx);
		ss = ss.substring(16, 32) + ss.substring(0, 16);
		ss = ss.substring(0, 8) + ss.substring(17, 32) + ss.substring(8, 17);
//		String s = "Token=" + ss + "&Seed=" + str;
		String[] checks = new String[] { ss, str };
		return checks;
	}

	public static String getToken(){
		String str=getSeed();

		String str1 = str.substring(0, 2);
		String str2 = str.substring(2, 4);
		String str3 = str.substring(4, 6);
		String str4 = str.substring(6, 10);
		String str5 = str.substring(10, 12);
		String str6 = str.substring(12, 14);
		String str7 = str.substring(14, 16);

		String xx = "FH" + str5 + "TTZ" + str1 + "BL" + str7 + "WJ" + str2
				+ "YY" + str4 + "GL" + str3 + "GY" + str6;

		return Md5.stringToMD5(xx);
	}

	public static String getSeed(){
		String str = Md5.stringToMD5(System.currentTimeMillis() + "");
		return str.substring(8, 24);
	}


}
