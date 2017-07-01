package main.java.org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import main.java.org.craftedsw.tripservicekata.user.User;

public class TripService {

	@Autowired private TripDAO tripDAO;
	
	public List<Trip> getFriendTrips(User friend, User loggedInUser) throws UserNotLoggedInException {
		validate(loggedInUser);
		
		return friend.isFriendsWith(loggedInUser)
				? tripsBy(friend)
						: noTrips();	
	}
	
	private void validate(User loggedInUser) {
		if(loggedInUser == null){
			throw new UserNotLoggedInException();
		}
	}

	private ArrayList<Trip> noTrips(){
		return new ArrayList<Trip>();
	}
	
	protected List<Trip> tripsBy(User user){
		return tripDAO.tripsBy(user);
	}
}