
package acme.entities.flight;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.entities.airport.Aircraft;
import acme.entities.airport.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$")  	// tres letras mayúsculas
	@Column(unique = true)
	private String				flightNumber;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	private float				hours;

	@Mandatory
	@Enumerated(EnumType.STRING)
	private Status				status;

	@Mandatory
	private Airport				departureAirport;

	@Mandatory
	private Airport				arrivalAirport;

	@Mandatory
	private Aircraft			aircraft;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Flight				flight;
}
