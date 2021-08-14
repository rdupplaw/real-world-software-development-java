package main.java;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    final String fileName = args[0];
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
    bankStatementAnalyzer.analyze(fileName, bankStatementParser);
  }
}
