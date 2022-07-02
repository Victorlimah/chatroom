package br.dcx.ufpb.chatroom.services;

import org.springframework.stereotype.Service;

import br.dcx.ufpb.chatroom.repositories.ParticipantRepository;

@Service
public class ParticipantService {
  final ParticipantRepository participantRepository;

  public ParticipantService(ParticipantRepository participantRepository) {
    this.participantRepository = participantRepository;
  }
}
