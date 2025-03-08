
package acme.entities.assigment;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.entities.flight.Leg;
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
	@OneToMany
	private List<Leg>			leg;

	@Mandatory
	@NotNull
	@Enumerated(EnumType.STRING)
	private Duty				duty;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				lastUpdate;

	@Mandatory
	@Enumerated(EnumType.STRING)
	private Status				status;

	@Size(max = 255)
	@Optional
	private String				remarks;

}
