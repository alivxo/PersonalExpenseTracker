package com.expense.tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.expense.tracker.dto.MailRequest;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {

  @Autowired
  JavaMailSender javaMailSender;

  @Value("${spring.mail.defaultFromAddress}")
  private String fromAddress;

  @Override
  public void sendEmail(MailRequest mailRequest) {
    try {
      MimeMessage mimeMessage = javaMailSender.createMimeMessage();
      MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, "utf-8");

      mimeHelper.setTo(mailRequest.getTo());
      mimeHelper.setSubject(mailRequest.getSubject());
      mimeHelper.setText(mailRequest.getBody(), mailRequest.isHtml());
      mimeHelper.setFrom(fromAddress);

      javaMailSender.send(mimeMessage);
    } catch (Exception e) {
      throw new RuntimeException("Failed to send email " + mailRequest.toString(), e);
    }

  }

}
