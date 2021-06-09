package qualiti.recodev.projetoalocacao.repository;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;
import qualiti.recodev.projetoalocacao.model.Allocation;

public class RepositoryAllocation {
	
	private ArrayList<Allocation> allocations;

	public static SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
	
	public RepositoryAllocation() {
		allocations = new ArrayList<Allocation>();
	}
	
	public void addAllocation(Allocation allocation) {
		allocations.add(allocation);
	}
	
	public boolean checkResgistration(String course, DayOfWeek dayOfWeek, Time startTime, Time endTime) {
		for(Allocation allocation: allocations) {
			if( allocation.getCourse().equals(course) &&
					allocation.getDayOfWeek().equals(dayOfWeek) &&
					allocation.getStartTime().equals(startTime) &&
					allocation.getEndTime().equals(endTime)) {		
				return true;
			}
		}
		return false;
	}
	
	public Allocation findAll() {
		for(Allocation allocation: allocations) {
			if(!allocation.equals(null)) {
				return allocation;
			}
		}
		return null;
	}
	
	public void viewAllocations() {
		System.out.println();
		System.out.println("-----ALLOCATIONS-----");
		for(Allocation allocation: allocations) {
			System.out.println("Professor: "+ allocation.getProfessor().getName() + 
					" | Course: " + allocation.getCourse().getName() +
					" | Day of week: " + allocation.getDayOfWeek().name() +
					" | Horary: " + sdf.format(allocation.getStartTime()) + 
					" - " + sdf.format(allocation.getEndTime()));
		}
	}
}
