package com.ciecc.fire.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Examine {

	/**
	 * URL检查<br>
	 * <br>
	 * 
	 * @param pInput 要检查的字符串<br>
	 * @return boolean 返回检查结果<br>
	 */
	public static boolean isUrl(String pInput) {
		if (pInput == null) {
			return false;
		}
		String regEx = "^((https|http|ftp|rtsp|mms)?://)" 
			     + "+(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" 
			     + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" 
			     + "|" 
			     + "([0-9a-z_!~*'()-]+\\.)*" 
			     + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." 
			     + "[a-z]{2,6})" 
			     + "(:[0-9]{1,4})?" 
			     + "((/?)|" 
			     + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
		Pattern p = Pattern.compile(regEx);
		Matcher matcher = p.matcher(pInput);
		return matcher.matches();
	}
}
