
package acme.entities.claim;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Automapped
	private Date		registrationMoment;

	@Mandatory
	@Automapped
	@Email
	private String		passengerEmail;

	@Mandatory
	@Size(max = 255)
	private String		description;

	@Mandatory
	@Enumerated(EnumType.STRING)
	private ClaimType	type;

	@Mandatory
	private Boolean		accepted;

}
