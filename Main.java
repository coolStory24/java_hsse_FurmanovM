import account.Account;
import client.Client;
import enums.Currency;
import exceptions.ClientNotFoundException;
import bank.Bank;

public class Main {
  public static void main(String[] args) {

    var bank = new Bank("Sber");

    var client1 = new Client("John", "Doe", "+79181234567")
        .createAccount(Currency.RUSSIAN_RUBLE, "Premium", 100_000)
        .createAccount(Currency.EURO, "Gold", 10_000)
        .createAccount(Currency.UNITED_STATES_DOLLAR, "Pro", 1_000);

    bank.addClient("Harry", "Porter", "+79189876543");
    bank.addClient(client1);

    try {
      bank.findClientByPhone("+79189876543").createAccount(Currency.EURO, "Extra cashback", 1_000_000);
      System.out.println(bank.getTotalAmount(Currency.EURO));

      System.out.println(bank);
      System.out.println(bank.deleteClient(client1));
      System.out.println(bank.findClientByPhone("+79189876543"));
      System.out.println(bank.findClientByPhone("+79181234567"));
    } catch (ClientNotFoundException e) {
      System.err.println("Client with tel: " + e.tel + " not found");
    }
  }
}