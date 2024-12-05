package com.expense.tracker.Service;

import com.expense.tracker.dto.MailRequest;

public interface EmailSender {
  public void sendEmail(MailRequest mailRequest);
}
