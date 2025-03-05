
package acme.entities.flight;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
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
	@NotNull
	@Size(max = 50)
	private String				tag;

	private boolean				selfTransfer;

	private float				cost;

	@Optional
	@Size(max = 255)
	private String				description;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@NotBlank
	private String				origin;
	@NotBlank
	private String				destination;

	private int					layovers;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private AirlineManager		airlineManager;
}
