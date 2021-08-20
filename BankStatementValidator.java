package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BankStatementValidator {
  public Notification validate() {
    final Notification notification = new Notification();
    
    if (this.description.length() > 100) {
      notification.addError("The description is too long");
    }

    final LocalDate parsedDate;
    try {
      parsedDate = LocalDate.parse(this.date);
      if (parsedDate.isAfter(LocalDate.now())) {
        notification.addError("Date cannot be in the future");
      }
    }
    catch (DateTimeParseException e) {
      notification.addError("Invalid format for date");
    }

    final double amount;
    try {
      amount = Double.parseDouble(this.amount)
    }
    catch (NumberFormatException e) {
      notification.addError("Invalid format for amount");
    }

    return notification;
  }
}
