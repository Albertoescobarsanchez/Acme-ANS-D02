
package acme.entities.airport;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport {

	@NotNull
	@Size(max = 50)
	String name;

	@NotNull
    @Pattern(regexp = "^[A-Z]{3}$")  	// tres letras mayúsculas
	String	iataCode;

	@NotNull
	@Enumerated(EnumType.STRING)
	OperationalScope operationalScope;

	@NotNull
	@Size(max = 50)
	String	city;

	@NotNull
	@Size(max = 50)
	String	country;

	String website;
	String	email;

	@Pattern(regexp = "\\+?\\d{6,15}$")
	String	phoneNumber;

}
