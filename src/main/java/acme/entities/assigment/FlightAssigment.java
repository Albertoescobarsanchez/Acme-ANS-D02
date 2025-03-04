
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
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.entities.flight.Leg;
import acme.realms.FligthCrewMember;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightAssigment extends AbstractEntity {

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
	private FligthCrewMember	member;

	@Mandatory
	@NotNull
	@Enumerated(EnumType.STRING)
	@Automapped
	private Duty				duty;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				lastUpdate;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private Status				status;

	@Size(max = 255)
	@Optional
	@Automapped
	private String				remarks;

	@Mandatory
	@Valid
	@Automapped
	private Boolean				publish;
}
