package qualiti.recodev.projetoalocacao.business;

import java.util.Objects;
import qualiti.recodev.projetoalocacao.model.Departament;
import qualiti.recodev.projetoalocacao.repository.RepositoryDepartament;

public class BusinessDepartament {

	private RepositoryDepartament repositoryDepartament;

	public BusinessDepartament(RepositoryDepartament repositoryDepartament) {
		this.repositoryDepartament = repositoryDepartament;
	}
	
	public void addDepartament(String departamentName) throws Exception {
		
		if(departamentName == null || departamentName.equals("")) {
			throw new Exception("The departament entered is not valid.");
		}
		
		Departament departament = repositoryDepartament.getDepartamentoByName(departamentName);
		if(!Objects.isNull(departament)) {
			throw new Exception("Departament has already been registered.");
		}
		repositoryDepartament.addDepartament(new Departament(departamentName));	
	}
	
	public void viewDepartaments() throws Exception {
		
		if(Objects.isNull(repositoryDepartament.findAll())) {
			throw new Exception("No departaments were registered.");
		}
		this.repositoryDepartament.viewCourses();
	}
}
