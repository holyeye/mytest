package test.spring.data.manytomany;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class DeveloperTest {

	@PersistenceContext EntityManager em;
	
	@Test
	public void testBid() {
		
		Developer dev = new Developer();
		Project project = new Project();
		
		dev.addProject(project);
		em.persist(dev);
		
		em.flush();
		em.clear();
		
		Developer find = em.find(Developer.class, dev.getId());
		Collection<Project> projects = find.getProjects();
		for (Project project2 : projects) {
			System.out.println(project2);
		}
		
	}
	
	@Test
	public void testBid2() {
		
		Project project = new Project();
		
		Developer developer = new Developer();
		project.addDeveloper(developer);
		
		em.persist(project);
		
		em.flush();
		em.clear();
		
		Project find = em.find(Project.class, project.getId());
		Collection<Developer> developers = find.getDevelopers();
		for (Developer developer2 : developers) {
		}
		
	}
	
	@Test
	public void testUni() {
		
		DeveloperUni dev = new DeveloperUni();
		ProjectUni project = new ProjectUni();
		
		dev.addProjectUni(project);
		em.persist(dev);
		
		em.flush();
		em.clear();
		
		DeveloperUni find = em.find(DeveloperUni.class, dev.getId());
		Collection<ProjectUni> projects = find.getProjects();
		for (ProjectUni projectUni : projects) {
			System.out.println("DeveloperTest.testUni() = " + projectUni);
		}
		
	}
	
}
