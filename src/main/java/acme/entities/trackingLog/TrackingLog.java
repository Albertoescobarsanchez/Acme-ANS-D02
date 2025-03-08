
package acme.entities.trackingLog;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrackingLog extends AbstractEntity {

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date	updateMoment;

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String	step;

	@Mandatory
	private Integer	resolutionPercentage;

	@Mandatory
	private Boolean	accepted;

	@Size(max = 255)
	private String	resolution;

}
