package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.trip.DependentClassCallDuringUnitTestException;

import org.craftedsw.tripservicekata.trip.TripDAO;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user){
		throw new DependentClassCallDuringUnitTestException(
				"TripDAO should not be invoked on an unit test.");
	}
	
	public List<Trip> tripBy(User user){
		return TripDAO.findTripsByUser(user);
	}
}
