package br.dcx.ufpb.chatroom.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "participants")
public class ParticipantModel implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private LocalDateTime lastActivity;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastActivity(LocalDateTime now) {
    this.lastActivity = now;
  }

  public LocalDateTime getLastActivity() {
    return lastActivity;
  }
}
