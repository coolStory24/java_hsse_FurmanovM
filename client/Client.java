package client;

import java.util.ArrayList;

import account.Account;
import enums.Currency;

public class Client {
  private String name;
  private String surname;
  private String phone;
  private ArrayList<Account> accounts;

  public Client(String name, String surname, String phone) {
    this.name = name;
    this.surname = surname;
    this.phone = phone;
    this.accounts = new ArrayList<>();
  }

  public String toString() {
    return name + " " + surname + ". Tel: " + phone + ". Accounts: " + accounts.size();
  }

  public String getPhone() {
    return phone;
  }

  public Client createAccount(Currency currency, String label, int amount) {
    this.accounts.add(new Account(currency, label, amount));
    return this;
  }

  public ArrayList<Account> getAllAccounts() {
    return accounts;
  }

  public Client deleteAccount(int index) {
    accounts.remove(index);
    return this;
  }
}
