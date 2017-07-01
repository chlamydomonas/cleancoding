package test.java.org.craftedsw.tripservicekata.trip;

import main.java.org.craftedsw.tripservicekata.UserBuilder;
import main.java.org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import main.java.org.craftedsw.tripservicekata.trip.Trip;
import main.java.org.craftedsw.tripservicekata.trip.TripDAO;
import main.java.org.craftedsw.tripservicekata.trip.TripService;
import main.java.org.craftedsw.tripservicekata.user.User;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

public class TripServiceTest {
	
	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private static final User REGISTERED_USER = new User();
	private static final User ANOTHER_USER = new User();
	private static final Trip TO_BRAZIL = new Trip();
	private static final Trip TO_LONDON = new Trip();
	
	@Mock private TripDAO tripDAO;
	
	@InjectMocks @Spy private TripService tripService = new TripService();
	
	@Before
	public void initialize(){
		tripService = new TestableTripService();
	}
	
	@Test(expected = UserNotLoggedInException.class) public void
	should_throw_an_exception_when_user_is_not_logged_in(){
		//loggedInUser = Guest;
		//tripService.getTripsByUser(UNUSED_USER);
		tripService.getFriendTrips(UNUSED_USER, GUEST);
	}
	
	@Test public void
	should_not_return_any_trips_when_users_are_not_friends(){
		User friend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER)
				.withTrips(TO_BRAZIL)
				.build();

		List<Trip> friendTrips = tripService.getFriendTrips(friend, REGISTERED_USER);
		
		Assert.assertThat(friendTrips.size(), is(0));
	}
	
	private Matcher<Integer> is(int i) {
		return null;
	}

	@Test public void
	should_return_friend_trips_when_users_are_friends(){
		User friend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER, REGISTERED_USER)
				.withTrips(TO_BRAZIL, TO_LONDON)
				.build();				

		List<Trip> friendTrips = tripService.getFriendTrips(friend, REGISTERED_USER);
		
		Assert.assertThat(friendTrips.size(), is(2));
	}

	
	public class TestableTripService extends TripService{
		@Override
		protected List<Trip> tripsBy(User user){
			return user.trips();
		}
	}
}