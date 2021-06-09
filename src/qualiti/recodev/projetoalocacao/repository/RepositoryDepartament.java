package qualiti.recodev.projetoalocacao.repository;

import java.util.ArrayList;
import qualiti.recodev.projetoalocacao.model.Departament;

public class RepositoryDepartament {
	
	private ArrayList<Departament> departaments;
	
	public RepositoryDepartament() {
		departaments = new ArrayList<Departament>();
	}
	
	public void addDepartament(Departament departament) {
		departaments.add(departament);
	}
	
	public void viewDep() {
		for(Departament departament: departaments) {
			System.out.println(departament.getName());
		}
			
	}
	
	public Departament getDepartamentoByName(String name) {
		for(Departament departament: departaments) {
			if(departament.getName().equals(name)) {
				return departament;
			}
		}
		return null;
	}
	
	public Departament findAll() {
		for(Departament departament: departaments) {
			if(!departament.equals(null)) {
				return departament;
			}
		}
		return null;
	}
	
	public void viewCourses() {
		System.out.println();
		System.out.println("-----DEPARTAMENTS-----");
		for(Departament departament: departaments) {
			System.out.println("Name: " + departament.getName());
		}
	}
	
}
