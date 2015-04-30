package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:43
 */
public interface Database {
  /**
   * Here we define the method witch is for to save the user to the database.
   *
   * @param UserName is the name of the user.
   * @param UserAge  are the age of the user.
   */
  void saveUser(String UserName, String UserAge);

  /**
   * Create the method to get the user age.
   *
   * @param UserId is the id on each user.
   * @return is to return the user id.
   */
  public String getUserAge(int UserId);
}
