
package acme.forms;

import java.util.List;
import java.util.Map;

import acme.client.components.basis.AbstractForm;
import acme.entities.booking.TravelClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDashboard extends AbstractForm {

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	private List<String>				lastFiveDestinations;
	private Double						moneyInBookings;     // money spent in Bookings during the last year
	private Map<TravelClass, Integer>	bookingsByTravelClass;    // their number of bookings grouped by travel class
	private Double						countBookingCost;    // Cost of their bookings in the last five years
	private Double						averageBookingCost;
	private Double						minimumBookingCost;
	private Double						maximumBookingCost;
	private Double						standardDeviationBookingCost;
	private Double						countNumberPassengers;   // Number of passengers in their bookings
	private Double						averageNumberPassengers;
	private Double						minimumNumberPassengers;
	private Double						maximumNumberPassengers;
	private Double						standardDeviationNumberPassengers;

}
