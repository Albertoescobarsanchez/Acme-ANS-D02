
package acme.realms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractRole {

	@Mandatory
	@Pattern(regexp = "^[A-Z0-9]{6,8}$")
	@Column(unique = true)
	private String locatorCode;

	@Mandatory
	@Past
	private Date purchaseMoment;

	@Mandatory
	private TravelClass	travelClass;

	@Mandatory
	private float price;

	@Optional
	@Pattern(regexp = "^\\d{4}$")  //últimos cuatro dígitos de la tarjeta
	private String lastNibble;


}
