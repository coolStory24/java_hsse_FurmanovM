package exceptions;

public class ClientNotFoundException extends RuntimeException {
  final public String tel;

  public ClientNotFoundException(String tel) {
    this.tel = tel;
  }
}
