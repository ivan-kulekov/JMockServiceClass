package service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since Apr 30 , 2015 13:55
 */
public class UserAgeValidationTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  AgeValidator ageValidator;

  @Mock
  Database database;

  private User user;


  @Before
  public void setUp() {
    user = new User("Ivan Kulekov", "22", ageValidator, database);
  }


  @Test
  public void happyPath() {
    user = new User("Ivan Kulekov", "22", ageValidator, database);
    context.checking(new Expectations() {{

      oneOf(ageValidator).isValid(user.getAge());
      will(returnValue(true));
    }});

    assertThat(user.validateAge(), is(true));
  }


  @Test
  public void invalidUserAgeValidation() {

    user = new User("Ivan Kulekov", "5", ageValidator, database);
    context.checking(new Expectations() {{

      oneOf(ageValidator).isValid(user.getAge());
      will(returnValue(false));
    }});

    assertThat(user.validateAge(), is(false));
  }


  @Test(expected = InvalidAgeError.class)
  public void invalidPersonCanNotBeRegistrable() {
    user = new User("Ivan Kulekov", "109", ageValidator, database);

    context.checking(new Expectations() {{

      oneOf(ageValidator).isValid(user.getAge());
      will(returnValue(false));
    }});

    user.registrate();
  }

  @Test
  public void readOldestUserFromDatabase() {
    final int userId = 0;

    context.checking(new Expectations() {{

      oneOf(database).getUserAge(userId);
      will(returnValue("34"));

    }});

    assertThat(user.isAdult(userId), is(true));
  }

  @Test
  public void readAdultUserFromDatabase() {

    final int userId = 0;

    context.checking(new Expectations() {{

      oneOf(database).getUserAge(userId);
      will(returnValue("14"));
    }});

    assertThat(user.isAdult(userId), is(false));
  }

}
