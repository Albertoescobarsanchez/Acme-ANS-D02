
package acme.forms;

import java.util.List;
import java.util.Map;

import acme.client.components.basis.AbstractForm;
import acme.entities.assigment.FlightAssigment;
import acme.entities.flight.Status;
import acme.realms.FlightCrewMember;

public class FlightCrewMemberDashboard extends AbstractForm {
	// Serialisation identifier -----------------------------------------------

	private static final long				serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	private List<String>					destinations; //the last five destinations to which they have been assigned

	private List<FlightCrewMember>			crews; //the crew members who were assigned with him
	private Map<Status, FlightAssigment>	assigmentsByStatus; //their flight assignments grouped by their statuses;
	private Double							average;		// average of the number of flight assignments they had in the last month
	private Integer							minimum;	// minimum of the number of flight assignments they had in the last month
	private Integer							maximum;	// maximum of the number of flight assignments they had in the last month
	private Double							standardDesviation;	// standard desviation of the number of flight assignments they had in the last month
}
