package acme.entities.airline;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.dom4j.tree.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline extends AbstractEntity {

    // Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
    @NotBlank
    @Size(max = 50)
    private String name;


    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[A-Z]{2}X$")  
    private String IATAcode;

    @NotBlank
    private String website;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AirlineType type;

    @NotNull
    private LocalDate foundationMoment;

    @Email
    private String email;

    @Pattern(regexp = "\\+?\\d{6,15}$")
    private String phoneNumber;

 
}