package service;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:45
 */
public class User {

  private final AgeValidator ageValidator;
  private String userAge;
  private Database database;
  private String userName;
  private int adultAge = 18;

  /**
   * Create the constructor for the User class.
   *
   * @param userName     is the name of the user.
   * @param userAge      is the age of the user.
   * @param ageValidator is for to validate the age on the user.
   * @param database     is for to connect to the database.
   */

  public User(String userName, String userAge, AgeValidator ageValidator, Database database) {
    this.userName = userName;
    this.ageValidator = ageValidator;
    this.database = database;
    this.userAge = userAge;

  }

  /**
   * Create the getter for the age.
   *
   * @return the user age.
   */
  public String getAge() {
    return userAge;
  }

  /**
   * Create a method witch is for to validate ages.
   *
   * @return the validation on the ages.
   */
  public boolean validateAge() {

    if (ageValidator.isValid(userAge)) {
      return true;
    }

    return false;
  }

  /**
   * Create the method to register the user if the ages are valid.
   */
  public void register() {
    if (!validateAge()) {
      throw new InvalidAgeError(String.format("Age must be from 10 to 100. Was %s instead.", this.userAge));
    }
    database.saveUser(this.userName, this.userAge);
  }

  /**
   * Create the method to check the user is the adult or not.
   *
   * @param userId is the id on the user in our database.
   * @return is the returned values.
   */
  public boolean isAdult(int userId) {
    String userAge = database.getUserId(userId);
    int parsAge = Integer.parseInt(userAge);

    return (parsAge > adultAge);
  }
}
