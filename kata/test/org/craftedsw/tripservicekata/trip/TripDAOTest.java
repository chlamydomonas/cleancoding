package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class TripDAOTest {

	@Test(expected = DependentClassCallDuringUnitTestExceptioin.class) public void
	should_throw_exception_when_retrieving_user_trips(){
		new TripDAO().tripBy(new User());
	}
}
