
package acme.entities.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport extends AbstractEntity {

	// Serialisation version ---------------------

	private static final long	serialVersionUID	= 1L;

	// Attributtes ------------------------------

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@Pattern(regexp = "^[A-Z]{3}$")  	// tres letras mayúsculas
	@Column(unique = true)
	private String				iataCode;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private OperationalScope	operationalScope;

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String				city;

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String				country;

	@Optional
	@ValidString
	@Automapped
	private String				website;

	@Optional
	@ValidEmail
	@Automapped
	private String				email;

	@Optional
	@Pattern(regexp = "\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

}
