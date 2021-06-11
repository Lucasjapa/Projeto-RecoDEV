package qualiti.recodev.projetoalocacao.cli;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import qualiti.recodev.projetoalocacao.business.BusinessAllocation;
import qualiti.recodev.projetoalocacao.business.BusinessCourse;
import qualiti.recodev.projetoalocacao.business.BusinessDepartament;
import qualiti.recodev.projetoalocacao.business.BusinessProfessor;
import qualiti.recodev.projetoalocacao.repository.RepositoryAllocation;
import qualiti.recodev.projetoalocacao.repository.RepositoryCourse;
import qualiti.recodev.projetoalocacao.repository.RepositoryDepartament;
import qualiti.recodev.projetoalocacao.repository.RepositoryProfessor;

public class Program {
	
	private static RepositoryCourse repositoryCourse = new RepositoryCourse();
	private static RepositoryDepartament repositoryDepartament = new RepositoryDepartament();
	private static RepositoryProfessor repositoryProfessor = new RepositoryProfessor();
	private static RepositoryAllocation repositoryAllocation = new RepositoryAllocation();
	private static BusinessCourse businessCourse = new BusinessCourse(repositoryCourse);
	private static BusinessDepartament businessDepartament = new BusinessDepartament(repositoryDepartament);
	private static BusinessProfessor businessProfessor = new BusinessProfessor(repositoryDepartament, repositoryProfessor);
	private static BusinessAllocation businessAllocation = new BusinessAllocation(repositoryAllocation,repositoryProfessor, repositoryCourse);
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		
		Integer option;
		Boolean proceed = true;
		
