
package acme.entities.assigment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Log extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private FlightAssigment		assigment;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Mandatory
	@Size(max = 50)
	private String				type;

	@Mandatory
	@Size(max = 255)
	private String				description;

	@Min(0)
	@Max(10)
	private int					severityLevel;

}
