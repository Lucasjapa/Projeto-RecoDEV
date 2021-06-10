package qualiti.recodev.projetoalocacao.business;

import java.util.Objects;

import qualiti.recodev.projetoalocacao.model.Departament;
import qualiti.recodev.projetoalocacao.model.Professor;
import qualiti.recodev.projetoalocacao.repository.RepositoryDepartament;
import qualiti.recodev.projetoalocacao.repository.RepositoryProfessor;

public class BusinessProfessor {
	
	private RepositoryDepartament repositoryDepartament;
	private RepositoryProfessor repositoryProfessor;
	
	public BusinessProfessor(RepositoryDepartament repositoryDepartament, RepositoryProfessor repositoryProfessor) {
		this.repositoryDepartament = repositoryDepartament;
		this.repositoryProfessor = repositoryProfessor;
	}
	
	public void addProfessor(String name, Long cpf, String departamentName) throws Exception {
		
		String cpfString = String.valueOf(cpf);
		cpfString = correctCPFformat(cpfString);
		
		if(name == null || name.equals("")) {
			throw new Exception("The course entered is not valid.");
		}
		if(cpfString.length() > 11) {
			throw new Exception("Invalid CPF, value entered greater than allowed");
		}
		Departament departament = repositoryDepartament.getDepartamentoByName(departamentName);
		if(Objects.isNull(departament)) {
			throw new Exception("Department not found, register the department.");
		}
		if(repositoryProfessor.checkResgistration(cpfString, departamentName)) {
			throw new Exception("This registration has already been done.");
		}
		
		repositoryProfessor.addProfessor(new Professor(name,cpfString,departament));	
	}
	
	public void searchProfessor(Long cpf) throws Exception {
		
		String cpfString = String.valueOf(cpf);
		cpfString = correctCPFformat(cpfString);
		Professor professor = repositoryProfessor.getProfessorByCPF(cpfString);
		
		if(Objects.isNull(professor)) {
			throw new Exception("No professor with this cpf was found.");
		}
		repositoryProfessor.listProfessor(professor);
	}
	
	public void viewProfessors() throws Exception {	
		
		if(Objects.isNull(repositoryProfessor.findAll())) {
			throw new Exception("No professor were registered.");
		}
		this.repositoryProfessor.viewAllProfessors();
	}
	
	private String correctCPFformat(String cpf) {
		while(cpf.length() < 11) {
			cpf = "0" + cpf;
		}
		return cpf;
	}
}
