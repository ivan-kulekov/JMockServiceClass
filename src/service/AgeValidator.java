package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:42
 */
public interface AgeValidator {
  /**
   * Define the method to check the ages , if they are valid or not.
   *
   * @param age are the age on user.
   * @return is return true or false.
   */
  boolean isValid(String age);
}
