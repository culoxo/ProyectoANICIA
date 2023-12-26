package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.viacoreit.scs.admin.gw.entity.Note;
//import com.viacoreit.scs.admin.gw.repository.NoteRepository;


@Service
public class NoteService {
    /**
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> getNotes(Boolean showOnlyActive, String module) {
//        Optional<String> patientFileStatus = showOnlyActive ? Optional.of(PatientFileStatus.ACTIVE) : Optional.empty();
//        return this.noteRepository.findAllNotes(patientFileStatus, module);
    	return null;
    }
    
    public List<Note> getNotesByPatientFile(Long patientFileId) {
        return this.noteRepository.findByPatientFileIdOrderByIdDesc(patientFileId);
    }

    public Note addNote(Note newNote, String module) {
    	newNote.setModule(module);
        return this.noteRepository.save(newNote);
    }

    public Note editNote(Long noteId, Note newNote, String module) {
    	newNote.setId(noteId);
    	newNote.setModule(module);    	
        return this.noteRepository.save(newNote);
    }

 		public Note findById(Long noteId) {
    	return noteRepository.getById(noteId);
		}

    public void deleteNote(Note note) {
				note.setDeleted(Boolean.TRUE);
        this.noteRepository.save(note);
    }
*/
}