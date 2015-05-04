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
  public AgeValidator userAge;

  @Mock
  public Database database;

  private User user;


  @Before
  public void setUp() {

    user = new User("Ivan Kulekov", "22", userAge, database);
  }


  @Test
  public void happyPath() {
    user = new User("Peter", "20", userAge, database);
    context.checking(new Expectations() {{

      oneOf(userAge).isValid(user.getAge());
      will(returnValue(true));
    }});

//    user.register();
    assertThat(user.validateAge(), is(true));
  }


  @Test(expected = InvalidAgeError.class)
  public void invalidPersonCanNotBeRegistrable() {
    user = new User("Ivan Kulekov", "109", userAge, database);

    context.checking(new Expectations() {{

      oneOf(userAge).isValid(user.getAge());
      will(returnValue(false));
    }});

    user.register();
    assertThat(user.validateAge(), is(false));
  }

}
