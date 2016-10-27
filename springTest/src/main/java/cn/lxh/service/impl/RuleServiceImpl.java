package cn.lxh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lxh.bean.Rule;
import cn.lxh.dao.RuleDao;
import cn.lxh.service.RuleService;

/**
* <p>Title: RuleServiceImpl</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-9
*/
@Service
public class RuleServiceImpl implements RuleService {

	@Resource
	private RuleDao ruleDao;

	@Override
	public Rule searchRuleById(String id) {
		// TODO Auto-generated method stub
		return ruleDao.findRuleById(id);
	}

}
