package bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("acteur")
public class Acteur extends Personne {
	
}
