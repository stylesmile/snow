package com.stylesmile.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据格式转化类
 * @author xiandafu
 *
 */
public class ConvertUtil {
	/**
	 * 转化逗号分隔的id到long数组，通常用于批量操作
	 * @param str
	 * @return
	 */
	public static List<Integer> strToLongList(String str){
		if(str.length()==0){
			return Collections.EMPTY_LIST;
		}
		String[] array = str.split(",");
		List<Integer> rets = new ArrayList(array.length);
		int i = 0;
		for(String id:array){
			try{
				rets.add(Integer.parseInt(id));
			}catch(Exception ex){
				throw new RuntimeException("转化 "+str+ " 到Long数组出错");
			}
		}
		return rets;
	}
}
