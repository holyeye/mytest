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
public class DeveloperUni {
	@Id @GeneratedValue
	private int id;
	
	@ManyToMany(cascade=ALL)
	@JoinTable(name="ProjectUni_DeveloperUni", joinColumns=@JoinColumn(name="DEVELOPER_ID"), inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
	private Collection<ProjectUni> projects = new ArrayList<ProjectUni>();
	
	public void addProjectUni(ProjectUni project) {
		projects.add(project);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<ProjectUni> getProjects() {
		return projects;
	}

	public void setProjects(Collection<ProjectUni> projects) {
		this.projects = projects;
	}

	
}
