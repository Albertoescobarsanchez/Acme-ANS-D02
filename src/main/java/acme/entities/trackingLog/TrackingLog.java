
package acme.entities.trackingLog;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrackingLog extends AbstractEntity {

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@Automapped
	private Date	updateMoment;

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String	step;

	private int		resolutionPercentage;

	private boolean	accepted;

	@Optional
	@Size(max = 255)
	private String	resolution;

}
