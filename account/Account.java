package account;

import java.lang.String;

import enums.Currency;
import exceptions.InsufficientFundsException;

public class Account {
  final private Currency currency;
  private int amount;
  private String label;

  public Account(Currency currency, String label, int amount) {
    this.currency = currency;
    this.label = label;
    this.amount = amount;
  }

  public String toString() {
    return label + ", " + currency + ": " + amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public int getAmount() {
    return amount;
  }

  public Account increaseAmount(int number) {
    amount += number;
    return this;
  }

  public Account decreaseAmount(int number) throws InsufficientFundsException {
    if (amount < number) {
      throw new InsufficientFundsException(number - amount);
    } else {
      amount -= number;
      return this;
    }
  }

  public Account rename(String label) {
    this.label = label;
    return this;
  }
}
