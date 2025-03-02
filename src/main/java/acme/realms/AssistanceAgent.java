package acme.realms;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import acme.client.components.validation.Mandatory;
import acme.client.components.basis.AbstractRole;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AssistanceAgent extends AbstractRole {

    private static final long	serialVersionUID	= 1L;
    
    @Mandatory
    @Pattern(regexp = "^[A-Z]{2-3}\\d{6}$") 
	@Column(unique = true)
    private String employeeCode;

    @Mandatory
    @Size(max = 255)
    private String languages;

    @Mandatory
    private Airline airline;

    @Mandatory
    @Past
    private LocalDate startDate;

    @Size(max = 255)
    private String bio;

    private Double salary;

    @URL
    private String photoURL;


}
