package br.dcx.ufpb.chatroom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcx.ufpb.chatroom.services.ParticipantService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/participant")
public class ParticipantController {
  final ParticipantService participantService;

  public ParticipantController(ParticipantService participantService) {
    this.participantService = participantService;
  }
}
