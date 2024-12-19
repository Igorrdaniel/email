package com.example.email.dtos;

import com.example.email.domain.model.EmailModel;
import com.example.email.enums.StatusEmail;
import java.util.UUID;

public class EmailDto {

  private UUID id;
  private String emailTo;
  private String subject;
  private String text;
  private StatusEmail statusEmail;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public StatusEmail getStatusEmail() {
    return statusEmail;
  }

  public void setStatusEmail(StatusEmail statusEmail) {
    this.statusEmail = statusEmail;
  }

  public static EmailDto map(EmailModel emailModel) {
    EmailDto emailDto = new EmailDto();

    emailDto.setId(emailModel.getId());
    emailDto.setEmailTo(emailModel.getEmailTo());
    emailDto.setSubject(emailModel.getSubject());
    emailDto.setText(emailModel.getText());
    emailDto.setStatusEmail(emailModel.getStatusEmail());

    return emailDto;
  }
}
