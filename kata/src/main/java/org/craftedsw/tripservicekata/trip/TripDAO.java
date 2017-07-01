package test.java.org.craftedsw.tripservicekata.trip;

import test.java.org.craftedsw.tripservicekata.trip.DependentClassCallDuringUnitTestException;
import main.java.org.craftedsw.tripservicekata.trip.TripDAO;
import main.java.org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripDAOTest {

	//@Test(expected = DependentClassCallDuringUnitTestException.class) 
	public void
	should_throw_exception_when_retrieving_user_trips(){
		new TripDAO().tripsBy(new User());
	}
}
