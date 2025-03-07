
package acme.realms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FligthCrewMember extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	@NotBlank
	@Automapped
	private String				employeeCode;

	@Mandatory
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	@NotBlank
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidString
	@NotBlank
	@Automapped
	private String				lenguageKills;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private Status				status;

	@Mandatory
	@NotBlank
	@Automapped
	//----------------------------RELACION
	private String				airline;

	@Mandatory
	@Automapped
	@ValidMoney
	private Money				salary;

	@Optional
	@ValidNumber
	@Automapped
	private Integer				yearsExperience;

}
