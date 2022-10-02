package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Note;
import com.example.demo.repository.NotesRepository;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class NotesController {
	
	NotesRepository notes = new NotesRepository();
	
	@GetMapping("/allnotes")
	public List<Note> GetTitiles() {
		
		return notes.GetAllTitles();
		
	}
	
	@GetMapping("/onenote")
	public Note getNote(@RequestParam("name") String name) throws IOException {
		
		return notes.getNoteByName(name);
	}
	
	@PostMapping("/addnote")
	public void AddNote(@RequestBody Note note) throws IOException {
		
		notes.AddNote(note.Name, note.Content);
		
	}

}
