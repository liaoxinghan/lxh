package cn.lxh.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.lxh.annotation.RequestLimit;
import cn.lxh.bean.People;
import cn.lxh.bean.Rule;
import cn.lxh.bean.Student;
import cn.lxh.service.PeopleService;
import cn.lxh.service.RuleService;
import cn.lxh.service.TestService;

@Controller
@RequestMapping("/view")
public class ViewController {

	private static Logger logger1 = Logger.getRootLogger();

	private static Logger logger2 = Logger.getLogger(ViewController.class);

	private static Logger logger3 = Logger.getLogger("myTest");

	@Resource
	@Qualifier("testServiceImpl")
	private TestService testService;

	@Resource
	private PeopleService peopleService;

	@Resource
	private RuleService ruleService;

	@RequestMapping("/log")
	public @ResponseBody
	Rule getRule(Model model) {
		logger1.info("info");
		logger1.error("error");
		logger1.debug("debug");

		logger2.info("info");
		logger2.error("error");
		logger2.debug("debug");

		logger3.info("info");
		logger3.error("error");
		logger3.debug("debug");
		Rule rule = ruleService.searchRuleById("1");
		return rule;
	}

	@RequestMapping("/rule")
	public @ResponseBody
	Rule getRule(Model model, String id) {
		Rule rule = ruleService.searchRuleById(id);
		return rule;
	}
	
	@RequestMapping("/people")
	public @ResponseBody
	People getPeople(Model model, String id) {
		People p = peopleService.searchPeopleById(id);
		return p;
	}

	@RequestMapping("/update/people")
	public String addPeople(Model model) {
		People p = new People();
		p.setId("1");
		p.setAge(25);
		p.setName("sess");
		p.setPhone("1231321230");
		peopleService.updatePeople(p);
		p = peopleService.searchPeopleById("1");
		model.addAttribute(p);
		return "index";
	}

	@RequestMapping("/delete/people")
	public String deletePeople(Model model, String id) {
		peopleService.deletePeople(id);
//		List<People> peoples = peopleService.searchPeople();
//		model.addAttribute("peoples", peoples);
		return "showPeople";
	}

	@RequestMapping("/student")
	public Student getStudent(Model model) {
		Student search = testService.search(1);
		model.addAttribute("student", search);
		return search;
	}

	@RequestLimit(count=5,time=60000)
	@RequestMapping("/index")
	public ModelAndView toIndex(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Student search = testService.search(1);
		modelAndView.addObject(search);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/baidu")
	public String toBaidu() {
		return "redirect:http://www.baidu.com";
	}
	
	@RequestMapping("/checkParm")
	public String checkParam(HttpServletRequest request){
		Iterator iterator = request.getParameterMap().entrySet().iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next);
		}
		return "index";
	}
}
