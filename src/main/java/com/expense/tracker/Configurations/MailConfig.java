package com.expense.tracker.Configurations;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

  @Value("${spring.mail.host}")
  private String mailHost;

  @Value("${spring.mail.port}")
  private int mailPort;

  @Value("${spring.mail.username}")
  private String mailUserName;

  @Value("${spring.mail.password}")
  private String mailPassword;

  @Value("${spring.mail.properties.mail.smtp.auth}")
  private boolean smtpAuth;

  @Value("${spring.mail.properties.mail.smtp.starttlsEnable}")
  private boolean starttlsEnable;

  @Bean
  JavaMailSenderImpl javaMailSender() {

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(mailHost);
    mailSender.setPort(mailPort);
    mailSender.setUsername(mailUserName);
    mailSender.setPassword(mailPassword);

    Properties mailProperties = mailSender.getJavaMailProperties();

    mailProperties.put("mail.smtp.auth", smtpAuth);
    mailProperties.put("mail.smtp.starttls.enable", starttlsEnable);

    return mailSender;
  }

}
