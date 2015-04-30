package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:43
 */
public interface Database {
  void saveUser(String UserName, String UserAge);

  public String getUserAge(int UserId);
}
