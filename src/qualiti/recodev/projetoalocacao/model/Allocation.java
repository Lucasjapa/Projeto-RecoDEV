package qualiti.recodev.projetoalocacao.model;
import java.sql.Time;
import java.time.DayOfWeek;

public class Allocation {
	
	private Professor professor;
	private Course course;
	private DayOfWeek dayOfWeek;
	private Time startTime;
	private Time endTime;
	
	public Allocation(Professor professor, Course course, DayOfWeek dayOfWeek, Time startTime, Time endTime) {
		this.professor = professor;
		this.course = course;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
}
