
package acme.entities.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.PositiveOrZero;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	// Serialisation version ---------------------

	private static final long	serialVersionUID	= 1L;

	// Attributtes ------------------------------

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				picture;

	@Mandatory
	@PositiveOrZero
	private Double				averageDwellTime;

	@Optional
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{4}-[0-9]{2}$")
	private String				promotionCode;

	@Optional
	@ValidNumber
	@Automapped
	private Double				discount;
}
