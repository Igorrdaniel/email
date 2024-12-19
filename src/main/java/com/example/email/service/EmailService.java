package com.example.email.service;

import com.example.email.dtos.EmailDto;

public interface EmailService {

    EmailDto sendEmail(EmailDto emailDto);
}
