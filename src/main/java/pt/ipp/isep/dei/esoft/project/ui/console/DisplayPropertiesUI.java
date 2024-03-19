package pt.ipp.isep.dei.esoft.project.ui.console;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.controllers.TransactionController;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class DisplayPropertiesUI implements Runnable {
    private final Scanner sc;
    private final PropertyRepository propertyRepository;
    MessageUI messageUI = new MessageUI();
    MainUI mainUI = new MainUI();

    public DisplayPropertiesUI() {
        this.sc = new Scanner(System.in);
        this.propertyRepository = Repositories.getInstance().getPropertyRepository();
    }

    @Override
    public void run() {
        boolean exit = false;

        do {
            System.out.println("### Display Properties ###\n");
            System.out.println("1 - Display all properties");
            System.out.println("2 - Filter properties");
            System.out.println("3 - Make a visit request");
			System.out.println("4 - Place order to purchase property");
            System.out.println("0 - Exit");

            System.out.print("> ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    displayAllProperties();
                    break;
                case 2:
                    displayFilteredProperties();
                    break;
                case 3:
                    messageUI.run();
                    break;
				case 4:
					placePurchaseOrder();
					break;
                case 0:
                    mainUI.run();
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!exit);
    }

    private void displayAllProperties() {
        List<Property> properties = propertyRepository.getAllProperties();

        if (properties.isEmpty()) {
            System.out.println("There are no properties registered.");
            return;
        }

        System.out.println("### All Properties ###\n");
        for (Property property : properties) {
            Property.BusinessType businessType = property.getBusinessType();

            String action;
            switch(businessType) {
                case BUY:
                    action = "sold";
                    break;
                case RENT:
                    action = "rented";
                    break;
                default:
                    action = "available";
                    break;
            }

            System.out.println(property.toString());
        }
    }

    private void displayFilteredProperties() {
        System.out.println("### Filter Properties ###\n");
        System.out.println("1 - Type of Business");
        System.out.println("2 - Type of Property");
        System.out.println("3 - Number of Rooms");
        System.out.println("4 - Price (ascending)");
        System.out.println("5 - Price (descending)");
        System.out.println("6 - City");
        System.out.println("7 - State");

        System.out.print("> ");
        int option = sc.nextInt();
        sc.nextLine();

        List<Object> filteredProperties = null;

        switch (option) {
            case 1:
                System.out.println("Select a type of business:");
                System.out.println("1 - Rent");
                System.out.println("2 - Buy");

                int businessOption = sc.nextInt();
                sc.nextLine();

                switch (businessOption) {
                    case 1:
                        filteredProperties = propertyRepository.getPropertiesToRent();
                        break;
                    case 2:
                        filteredProperties = propertyRepository.getPropertiesToBuy();
                        break;
                    default:
                        System.out.println("Invalid option");
                        return;
                }
                break;

            case 2:
                System.out.println("Select a type of property:");
                System.out.println("1 - House");
                System.out.println("2 - Apartment");
                System.out.println("3 - Lands");

                int propertyOption = sc.nextInt();
                sc.nextLine();

                switch (propertyOption) {
                    case 1:
                        filteredProperties = propertyRepository.getHouses();
                        break;
                    case 2:
                        filteredProperties = propertyRepository.getApartments();
                        break;
                    case 3:
                        filteredProperties = propertyRepository.getLands();
                        break;
                    default:
                        System.out.println("Invalid option");
                        return;
                }
                break;

            case 3:
                System.out.print("Enter the minimum number of bedrooms:");

                int minBedrooms = sc.nextInt();
                sc.nextLine();

                filteredProperties = propertyRepository.getPropertiesByBedrooms(minBedrooms);
                break;

            case 4:
                filteredProperties = propertyRepository.getPropertiesByPriceAsc();
                break;

            case 5:
                filteredProperties = propertyRepository.getPropertiesByPriceDesc();
                break;
            case 6:
                System.out.println("Enter the city:");

                String city = sc.nextLine();

                filteredProperties = propertyRepository.getPropertiesByCity(city);
                break;

            case 7:
                System.out.println("Enter the state:");

                String state = sc.nextLine();

                filteredProperties = propertyRepository.getPropertiesByState(state);
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid option.");
                return;
        }

        if (filteredProperties.isEmpty()) {
            System.out.println("There are no properties that match the selected filter.");
            return;
        }

        System.out.println("### Filtered Properties ###\n");
        for (Object property : filteredProperties) {
            System.out.println(property);
        }
    }

	private void placePurchaseOrder() {
		List<Property> properties = propertyRepository.getAllProperties();
		TransactionController controller = new TransactionController();
		ApplicationSession session = Repositories.getInstance().getSession();

		Person user = (Person) session.getCurrentUser();

		if (properties.isEmpty()) {
			System.out.println("There are no properties registered.");
			return;
		}

		System.out.println("### All Properties ###\n");
		for (int i = 1; i <= properties.size(); i++) {
			Property property = properties.get(i - 1);

			System.out.printf("%d - %s (%s) | $%.2f\n", i, property.getName(), property.getAddress(), property.getPrice());
		}

		int index;

		do {
			System.out.println("Select one property");
			System.out.print("> ");
			index = sc.nextInt();

			if(index <= 0 || index > properties.size()) System.out.println("Invalid option.");
		} while(index <= 0 || index > properties.size());

		Property property = properties.get(index - 1);

		float price;
		boolean flag;

		do {
			flag = true;

			System.out.printf("Current property price: %.2f \n", property.getPrice());
			System.out.println("Please introduce a price: ");

			price = sc.nextFloat();

			if(price > property.getPrice()) {
				flag = false;
				System.out.println("The price must be equal or lower than the current property price.");
			}
		} while(!flag);

		if(controller.hasTransactionWithAmount(property, price)) {
			System.out.println("There's already one or more orders with the price you introduced. Those offer will be considered first.");
		}

		try {
			controller.create(property.getOwner(), user, price, property);

			System.out.println("You've placed your order successfully");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
