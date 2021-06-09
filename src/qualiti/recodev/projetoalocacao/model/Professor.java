package qualiti.recodev.projetoalocacao.model;

public class Professor {
	private String name;
	private String cpf;
	private Departament departament;
	
	public Professor(String name, String cpf, Departament departament){
		this.name = name;
		this.cpf = cpf;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
}


