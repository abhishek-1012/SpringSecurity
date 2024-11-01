package com.Spring.SpringSecurity;

public class Student {

	
	private String name;
	private int marks;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name, int marks, int id) {
		super();
		this.name = name;
		this.marks = marks;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", id=" + id + "]";
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