		while(proceed) {
			option = menu();
			scan.nextLine();
			if(!Objects.isNull(option)) {
				proceed = setOption(option);
			}
		}
	}
	
	private static boolean setOption(Integer option){
		switch(option) {
		case 0:
			return false;
		case 1:
			setRegister(register());
			break;
		case 2:
			setList(list());
			break;
		case 3:
			setSearch(search());
			break;
		case 4:
			toAllocate();
			break;
		default:
			System.out.println("Invalid option.");
		}
		return true;
	}
	
	private static boolean setRegister(Integer option){
		switch(option) {
		case 0:
			return false;
		case 1:
			registerCourse();
			break;
		case 2:
			registerDepartament();
			break;			
		case 3:
			registerProfessor();
			break;
		default:
			System.out.println("Invalid option.");
		}
		return true;
	}
	
	private static boolean setList(Integer option){
		switch(option) {
		case 0:
			return false;
		case 1:
			listCourses();
			break;
		case 2:
			listDepartaments();
			break;			
		case 3:
			listProfessors();
			break;
		case 4:
			listAllocations();
			break;
		default:
			System.out.println("Invalid option.");
		}
		return true;
	}
	
	private static boolean setSearch(Integer option){
		switch(option) {
		case 0:
			return false;
		case 1:
			searchCourse();
			break;
		case 2:
			searchProfessor();
			break;			
		case 3:
			listProfessors();
			break;
		case 4:
			listAllocations();
			break;
		default:
			System.out.println("Invalid option.");
		}
		return true;
	}
	
	//------------------REGISTER------------------
	private static void registerCourse() {
		System.out.println();
		System.out.println("----REGISTER COURSE----");
		System.out.print("Name: ");
		String name = scan.nextLine();
		
		try {
			businessCourse.addCourse(name);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void registerDepartament() {
		System.out.println();
		System.out.println("----REGISTER DEPARTAMENT----");
		System.out.print("Name: ");
		String name = scan.nextLine();
		
		try {
			businessDepartament.addDepartament(name);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void registerProfessor(){
		try {
			System.out.println();
			System.out.println("----REGISTER PROFESSOR----");
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("CPF: ");
			Long cpf = scan.nextLong();
			scan.nextLine();
			System.out.print("Departament: ");
			String departament = scan.nextLine();
		
			businessProfessor.addProfessor(name, cpf, departament);
		
		}
		catch(InputMismatchException e){
			System.out.println("Invalid CPF, cannot contain letters or symbols");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//------------------------------------------------------
	
	//---------------------LIST----------------------
	public static void listCourses() {
		try {
		businessCourse.viewCourses();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void listDepartaments() {
		try {
		businessDepartament.viewDepartaments();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void listProfessors() {
		try {
		businessProfessor.viewProfessors();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void listAllocations() {
		try {
		businessAllocation.viewAllocations();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	//------------------------------------------------------
	
	//---------------------SEARCH----------------------
	public static void searchCourse(){
		System.out.println();
		System.out.println("-----SEARCH COURSE-----");
		System.out.print("Name: ");
		String name = scan.nextLine();
		
		try {
			businessCourse.searchCourse(name);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void searchProfessor(){
		System.out.println();
		System.out.println("-----SEARCH PROFESSOR-----");
		System.out.print("CPF: ");
		Long cpf = scan.nextLong();
		scan.nextLine();
		
		try {
			businessProfessor.searchProfessor(cpf);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//------------------------------------------------------
	private static void toAllocate(){
		try {
			System.out.println();
			System.out.println("----ALLOCATION----");
			System.out.print("Professor: ");
			String professor = scan.nextLine();
			System.out.print("Course: ");
			String course = scan.nextLine();
			System.out.println("----DAYS----");
			System.out.println("1-MONDAY");
			System.out.println("2-TUESDAY");
			System.out.println("3-WEDNESDAY");
			System.out.println("4-THURSDAY");
			System.out.println("5-FRIDAY");
			System.out.println("6-SATURDAY");
			System.out.println("7-SUNDAY");
			System.out.print("Day of week: ");
			DayOfWeek dayOfWeek = DayOfWeek.of(scan.nextInt());
			scan.nextLine();
			System.out.println("----HORARY----");
			System.out.print("Start time(hh:mm:ss): ");
			Time startTime = Time.valueOf(scan.nextLine());
			System.out.print("End time(hh:mm:ss): ");
			Time endTime = Time.valueOf(scan.nextLine());
			
			businessAllocation.addAllocation(professor, course, dayOfWeek, startTime, endTime);
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid time format.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	public static Integer menu() {
		Integer option;

		System.out.println();
		System.out.println("------MENU------");
		System.out.println("0 - EXIT.");
		System.out.println("1 - Register.");
		System.out.println("2 - List.");
		System.out.println("3 - Search.");
		System.out.println("4 - To Allocate.");
		try {
			System.out.print("Choose an operation:");
			option = scan.nextInt();
			return option;
		}
		catch(InputMismatchException e){
			System.out.println("Invalid option.");
			
		}	
		return null;
	}
	
	public static Integer register() {
		Integer option;

		System.out.println();
		System.out.println("-------------------------");
		System.out.println("0 - BACK TO MENU");
		System.out.println("1 - Register Course");
		System.out.println("2 - Register Departament");
		System.out.println("3 - Register Professor");
		System.out.println("-------------------------");

		System.out.print("Choose an operation:");
		option = scan.nextInt();
		scan.nextLine();
		return option;
	}
	
	public static Integer list() {
		Integer option;

		System.out.println();
		System.out.println("-------------------------");
		System.out.println("0 - BACK TO MENU");
		System.out.println("1 - List Course");
		System.out.println("2 - List Departament");
		System.out.println("3 - List Professor");
		System.out.println("4 - List Allocations");
		System.out.println("-------------------------");

		System.out.print("Choose an operation:");
		option = scan.nextInt();
		scan.nextLine();
		return option;
	}
	
	public static Integer search() {
		Integer option;

		System.out.println();
		System.out.println("-------------------------");
		System.out.println("0 - BACK TO MENU");
		System.out.println("1 - Search Course");
		System.out.println("2 - Search Professor");
		System.out.println("-------------------------");

		System.out.print("Choose an operation:");
		option = scan.nextInt();
		scan.nextLine();
		return option;
	}
}
