package kz.aitu.chat.controller;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.model.Participant;
import kz.aitu.chat.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/participants")
@AllArgsConstructor
public class ParticipantController {
    private ParticipantRepository participantRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(participantRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(participantRepository.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> addParticipant(@RequestBody Participant participant){
        return ResponseEntity.ok(participantRepository.save(participant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id){
        participantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
