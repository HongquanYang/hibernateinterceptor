package com.webapp.core;
/****
 * 
 * @author yanghongquan
 * @created 2012-1-17
 */

public enum Choice {
	get,add, update, delete;
	public static Choice getChoice(String choice) {
		return valueOf(choice.toLowerCase());
	}
}
