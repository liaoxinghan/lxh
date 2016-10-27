package cn.lxh.util;

import org.springframework.util.StringUtils;

import cn.lxh.constant.ErrorConstant;
import cn.lxh.result.ServerError;

/**
* <p>Title: ConversionCode</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
public class ConversionCode {

	public static ServerError.errorCode escapeError(String code){
		ServerError.errorCode result = null;
		if(StringUtils.isEmpty(code)){
			return null;
		}else{
			switch (code) {
			case ErrorConstant.ACCESS_RESTRICTIONS:
				result = ServerError.errorCode.ACCESS_RESTRICTIONS;
				break;
			default:
				break;
			}
			return result;
		}
	}
}
