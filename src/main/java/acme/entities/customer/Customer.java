
package acme.entities.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@NotNull
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	String	identifier;

	@NotNull
	@Pattern(regexp = "\\+?\\d{6,15}$")
	String	phoneNumber;

	@NotNull
	@Size(max = 255)
	String	physicalAddress;

	@NotNull
	@Size(max = 50)
	String	city;

	@NotNull
	@Size(max = 50)
	String	country;

	@Max(500000)
	Double	earnedPoints;
}
