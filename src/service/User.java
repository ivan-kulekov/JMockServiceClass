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


  public User(String userName, String userAge, AgeValidator ageValidator, Database database) {
    this.userName = userName;
    this.ageValidator = ageValidator;
    this.database = database;
    this.userAge = userAge;

  }


  public String getAge() {
    return userAge;
  }

  public boolean validateAge() {
    return ageValidator.isValid(userAge);
  }

  public void registrate() {
    if (!validateAge()) {
      throw new InvalidAgeError(String.format("Age must be from 10 to 100. Was %s instead.", this.userAge));
    }
    database.saveUser(this.userName, this.userAge);
  }

  public boolean isAdult(int userId) {
    String userAge = database.getUserAge(userId);
    int parsAge = Integer.parseInt(userAge);

    return (parsAge > adultAge);
  }
}
