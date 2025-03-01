
package acme.entities.assigment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.datatypes.Money;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FligthCrewMember {

	@NotNull
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	@NotBlank
	String	employeeCode;

	@Pattern(regexp = "^\\+?\\d{6,15}$")
	@NotBlank
	String	phoneNumber;

	@Size(max = 255)
	@NotBlank
	String	lenguageKills;

	@NotNull
	@Enumerated(EnumType.STRING)
	Status	status;

	@NotBlank
	String	airline;

	@NotNull
	Money	salary;

	@Optional
	Integer	yearsExperience;

}
