package cn.lxh.aspect;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.lxh.annotation.RequestLimit;
import cn.lxh.exception.RequestLimitException;
import cn.lxh.util.CommonUtils;

/**
* <p>Title: RequestLimitContract</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
@Aspect
@Component
public class RequestLimitContract {
	private static final Logger logger = Logger.getRootLogger();
	
	
	private static final ConcurrentHashMap<String, Integer> limitMap = new ConcurrentHashMap<String, Integer>();

	@Before("within(@org.springframework.stereotype.Controller *) && @annotation(limit)")
//	@Before("execution(* cn.lxh.controller..*.*(..) )")
	public void requestLimit(final JoinPoint joinPoint,RequestLimit limit) throws RequestLimitException {

		try {
			Object[] args = joinPoint.getArgs();
			HttpServletRequest request = null;
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof HttpServletRequest) {
					request = (HttpServletRequest) args[i];
					break;
				}
			}
			if (request == null) {
				throw new RequestLimitException("方法中缺失HttpServletRequest参数");
			}
			String ip = CommonUtils.getIpAddr(request);
			String url = request.getRequestURL().toString();
			String key = "req_limit_".concat(url).concat(ip);
			Integer count = limitMap.get(key);
			if (count == null) {
				count = 1;
			}
			else if (count > limit.count()) {
				logger.error("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
//				throw new RequestLimitException();
			}else{
				count ++;
			}
			limitMap.put(key, count);
		} catch (RequestLimitException e) {
			throw e;
		} catch (Exception e) {
			logger.error("发生异常: ", e);
		}
	}
	
}
