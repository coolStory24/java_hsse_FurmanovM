package bank;

import java.util.ArrayList;

import account.Account;
import client.Client;
import enums.Currency;
import exceptions.ClientNotFoundException;

public class Bank {
  private String name;
  private ArrayList<Client> clients;

  public Bank(String name) {
    this.name = name;
    clients = new ArrayList<>();
  }

  public String toString() {
    return name + ". " + clients.size() + " clients.";
  }

  public Bank addClient(String name, String surname, String phone) {
    clients.add(new Client(name, surname, phone));
    return this;
  }

  public Bank addClient(Client client) {
    clients.add(client);
    return this;
  }

  public Bank deleteClient(Client client) {
    clients.remove(client);
    return this;
  }

  public ArrayList<Client> getAllClients() {
    return this.clients;
  }

  public Client findClientByPhone(String phone) throws ClientNotFoundException {
    for (Client client : clients) {
      if (client.getPhone().equals(phone)) {
        return client;
      }
    }
    throw new ClientNotFoundException(phone);
  }

  public int getTotalAmount(Currency currency) {
    int sum = 0;
    for (Client client : clients) {
      var accounts = client.getAllAccounts();
      for (Account account : accounts) {
        if (account.getCurrency() == currency) {
          sum += account.getAmount();
        }
      }
    }

    return sum;
  }
}
