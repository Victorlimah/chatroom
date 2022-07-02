package br.dcx.ufpb.chatroom.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcx.ufpb.chatroom.models.ParticipantModel;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantModel, UUID> {

  List<ParticipantModel> findAll();
}
