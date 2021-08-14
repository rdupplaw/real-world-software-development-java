package test.java;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import main.java.BankStatementCSVParser;
import main.java.BankStatementParser;
import main.java.BankTransaction;

public class BankStatementCSVParserTest {

  private final BankStatementParser statementParser = new BankStatementCSVParser();

  @Test
  public void shouldParseOneCorrectLine() throws Exception {
    final String line = "30-01-2017,-100,Deliveroo";
    final LocalDate date = LocalDate.of(2017, 1, 30);
    final double amount = -100;
    final String description = "Deliveroo";

    final BankTransaction expected = new BankTransaction(date, amount, description);
    final BankTransaction actual = statementParser.parseFrom(line);

    Assert.assertEquals(expected, actual);
  }
}
