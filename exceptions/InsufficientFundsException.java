package exceptions;

public class InsufficientFundsException extends RuntimeException {
  final int debt;

  public InsufficientFundsException(int debt) {
    this.debt = debt;
  }
}
