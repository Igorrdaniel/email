package com.example.email.domain.repositories;

import com.example.email.domain.model.EmailModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {}
