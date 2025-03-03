
package acme.realms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMember extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	@NotBlank
	private String				employeeCode;

	@Mandatory
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	@NotBlank
	private String				phoneNumber;

	@Mandatory
	@Size(max = 255)
	@NotBlank
	private String				languageSkills;

	@Mandatory
	@Enumerated(EnumType.STRING)
	private Status				status;

	@Mandatory
	@NotBlank
	private String				airline;

	@Mandatory
	private Money				salary;

	@Optional
	private Integer				yearsExperience;

}
