package com.example.email.domain.model;

import com.example.email.enums.StatusEmail;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
public class EmailModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  private String emailFrom;

  private String emailTo;

  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  private LocalDateTime sendDateEmail;

  @Enumerated(value = EnumType.STRING)
  private StatusEmail statusEmail;

  public EmailModel(
      UUID id,
      String emailFrom,
      String emailTo,
      String subject,
      String text,
      LocalDateTime sendDateEmail,
      StatusEmail statusEmail) {
    this.id = id;
    this.emailFrom = emailFrom;
    this.emailTo = emailTo;
    this.subject = subject;
    this.text = text;
    this.sendDateEmail = sendDateEmail;
    this.statusEmail = statusEmail;
  }

  protected EmailModel() {
    super();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getEmailFrom() {
    return emailFrom;
  }

  public void setEmailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
  }

  public String getEmailTo() {
    return emailTo;
  }

  public void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDateTime getSendDateEmail() {
    return sendDateEmail;
  }

  public void setSendDateEmail(LocalDateTime sendDateEmail) {
    this.sendDateEmail = sendDateEmail;
  }

  public StatusEmail getStatusEmail() {
    return statusEmail;
  }

  public void setStatusEmail(StatusEmail statusEmail) {
    this.statusEmail = statusEmail;
  }
}
