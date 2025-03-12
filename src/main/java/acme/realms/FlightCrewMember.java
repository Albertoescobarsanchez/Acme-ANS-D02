
package acme.realms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.airline.Airline;
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
	private String				employeeCode;

	@Mandatory
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidString
	@Automapped
	private String				languageSkills;

	@Mandatory
	@Valid
	@Automapped
	private Status				status;

	@Mandatory
	@Valid
	@Automapped
	private Money				salary;

	@Optional
	@ValidNumber(min = 0)
	@Automapped
	private Integer				yearsExperience;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;

}
