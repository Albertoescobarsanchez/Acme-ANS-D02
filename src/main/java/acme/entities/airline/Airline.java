
package acme.entities.airline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Mandatory
	@Size(max = 50)
	@Automapped
	private String				name;

	@Id
	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2}X$")
	private String				iataCode;

	@Mandatory
	@Automapped
	private String				website;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Automapped
	private AirlineType			type;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Automapped
	private Date				foundationMoment;

	@Optional
	@Email
	@Automapped
	private String				email;

	@Optional
	@Pattern(regexp = "\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

}
