package com.example.demo.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public Note getNoteByName(String name) throws IOException {
		
		Note note = null;
		
		File file = new File("C:\\Users\\stefania\\Desktop\\demo\\src\\main\\resources\\notes");
        File[] files = file.listFiles();
        
        Object[] a = Arrays.stream(files).filter(x -> x.getName().equals(name)).toArray();
        if(a.length > 0) {
        	 File x = (File)a[0];
        	 note = new Note(x.getName());
        	 note.Content = new String(Files.readAllBytes(Paths.get("C:\\Users\\stefania\\Desktop\\demo\\src\\main\\resources\\notes" 
                	 + "\\" + x.getName())));
        	 
        }
        else {
        	System.out.println("File not found");
        }
       
      return note;		
	}
	
	public boolean AddNote(String name, String content) throws IOException {
		
		File dir = new File("C:\\Users\\stefania\\Desktop\\demo\\src\\main\\resources\\notes");
		File newFile = new File(dir + "\\" + name);

		if(newFile.exists() == true) {
			return false; 
		}
		
		newFile.createNewFile();
		
		FileWriter myWriter = new FileWriter(dir + "\\" + name);
		myWriter.write(content);
		myWriter.close();
		
		 return true;
	}
	
}
