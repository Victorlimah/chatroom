package br.dcx.ufpb.chatroom.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.dcx.ufpb.chatroom.models.ParticipantModel;
import br.dcx.ufpb.chatroom.repositories.ParticipantRepository;

@Service
public class ParticipantService {
  final ParticipantRepository participantRepository;

  public ParticipantService(ParticipantRepository participantRepository) {
    this.participantRepository = participantRepository;
  }

  @Transactional
  public void save(ParticipantModel participant) {
    participantRepository.save(participant);
  }

  public List<ParticipantModel> findAll() {
    return participantRepository.findAll();
  }
}
