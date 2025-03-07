
package acme.entities.flight;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.realms.AirlineManager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {
	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Mandatory
	@Size(max = 50)
	private String				tag;

	private boolean				selfTransfer;

	private float				cost;

	@Optional
	@Size(max = 255)
	private String				description;
	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@Mandatory
	@NotBlank
	private String				origin;
	@Mandatory
	@NotBlank
	private String				destination;

	private int					layovers;
	private String				destination;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private AirlineManager		airlineManager;
	private int					layovers;
}
