
package acme.realms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractRole {

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String	identifier;

	@Mandatory
	@Pattern(regexp = "\\+?\\d{6,15}$")
	private String	phoneNumber;

	@ValidString
	private String	physicalAddress;

	@Mandatory
	@ValidString
	private String	city;

	@Mandatory
	@ValidString
	private String	country;

	@Optional
	@Max(500000)
	private float	earnedPoints;
}
