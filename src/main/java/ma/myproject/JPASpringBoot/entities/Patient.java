package ma.myproject.JPASpringBoot.entities;

import java.util.Date;

import javax.persistence.*;

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
	@Column(name = "nom", length = 7)
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private int score;
	private boolean malade;

}
