
package acme.realms;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssistanceAgent extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String				employeeCode;

	@Mandatory
	@Size(max = 255)
	@Automapped
	private String				languages;

	@Mandatory
	@Automapped
	private Airline				airline;

	@Mandatory
	@Past
	@Automapped
	private LocalDate			startDate;

	@Size(max = 255)
	@Automapped
	private String				bio;

	@Optional
	private Double				salary;

	@Optional
	@URL
	@Automapped
	private String				photoURL;

}
