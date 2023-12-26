package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.viacoreit.scs.admin.gw.entity.Note;

/**
 * Repositorio de la entidad {@link Note}
 
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("FROM Note pfn, PatientFile pfp WHERE pfn.patientFile.id = pfp.id and (:patientFileStatus IS NULL OR pfp.status = :patientFileStatus) AND pfn.module = :module ORDER BY pfn.id DESC")
    List<Note> findAllNotes(Optional<String> patientFileStatus, String module);

    
    @Query("FROM Note pfn WHERE pfn.patientFile.id = :patientFileId ORDER BY pfn.id DESC")
    List<Note> findByPatientFileIdOrderByIdDesc(Long patientFileId);
    
}*/
