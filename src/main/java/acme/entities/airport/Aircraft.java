
package acme.entities.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Optional;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {
	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@NotBlank
	@Size(max = 50)
	private String				model;

	@NotBlank
	@Column(unique = true)
	@Size(max = 50)
	String						registrationNumber;

	@Min(value = 0)
	private int					capacityPassengers;

	@Max(value = 50000)
	@Min(value = 2000)
	private int					cargoWeight;

	private boolean				status; //active or in maintenance

	@Optional
	@Size(max = 255)
	private String				details;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;
}
