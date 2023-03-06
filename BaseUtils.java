package com.shopping.utils;

import javax.servlet.http.HttpServletRequest;

public interface BaseUtils {
	public default int getInt(HttpServletRequest req,String key,int defVal) {
		String _val=req.getParameter(key);
		if(_val==null) {
			return defVal;
		}
		return Integer.valueOf(_val);
	}
    
}
