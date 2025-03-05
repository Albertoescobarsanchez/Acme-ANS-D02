
package acme.realms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.entities.booking.Booking;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractRole {

	// Serialisation version ---------------------

	private static final long	serialVersionUID	= 1L;

	// Attributtes ------------------------------

	@Mandatory
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String				identifier;

	@Mandatory
	@Pattern(regexp = "\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidString
	@Automapped
	private String				physicalAddress;

	@Mandatory
	@ValidString
	@Automapped
	private String				city;

	@Mandatory
	@ValidString
	@Automapped
	private String				country;

	@Optional
	@Max(500000)
	private float				earnedPoints;

	@Mandatory
	@Valid
	@OneToMany(mappedBy = "customer")
	private List<Booking>		bookings;

}
