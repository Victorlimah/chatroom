package br.dcx.ufpb.chatroom.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String sender;

  @Column(nullable = false)
  private String message;

  @Column(nullable = false)
  private LocalDateTime date;

  public String getSender() {
    return sender;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
