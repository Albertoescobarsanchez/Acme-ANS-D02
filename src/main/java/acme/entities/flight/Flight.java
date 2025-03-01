
package acme.entities.flight;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	@NotNull
	@Size(max = 50)
	private String	tag;

	private boolean	selfTransfer;

	private float	cost;

	@Optional
	@Size(max = 255)
	private String	description;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date	scheduledDeparture;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date	scheduledArrival;

	@NotBlank
	private String	origin;
	@NotBlank
	private String	destination;

	private int		layovers;
}
