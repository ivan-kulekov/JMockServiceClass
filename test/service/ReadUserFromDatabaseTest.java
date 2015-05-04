package service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Kulekov (ivankulekov10@gmail.com)
 * @since May 04 , 2015 11:37
 */
public class ReadUserFromDatabaseTest {


  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  public AgeValidator ageValidator;

  @Mock
  public Database database;

  private User user;


  @Before
  public void setUp() {

    user = new User("Ivan Kulekov", "22", ageValidator, database);
  }

  @Test
  public void readOldestUserFromDatabase() {
    final int userId = 0;

    context.checking(new Expectations() {{

      oneOf(database).getUserId(userId);
      will(returnValue("34"));

    }});

    assertThat(user.isAdult(userId), is(true));
  }

  @Test
  public void readAdultUserFromDatabase() {

    final int userId = 0;

    context.checking(new Expectations() {{

      oneOf(database).getUserId(userId);
      will(returnValue("14"));
    }});

    assertThat(user.isAdult(userId), is(false));
  }


}
