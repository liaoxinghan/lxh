package cn.lxh.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lxh.bean.People;
import cn.lxh.dao.PeopleDao;
import cn.lxh.service.PeopleService;

/**
* <p>Title: PeopleServiceImpl</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-9
*/
@Service
public class PeopleServiceImpl implements PeopleService {

	@Resource
	private PeopleDao peopleDao;

	@Override
	public People searchPeopleById(String id) {
		// TODO Auto-generated method stub
		return peopleDao.findPeopleById(id);
	}

	@Override
	public void addPeople(People people) {
		// TODO Auto-generated method stub
		peopleDao.addPeople(people);
	}

	@Override
	public void deletePeople(String id) {
		// TODO Auto-generated method stub
		peopleDao.deletePeople(id);
	}

	@Override
	public void updatePeople(People people) {
		// TODO Auto-generated method stub
		peopleDao.updatePeople(people);
	}

	@Override
	public List<People> searchPeople(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return peopleDao.findPeople(parameters);
	}

	@Override
	public int countPeople(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return peopleDao.countPeople(parameters);
	}
	
}
