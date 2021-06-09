package qualiti.recodev.projetoalocacao.model;

public class Coordenador extends Professor {
	
	private String cursoCoordenado;
	
	public Coordenador(String nome, String cpf, Departament departamento, String cursoCoordenado) {
		super(nome,cpf,departamento);
		this.cursoCoordenado = cursoCoordenado;
	}

	public String getCursoCordenado() {
		return cursoCoordenado;
	}

	public void setCursoCordenado(String cursoCoordenado) {
		this.cursoCoordenado = cursoCoordenado;
	}
	
	
}
