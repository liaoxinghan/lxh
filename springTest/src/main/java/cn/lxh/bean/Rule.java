package cn.lxh.bean;

import java.io.Serializable;

public class Rule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rule() {
	}

	public Rule(String title, Integer score) {
		super();
		this.title = title;
		this.score = score;
	}

	private String id;

	private String title;

	private Integer score;

	private People people;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
}
