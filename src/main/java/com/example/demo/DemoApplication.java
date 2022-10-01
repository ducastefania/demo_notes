package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Note;
import com.example.demo.repository.NotesRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(DemoApplication.class);
		System.out.println("Start");
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("Runs");
		String command = null;
		String name = null;
		String content = null;
		
		NotesRepository notes = new NotesRepository();
		
		// 1st argument exists for all cases
		try {
			command = args[0];
			
			if(command.equals("-list")) {
				
				try {
					name = args[1];
					System.out.println("Will print only one title");
				}
				catch(Exception e) {
					System.out.println("Will print all titles");
				}
			}
			
			else if(command.equals("-add")) {
				
				try {
					name = args[1];
					content = args[2];
				}
				catch(Exception e) {
					System.out.println("Not enough arguments");
				}
			}
			else {
				System.out.println("Command not recognized");
			}
		}
		catch(Exception ex) {
			System.out.println("No arguments provided");
		}
		

	 //  List<Note> res = notes.GetAllTitles();
	 //  for(Note note : res) {
	//	   System.out.println(note.Name);
	 //  }
	  
		
		Note note = notes.getNoteByName("note1.txt");
		System.out.println(note.Name);
		
	   System.out.println("Finish");
	    
	}

}
