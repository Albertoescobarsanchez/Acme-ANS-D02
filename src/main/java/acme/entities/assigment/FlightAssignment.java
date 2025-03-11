
package acme.entities.assigment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.entities.flight.Leg;
import acme.realms.FlightCrewMember;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightAssignment extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne
	@Automapped
	private Leg					leg;

	@Mandatory
	@Valid
	@ManyToOne
	private FlightCrewMember	member;

	@Mandatory
	@NotNull
	@Enumerated(EnumType.STRING)
	@Automapped
	private Duty				duty;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	private Date				lastUpdate;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private Status				status;

	@ValidString
	@Optional
	@Automapped
	private String				remarks;

	@Mandatory
	@Valid
	@Automapped
	private Boolean				publish;
}
