package qualiti.recodev.projetoalocacao.business;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Objects;

import qualiti.recodev.projetoalocacao.model.Allocation;
import qualiti.recodev.projetoalocacao.model.Course;
import qualiti.recodev.projetoalocacao.model.Professor;
import qualiti.recodev.projetoalocacao.repository.RepositoryAllocation;
import qualiti.recodev.projetoalocacao.repository.RepositoryCourse;
import qualiti.recodev.projetoalocacao.repository.RepositoryProfessor;

public class BusinessAllocation {

	private RepositoryAllocation repositoryAllocation;
	private RepositoryProfessor repositoryProfessor;
	private RepositoryCourse repositoryCourse;
	
	public BusinessAllocation(RepositoryAllocation repositoryAllocation, RepositoryProfessor repositoryProfessor, RepositoryCourse repositoryCourse) {
		this.repositoryAllocation = repositoryAllocation;
		this.repositoryProfessor = repositoryProfessor;
		this.repositoryCourse = repositoryCourse;
	}
	
	public void addAllocation(String professorName, String courseName, DayOfWeek dayOfWeek, Time startTime, Time endTime) throws Exception {
		
		Professor professor = repositoryProfessor.getProfessorByName(professorName);
		if(Objects.isNull(professor)) {
			throw new Exception("Professor not found, register the professor.");
		}
		
		Course course = repositoryCourse.getCourseByName(courseName);
		if(Objects.isNull(course)) {
			throw new Exception("Course not found, register the course.");
		}
		
		if(repositoryAllocation.checkResgistration(courseName,dayOfWeek,startTime,endTime)) {
			throw new Exception("This registration has already been done.");
		}
		
		repositoryAllocation.addAllocation(new Allocation(professor,course,dayOfWeek,startTime,endTime));
	}
	
	public void viewAllocations() throws Exception {	
		
		if(Objects.isNull(repositoryAllocation.findAll())) {
			throw new Exception("No allocations were registered.");
		}
		repositoryAllocation.viewAllocations();
	}
}
