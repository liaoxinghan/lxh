package cn.lxh.test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

	public static JSONObject getJsonObj(JSONArray jsa) {
		return jsa.getJSONObject(0);
	}

	public static String getJsonString(Temp temp) {
		return JSONObject.toJSONString(temp);
	}

	public static JSONObject getJsonObj(JSONObject job, String name) {
		return job.getJSONObject(name);
	}

	public static JSONArray getJsonArry(JSONObject job, String name) {
		return job.getJSONArray(name);
	}

	public static void jsonParseForClass(String jsonMsg) {
		Temp javaObject = JSONObject.toJavaObject(JSONObject.parseObject(jsonMsg), Temp.class);
		//		Temp javaObject = JSONObject.parseObject(jsonMsg, Temp.class,com.alibaba.fastjson.parser.Feature.SupportArrayToBean);
		//		Temp parseObject = JSONObject.parseObject(jsonMsg, Temp.class);
		Error error = javaObject.getError();
		System.out.println(error.getCode());
		//		Object swing = javaObject.getSwing();
		//		System.out.println(swing instanceof JSONObject);
		//		System.out.println(swing);
	}

	public static void testFastJsonEmpty(String jsonMsg) {
		JSONObject parseObject = JSONObject.parseObject(jsonMsg);
		//		JSONObject jsonObject = parseObject.getJSONObject("error");
		//		System.out.println(jsonObject.isEmpty());
		String o = parseObject.getString("error");
		System.out.println(o == "");
		//		JSONArray jsonArray = parseObject.getJSONArray("error");
		//		System.out.println(jsonArray.isEmpty());
	}

	public static void main(String[] args) {
		String jsonStr = "{status:200,swing:{creditScore:461,rate:'40.00%'},error:{code:100,msg:'ss'},content:[{name:'liao',age:26,son:{name:'xing',age:2}}]}";
		//		JSONObject parseObject = JSONObject.parseObject(jsonStr);
		//		JSONObject jsonObj = getJsonObj(parseObject,"error");
		//		System.out.println(jsonObj.getString("code"));
		//		System.out.println();
		//		JSONArray arr = getJsonArry(parseObject, "content");
		//		System.out.println(arr);
		//		System.out.println(getJsonObj(arr));
		//		jsonParseForClass(jsonStr);
		//		Calendar instance = Calendar.getInstance();
		//		instance.add(Calendar.DAY_OF_MONTH, -6*30);
		//		System.out.println(instance.getTime());

		//		testFastJsonEmpty(jsonStr);
		//		Temp temp = new Temp();
		//		System.out.println(getJsonString(temp));
		Map<String, Object> map = JSONObject.parseObject(jsonStr);
		JSONObject.parseObject(jsonStr);
		System.out.println(map.size());
		System.out.println(map.get("status"));
//		jsonParseForClass(jsonStr);
	}
}