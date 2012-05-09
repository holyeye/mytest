package test.spring.data.manytomany;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Developer {
	@Id @GeneratedValue
	private int id;
	
	@ManyToMany(cascade=ALL)
	@JoinTable(name="Project_Developer", joinColumns=@JoinColumn(name="DEVELOPER_ID"), inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
	private Collection<Project> projects = new ArrayList<Project>();
	
	public void addProject(Project project) {
		projects.add(project);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
	
	
}
