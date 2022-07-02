package br.dcx.ufpb.chatroom.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcx.ufpb.chatroom.dtos.MessageDto;
import br.dcx.ufpb.chatroom.models.MessageModel;
import br.dcx.ufpb.chatroom.services.MessageService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/message")
public class MessageController {
  final MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping
  public ResponseEntity<String> createMessage(@RequestBody @Valid MessageDto messageDto) {
    var message = new MessageModel();
    message.setMessage(messageDto.getMessage());
    message.setSender(messageDto.getSender());
    message.setDate(LocalDateTime.now());
    messageService.save(message);
    return ResponseEntity.status(HttpStatus.CREATED).body("Message created");
  }
  @GetMapping
  public ResponseEntity<List<MessageModel>> getAllMessages(@PageableDefault(size = 50, direction = Sort.Direction.DESC) Pageable pageable) {
    var messages = messageService.findAll(pageable);
    return ResponseEntity.ok(messages);
  }

}
