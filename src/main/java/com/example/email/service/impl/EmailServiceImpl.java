package com.example.email.service.impl;

import com.example.email.domain.model.EmailModel;
import com.example.email.domain.repositories.EmailRepository;
import com.example.email.enums.StatusEmail;
import com.example.email.service.EmailService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  private final EmailRepository emailRepository;
  private final JavaMailSender javaEmailSender;

  public EmailServiceImpl(EmailRepository emailRepository, JavaMailSender javaEmailSender) {
    this.emailRepository = emailRepository;
    this.javaEmailSender = javaEmailSender;
  }

  @Value(value = "${spring.mail.username}")
  private String emailFrom;

  @Override
  @Transactional
  public EmailModel sendEmail(EmailModel emailModel) {
    try {
      emailModel.setSendDateEmail(LocalDateTime.now());
      emailModel.setEmailFrom(emailFrom);

      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());

      javaEmailSender.send(message);

      emailModel.setStatusEmail(StatusEmail.SENT);
    } catch (MailException e) {
      emailModel.setStatusEmail(StatusEmail.ERROR);
    } finally {
      emailRepository.save(emailModel);
    }
    return emailModel;
  }
}
