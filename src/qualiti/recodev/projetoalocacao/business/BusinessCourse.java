package qualiti.recodev.projetoalocacao.business;

import java.util.Objects;
import qualiti.recodev.projetoalocacao.model.Course;
import qualiti.recodev.projetoalocacao.repository.RepositoryCourse;

public class BusinessCourse {
	private RepositoryCourse repositoryCourse;
	
	public BusinessCourse(RepositoryCourse repositoryCourse) {
		this.repositoryCourse = repositoryCourse;
	}
	
	public void addCourse(String courseName) throws Exception {
		
		if(courseName == null || courseName.equals("")) {
			throw new Exception("The course entered is not valid.");
		}
		
		Course course = repositoryCourse.getCourseByName(courseName);
		if(!Objects.isNull(course)) {
			throw new Exception("Course has already been registered.");
		}
		repositoryCourse.addCourse(new Course(courseName));
	}
	
	public void viewCourses() throws Exception {	
		
		if(Objects.isNull(repositoryCourse.findAll())) {
			throw new Exception("No courses were registered.");
		}
		repositoryCourse.viewCourses();
	}

}
