package cn.lxh.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cn.lxh.bean.Student;
import cn.lxh.service.TestService;

@Service
@Primary
public class TestServiceImpl1 implements TestService {

	@Override
	public Student search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
