package cn.lxh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.lxh.bean.People;

/**
* <p>Title: PeopleDao</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-9
*/
public interface PeopleDao {

	public People findPeopleById(String id);

	public List<People> findPeople(Map<String, Object> parameters);
	
	public int countPeople(Map<String, Object> parameters);

	public void addPeople(People people);

	public void deletePeople(String id);

	public void updatePeople(People people);


	public List<Map<String, Object>> findPeopleToMap(String id);
}
