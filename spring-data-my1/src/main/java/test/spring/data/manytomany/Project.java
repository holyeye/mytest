package test.spring.data.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id @GeneratedValue
	private int id;

	@ManyToMany(mappedBy = "projects", cascade=CascadeType.ALL)
	private Collection<Developer> developers = new ArrayList<Developer>();;

	public void addDeveloper(Developer developer) {
		developers.add(developer);
		developer.addProject(this);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Collection<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Collection<Developer> developers) {
		this.developers = developers;
	}
	
	
}
