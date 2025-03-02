
package acme.realms;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractRole;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Passenger extends AbstractRole {

	@Mandatory
	@ValidString
	private String fullName;

	@Mandatory
	@Email
	private String email;
	
	@Mandatory
	@Pattern(regexp = "^[A-Z0-9]{6,9}$")
	private String passportNumber;
	
	@Mandatory
	@Past
	private Date birthDate;
	
	@Optional
	@Size(max = 50)
	private String specialNeeds;
	
}
