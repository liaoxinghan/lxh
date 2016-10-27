package cn.lxh.service;

import java.util.List;
import java.util.Map;

import cn.lxh.bean.People;

/**
* <p>Title: PeopleService</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-9
*/
public interface PeopleService {
	public People searchPeopleById(String id);

	public List<People> searchPeople(Map<String, Object> parameters);
	
	public int countPeople(Map<String, Object> parameters);

	public void addPeople(People people);

	public void deletePeople(String id);

	public void updatePeople(People people);
}
