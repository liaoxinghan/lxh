package cn.lxh.dao;

import java.util.List;

import cn.lxh.bean.Rule;

/**
* <p>Title: RuleDao</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-9
*/
public interface RuleDao {

	public List<Rule> findRuleByPeopleId(String peopleId);

	public Rule findRuleById(String peopleId);
}
