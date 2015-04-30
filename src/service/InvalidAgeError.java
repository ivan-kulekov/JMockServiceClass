package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:44
 */
public class InvalidAgeError extends RuntimeException {
  public InvalidAgeError(String message) {
    super(message);
  }
}