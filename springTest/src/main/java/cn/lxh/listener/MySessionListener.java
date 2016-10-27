package cn.lxh.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
* <p>Title: MySessionListener</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-9-30
*/
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		System.out.println("create a session");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session destory");
	}

}
