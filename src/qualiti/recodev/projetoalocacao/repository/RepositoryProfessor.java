package qualiti.recodev.projetoalocacao.repository;

import java.util.ArrayList;
import qualiti.recodev.projetoalocacao.model.Professor;

public class RepositoryProfessor {
	
	private ArrayList<Professor> professors;
	
	public RepositoryProfessor() {
		professors = new ArrayList<Professor>();
	}
	
	public void addProfessor(Professor professor) {
		professors.add(professor);
	}
	
	public Professor getProfessorByName(String name) {
		for(Professor professor: professors) {
			if(professor.getName().equals(name)) {
				return professor;
			}
		}
		return null;
	}
	
	public boolean checkResgistration(String cpfString, String departament) {
		for(Professor professor: professors) {
			if(professor.getCpf().equals(cpfString) && professor.getDepartament().getName().equals(departament)) {		
				return true;
			}
		}
		return false;
	}
	
	public Professor findAll() {
		for(Professor professor: professors) {
			if(!professor.equals(null)) {
				return professor;
			}
		}
		return null;
	}
	
	/*public boolean findAll() {
		for(Professor professor: professors) {
			if(professor.equals(null)) {
				return true;
			}
		}
		return false;
	}*/
	
	public void viewProfessors() {
		System.out.println();
		System.out.println("-----PROFESSORS-----");
		for(Professor professor: professors) {
			System.out.println("Name: "+ professor.getName() + 
					" Departament: " + professor.getDepartament().getName());
		}
	}
	
}
