package com.example.demo.repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.model.Note;

public class NotesRepository {
	
	public List<Note> GetAllTitles() {
		
		List<Note> result = new ArrayList<>();
		
		File file = new File("C:\\Users\\stefania\\Desktop\\demo\\src\\main\\resources\\notes");
        File[] files = file.listFiles();
        
        for(File f: files){
        	
            result.add(new Note(f.getName()));
        }
		
		return result;
	}
	
	public Note getNoteByName(String name) {
		
		Note note = null;
		
		File file = new File("C:\\Users\\stefania\\Desktop\\demo\\src\\main\\resources\\notes");
        File[] files = file.listFiles();
        
        Object[] a = Arrays.stream(files).filter(x ->  x.getName().equals(name)).toArray();
        if(a.length > 0) {
        	 File x = (File)a[0];
        	 note = new Note(x.getName());
        	 System.out.println("Found");
        }
        else {
        	System.out.println("not Found");
        }
       
      return note;
        
      //  boolean contains = Arrays.stream(files).anyMatch(x -> x.getName().equals(name));
   
		
	}
	
	public String TestMethod() {
		 String result = null;
			try {
			Resource resource = new ClassPathResource("classpath:notes/note1.txt");
		    InputStream inputStream = resource.getInputStream();
		    Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
		    result = scanner.useDelimiter("\\A").next();
		    //System.out.println(result);
			}
			catch(Exception e) {
				System.out.println("File problem");
			}
			return result;
	}
	
}
