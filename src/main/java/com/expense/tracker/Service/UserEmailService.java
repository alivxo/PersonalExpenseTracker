package com.expense.tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.expense.tracker.Models.User;
import com.expense.tracker.dto.MailRequest;

@Service
public class UserEmailService {

  @Autowired
  private EmailSenderImpl emailSender;

  @Async
  public void sendRegistrationEmail(User user) {
    String to = user.getEmail();
    String subject = "Welcome to expensetracker.com";
    String body = "<h1>Hello " + user.getUsername() + "!</h1><p>Thank you for registering.</p>";
    MailRequest registrationMailRequest = new MailRequest(to, subject, body, true, false);

    emailSender.sendEmail(registrationMailRequest);
  }

  @Async
  public void sendPasswordResetEmail(User user) {
    String to = user.getEmail();
    String subject = "Reset your password for expensetracker.com";
    // TODO need to amend the resetLink to originalFunctionality
    String resetLink = "/password-reset?token=ababac";
    String body = "<p>Click the following link to reset your password:</p>" +
        "<a href=\"" + resetLink + "\">Reset Password</a>";

    MailRequest registrationMailRequest = new MailRequest(to, subject, body);

    emailSender.sendEmail(registrationMailRequest);
  }

}
