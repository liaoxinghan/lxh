package cn.lxh.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lxh.bean.People;
import cn.lxh.service.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {

	private static Logger logger1 = Logger.getRootLogger();

	private static Logger logger2 = Logger.getLogger(PeopleController.class);

	private static Logger logger3 = Logger.getLogger("myTest");

	@Resource
	private PeopleService peopleService;

	@RequestMapping("/get")
	public @ResponseBody
	Map<String,Object> getPeople(Model model, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
		Map<String,Object> parameters = new HashMap<String,Object>();
		while(iterator.hasNext()){
			Entry<String, String[]> next = iterator.next();
			String[] value = next.getValue();
			if(value.length == 1){
				parameters.put(next.getKey(), value[0]);
			}
		}
		Map<String,Object> result = new HashMap<String,Object>();
		int countPeople = peopleService.countPeople(parameters);
		List<People> searchPeople = peopleService.searchPeople(parameters); 
		result.put("rows", searchPeople);
		result.put("total", countPeople);
		return result;
	}

	@RequestMapping("/to")
	public String toPeople(Model model, Map<String, Object> parameters) {
		return "people";
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
}
