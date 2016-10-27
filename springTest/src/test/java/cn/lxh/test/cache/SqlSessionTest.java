package cn.lxh.test.cache;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lxh.bean.Rule;
import cn.lxh.dao.PeopleDao;
import cn.lxh.dao.RuleDao;

/**
* <p>Title: SqlSessionTest</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-10
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class SqlSessionTest {

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Before
	public void setUp() throws IOException {
		// 通过配置文件获取数据库连接信息
		//		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		// 通过配置信息构建一个SqlSessionFactory
		//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过sqlSessionFactory打开一个数据库会话

	}

	@Test
	public void testFindRule() throws Exception {
		SqlSession sqlSession1 = sessionFactory.openSession();
		RuleDao ruleDao = sqlSession1.getMapper(RuleDao.class);
		SqlSession sqlSession2 = sessionFactory.openSession();
		RuleDao ruleDao1 = sqlSession2.getMapper(RuleDao.class);
		Rule rule = ruleDao.findRuleById("1");
		sqlSession1.close();
		Rule rule1 = ruleDao1.findRuleById("1");
		System.err.println(rule == rule1);
	}
	
	@Test
	public void testFindPeople(){
		try {
			SqlSession sqlSession = sessionFactory.openSession();
			PeopleDao peopleDao = sqlSession.getMapper(PeopleDao.class);
			RuleDao ruleDao = sqlSession.getMapper(RuleDao.class);
//			List<Object> selectList = sqlSession.selectList("cn.lxh.dao.PeopleDao.findPeopleToMap", "1");
//			List<Rule> rules = ruleDao.findRuleByPeopleId("1");
			List<Map<String, Object>> findPeopleToMap = peopleDao.findPeopleToMap("1");
//			sqlSession.close();
			System.err.println(findPeopleToMap.size()); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
