package com.example.email.service;

import com.example.email.domain.model.EmailModel;

public interface EmailService {

    EmailModel sendEmail(EmailModel emailModel);
}
