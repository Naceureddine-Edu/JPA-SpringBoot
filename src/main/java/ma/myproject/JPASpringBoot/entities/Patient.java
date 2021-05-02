package ma.myproject.JPASpringBoot.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @Table(name = "PATIENTS")
@AllArgsConstructor @NoArgsConstructor @ToString
public class Patient {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String name;
	
	@Temporal(TemporalType.DATE) // Pour la base de donnee
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Pour la page web
	private Date dateNaissance;
	
	@DecimalMin("5") @DecimalMax("15") @NotNull
	private int score;
	
	@AssertTrue //checked par default
	private boolean malade;
}
