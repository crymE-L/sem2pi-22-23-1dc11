package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Scanner;

public class AdminsEmployeeUI implements Runnable {
	Scanner sc = new Scanner(System.in);
	EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

	AdminsUI adminsUI = new AdminsUI();
	RegisterEmployeeUI registerEmployeeUI = new RegisterEmployeeUI();

	@Override
	public void run() {
		System.out.println("### Employees menu ###\n");
		System.out.println("1 - Search employee");
		System.out.println("2 - Create employee");
		System.out.println("3 - Edit employee");
		System.out.println("4 - Delete employee");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				for (Employee employee: employeeRepository.getAllEmployee()) {
					System.out.println(employee);
				}
				break;
			case 2:
				registerEmployeeUI.run();
				break;
			case 0:
				adminsUI.run();
				break;
		}
	}
}
