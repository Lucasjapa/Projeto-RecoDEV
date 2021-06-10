package qualiti.recodev.projetoalocacao.repository;

import java.util.ArrayList;
import qualiti.recodev.projetoalocacao.model.Course;

public class RepositoryCourse {
	
	private ArrayList<Course> courses;
	
	public RepositoryCourse() {
		this.courses = new ArrayList<Course>();
	}
		
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public Course getCourseByName(String name) {
		for(Course course: courses) {
			if(course.getName().equals(name)) {
				return course;
			}
		}
		return null;
	}
	
	public Course findAll() {
		for(Course course: courses) {
			if(!course.equals(null)) {
				return course;
			}
		}
		return null;
	}
	
	public void listCourse(String name) {
		System.out.println();
		System.out.println("-----COURSE-----");
		System.out.println("Name: " + name);
	}
	
	public void viewAllCourses() {
		System.out.println();
		System.out.println("-----COURSES-----");
		for(Course course: this.courses) {
			System.out.println("Name: " + course.getName());
		}
	}
}
