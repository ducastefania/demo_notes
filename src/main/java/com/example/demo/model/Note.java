package com.example.demo.model;

public class Note {

	public String Name;
	public String Content;
	
	public Note(String name) {
		
		this.Name = name;
	}
	
	public Note(String name, String content) {
		
		this.Name = name;
		this.Content = content;
	}
}
