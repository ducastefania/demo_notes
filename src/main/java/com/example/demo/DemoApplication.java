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
		String name = null;
		
		NotesRepository notes = new NotesRepository();
		
		if(args.length == 0) {
			
			System.out.println("Not enough arguments");
		}
		
		if(args[0].equals("-list") && args.length == 1) {
			
			List<Note> res = notes.GetAllTitles();
			 for(Note note : res) {
				System.out.println(note.Name);
			}
		}
		
		else if(args[0].equals("-list") && args.length == 2) {
			
			name = args[1];
			Note note = notes.getNoteByName(name);
			System.out.println(note.Name);
			System.out.println(note.Content);
			
		}
		
		else if(args[0].equals("-add") && args.length > 2) {
			
			name = args[1];
			StringBuilder content = new StringBuilder();
			
			for(int i = 2; i < args.length; i++) {
				content.append(args[i]);
				content.append(" ");
			}
			
			boolean fileCreated = notes.AddNote(name, content.toString());
			System.out.println(fileCreated == true ? "File added successfully" : "File with same name already exists" );
		}
		
		else {
			System.out.println("Command not recognized");
		}
		
	   System.out.println("Finish");
	    
	}
}
