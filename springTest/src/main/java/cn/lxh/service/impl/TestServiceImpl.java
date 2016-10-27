package cn.lxh.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cn.lxh.bean.Student;
import cn.lxh.service.TestService;

@Service
public class TestServiceImpl implements TestService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("已实例化");

	}

	@Override
	public Student search(int id) {
		// TODO Auto-generated method stub
		//		int a = 1/0;
		System.out.println("invoke...impl");
		Student st = new Student();
		st.setAge(26);
		st.setClassName("三年二班");
		st.setSid("1001001");
		return st;
	}

}
