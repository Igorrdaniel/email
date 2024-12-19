package com.example.email.consumer;

import com.example.email.domain.model.EmailModel;
import com.example.email.dtos.EmailDto;
import com.example.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

  private final EmailService emailService;

  public EmailConsumer(EmailService emailService) {
    this.emailService = emailService;
  }

  @RabbitListener(queues = "${broker.queue.email.name}")
  public void listenEmailQueue(@Payload EmailDto emailDto) {
    EmailModel emailModel = new EmailModel();
    BeanUtils.copyProperties(emailDto, emailModel);

    emailService.sendEmail(emailModel);
  }
}
