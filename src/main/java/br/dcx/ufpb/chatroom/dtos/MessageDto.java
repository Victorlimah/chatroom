package br.dcx.ufpb.chatroom.dtos;

import javax.validation.constraints.NotBlank;

public class MessageDto {
  
  @NotBlank
  private String sender;

  @NotBlank
  private String message;

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
