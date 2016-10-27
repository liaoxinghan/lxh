package cn.lxh.util;

import javax.servlet.http.HttpServletRequest;

/**
* <p>Title: CommonUtils</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
public class CommonUtils {

	/**
	 * 
	* @Title: getIpAddr
	* @Description: 获取请求ip
	* @param @param request
	* @param @return    
	* @return String  
	* @author liaoxinghan
	* @date 2016-10-17  
	* @throws
	 */
	public static String getIpAddr(HttpServletRequest request) {
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");

	}
}
