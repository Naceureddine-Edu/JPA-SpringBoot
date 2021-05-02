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
<<<<<<< HEAD
	
	@Temporal(TemporalType.DATE) // Pour la base de donnee
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Pour la page web
	@NotNull
=======
	@Temporal(TemporalType.DATE)
>>>>>>> parent of df3cbc9 (Methode Ajouter Patient Avec Validation De Formulaire)
	private Date dateNaissance;
	private int score;
	private boolean malade;
<<<<<<< HEAD
	
	@NotNull @Email
	private String email;
=======

>>>>>>> parent of df3cbc9 (Methode Ajouter Patient Avec Validation De Formulaire)
}
