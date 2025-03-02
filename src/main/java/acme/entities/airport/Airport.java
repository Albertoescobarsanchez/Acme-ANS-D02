
package acme.entities.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@NotBlank
	@Size(max = 50)
	String						name;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")  	// tres letras mayúsculas
	@Column(unique = true)
	private String				iataCode;

	@NotNull
	@Enumerated(EnumType.STRING)
	OperationalScope			operationalScope;

	@NotNull
	@Max(50)
	private String				city;

	@NotBlank
	@Size(max = 50)
	private String				country;

	private String				website;

	@Email
	private String				email;

	@NotBlank
	@Pattern(regexp = "\\+?\\d{6,15}$")
	private String				phoneNumber;

}
