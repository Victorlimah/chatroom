package br.dcx.ufpb.chatroom.controllers;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcx.ufpb.chatroom.dtos.ParticipantDto;
import br.dcx.ufpb.chatroom.models.ParticipantModel;
import br.dcx.ufpb.chatroom.services.ParticipantService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/participant")
public class ParticipantController {
  final ParticipantService participantService;

  public ParticipantController(ParticipantService participantService) {
    this.participantService = participantService;
  }

  @PostMapping
  public ResponseEntity<String> createParticipant(@RequestBody @Valid ParticipantDto participantDto) {
  
    var participant = new ParticipantModel();
    participant.setName(participantDto.getName());
    participant.setLastActivity(LocalDateTime.now());

    participantService.save(participant);
    return ResponseEntity.status(HttpStatus.CREATED).body("Participant created");
  }

  @GetMapping
  public ResponseEntity<List<ParticipantModel>> getAllParticipants() {
    var participants = participantService.findAll();
    participants.removeIf(p -> p.getLastActivity().isBefore(LocalDateTime.now().minusMinutes(1)));
    return ResponseEntity.ok(participants);
  }

  @PutMapping
  public ResponseEntity<String> updateParticipant(@RequestBody @Valid ParticipantDto participantDto) {
    var participant = new ParticipantModel();
    participant.setName(participantDto.getName());
    participant.setLastActivity(LocalDateTime.now());

    participantService.save(participant);
    return ResponseEntity.status(HttpStatus.OK).body("Participant updated");
  }

  @PutMapping("/activity/{id}")
  public ResponseEntity<String> updateParticipantActivity(@PathVariable(value = "id") String id, @RequestBody @Valid ParticipantDto participantDto) {
    var uuid = UUID.fromString(id);
    Optional<ParticipantModel> participant = participantService.findById(uuid);

    if (participant.isPresent()) {
      participant.get().setLastActivity(LocalDateTime.now());
      participantService.save(participant.get());
      return ResponseEntity.status(HttpStatus.OK).body("Participant updated");
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");
  }

}
