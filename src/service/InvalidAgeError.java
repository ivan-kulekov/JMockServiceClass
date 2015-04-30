package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:44
 */
public class InvalidAgeError extends RuntimeException {
  /**
   * Create the error message when the validation is wrong.
   *
   * @param message is the message to be able to see the user when something go wrong
   */
  public InvalidAgeError(String message) {
    super(message);
  }
}