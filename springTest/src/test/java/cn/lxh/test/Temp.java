package cn.lxh.test;

import java.util.List;

/**
* <p>Title: Temp</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-9-26
*/
public class Temp {

	private String status;

	private Error error;

	private List<Content> content;

	private Object swing;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//	public Object getError() {
	//		return error;
	//	}
	//
	//	public void setError(Object error) {
	//		this.error = error;
	//	}

	public Object getSwing() {
		return swing;
	}

	public void setSwing(Object swing) {
		this.swing = swing;
	}

	public List<Content> getContent() {
		return content;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

}

class Error {

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	//	public void setCode(String code) {
	//		this.code = code;
	//	}
	public String getMsg() {
		return msg;
	}
	//	public void setMsg(String msg) {
	//		this.msg = msg;
	//	}

}

class Content {
	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
