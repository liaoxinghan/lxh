package cn.lxh.filter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
* <p>Title: VisitFilter</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-12
*/
public class VisitFilter implements Filter {

	private static Properties p = null;
	static {
		p = new Properties();
		try {
			String rootPath  = VisitFilter.class.getClassLoader().getResource("/").getPath();
			p.load(new FileReader(rootPath + "/ipLimit.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String rootPath  = "";
	
	private ConcurrentHashMap<String, Integer> ipRecord = new ConcurrentHashMap<String, Integer>();

	Logger logger = Logger.getLogger("visit");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
//		ServletContext servletContext = filterConfig.getServletContext();
		rootPath = filterConfig.getServletContext().getContextPath();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if(!req.getRequestURI().contains("/base")){
			String remoteAddr = req.getRemoteAddr();
			String protocol = req.getProtocol();
//		String remoteHost = req.getRemoteHost();
			int remotePort = req.getRemotePort();
			System.out.println("ip = " + remoteAddr + " port =" + remotePort + " protocol " + protocol);
//		logger.info(remoteAddr + "invoking the inteeface:" + );
			Integer remoteIpCount = ipRecord.get(remoteAddr);
			if(remoteIpCount != null){
				if(remoteIpCount >= Integer.parseInt(p.getProperty("maxLimit"))){
//				req.setAttribute("error", "您的访问过于频繁!");
//				request.getRequestDispatcher("/WEB-INF/page/error.jsp").forward(request, response);
					res.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath() +"/base/error?errorCode=666");
					
					return;
				}else{
					ipRecord.put(remoteAddr, ++ remoteIpCount);
				}
			}else{
				ipRecord.put(remoteAddr, 1);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
