package br.dcx.ufpb.chatroom.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.dcx.ufpb.chatroom.models.MessageModel;
import br.dcx.ufpb.chatroom.repositories.MessageRepository;

@Service
public class MessageService {
  final MessageRepository messageRepository;

  public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }


  public void save(MessageModel message) {
    messageRepository.save(message);
  }

  public List<MessageModel> findAll(Pageable pageable) {
    return messageRepository.findAll(pageable).getContent();
  }
  
}
