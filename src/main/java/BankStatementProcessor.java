package main.java;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Carries out calculations on bank transactions.
 */
public class BankStatementProcessor {
  private final List<BankTransaction> bankTransactions;

  public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  public double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
    return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
  }

  public double summarizeTransactions() {
    return calculateTotalAmount(bankTransactions);
  }

  public double calculateTotalInMonth(final Month month) {
    return calculateTotalAmount(findTransactionsInMonth(month));
  }

  public double calculateTotalForCategory(final String category) {
    return calculateTotalAmount(findTransactionsInCategory(category));
  }

  public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
    return bankTransactions.stream().filter(bankTransactionFilter::test).collect(Collectors.toList());
  }

  public List<BankTransaction> findTransactionsGreaterThanOrEqual(final double minimum) {
    return findTransactions(bankTransaction -> bankTransaction.getAmount() >= minimum);
  }

  public List<BankTransaction> findTransactionsInMonth(final Month month) {
    return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth().equals(month));
  }

  public List<BankTransaction> findTransactionsInCategory(final String category) {
    return findTransactions(bankTransaction -> bankTransaction.getDescription().equals(category));
  }
}
