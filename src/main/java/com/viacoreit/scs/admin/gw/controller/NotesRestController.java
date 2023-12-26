package com.viacoreit.scs.admin.gw.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.viacoreit.scs.admin.gw.entity.Note;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.service.impl.NoteService;
import com.viacoreit.scs.admin.gw.service.impl.UtilService;

@RestController
@RequestMapping(path = "${api}/notes")
public class NotesRestController {
/**
	private final NoteService noteService;
	private final UtilService utilService;

	
	ModelMapper modelMapper = new ModelMapper();

	public NotesRestController(NoteService noteService,
								UtilService utilService) {
		this.noteService = noteService;
		this.utilService = utilService;
	}

	
	@GetMapping
	public List<Note> getNotes(@RequestParam Boolean showOnlyActivePatients) {
		return this.noteService.getNotes(showOnlyActivePatients, utilService.getModuleUserLogged());
	}
	
	
	@GetMapping(path = "/{patientFileId}")
	public List<Note> getNotesByPatient(@PathVariable Long patientFileId) {
		return this.noteService.getNotesByPatientFile(patientFileId);
	}

//	@PostMapping(path = "")
//	public PatientFileNoteDto addNote(@RequestBody PatientFileNoteDto newNote) {		
//		Note note = modelMapper.map(newNote, Note.class);
//		note = this.noteService.addNote(note, utilService.getModuleUserLogged());	
//		return modelMapper.map(note,PatientFileNoteDto.class);
//	}

//	@PutMapping(path = "/{noteId}")
//	public PatientFileNoteDto editNote(@PathVariable Long noteId, @RequestBody PatientFileNoteDto newNote) {
//		Note note = modelMapper.map(newNote, Note.class);
//		note = this.noteService.editNote(noteId, note, utilService.getModuleUserLogged());	
//		return modelMapper.map(note,PatientFileNoteDto.class);
//	}

//	@DeleteMapping(path = "/{noteId}")
//	public void deleteNote(@PathVariable Long noteId) {
//		Note note = this.noteService.findById(noteId);
//		if (note == null){
//			throw new ResourceNotFoundException("Note not found");
//		}
//		this.noteService.deleteNote(note);
//	}
*/
}