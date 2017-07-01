package test.java.org.craftedsw.tripservicekata.user;

import org.junit.Assert;
import org.junit.Test;

import main.java.org.craftedsw.tripservicekata.user.User;
import main.java.org.craftedsw.tripservicekata.UserBuilder;

public class UserTest {
	private static final User BOB = new User();
	private static final User PAUL = new User();
	
	@Test public void
	should_inform_when_users_are_not_friends(){
		User user = UserBuilder.aUser()
				.friendsWith(BOB)
				.build();
		Assert.assertEquals(user.isFriendsWith(PAUL), is(false));
	}

	private Object is(boolean b) {
		return null;
	}

	@Test public void
	should_inform_when_users_are_friends(){
		User user = UserBuilder.aUser()
				.friendsWith(BOB, PAUL)
				.build();
		
		Assert.assertEquals(user.isFriendsWith(PAUL), is(true));
	}
}