
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

	@NotBlank
	@Size(max = 50)
	String				name;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")  	// tres letras mayúsculas
	@Column(unique = true)
	String				iataCode;

	@NotNull
	@Enumerated(EnumType.STRING)
	OperationalScope	operationalScope;

	@NotNull
	@Max(50)
	String				city;

	@NotBlank
	@Size(max = 50)
	String				country;

	String				website;

	@Email
	String				email;

	@NotBlank
	@Pattern(regexp = "\\+?\\d{6,15}$")
	String				phoneNumber;

}
