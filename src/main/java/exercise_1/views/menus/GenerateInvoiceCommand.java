package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import com.liche.utils.io.Range;
import exercise_1.controllers.StoreController;
import exercise_1.models.Decor;
import exercise_1.models.Flower;
import exercise_1.models.Invoice;
import exercise_1.models.Tree;
import exercise_1.views.Message;

public class GenerateInvoiceCommand extends Command {

	private StoreController storeController;

	public GenerateInvoiceCommand(StoreController storeController) {
		super(Message.GENERATE_INVOICE_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {

		Invoice invoice = new Invoice("INV" + storeController.getNextInvoiceNumber());
		
		System.out.println(Message.LOAD_ITEMS);
		System.out.println(Message.HORIZONTAL_LINE);
		
		boolean exit = false;
		do {
			String itemType = requestCategory();
			String itemName = Input.readString("Introdueix el nom: ");
			int quantity = 0;

			switch (itemType) {

			case "Decor":
				Decor decor = new Decor(itemName);
				
				if (storeController.ifExistItem(decor) && storeController.getItemQuantity(decor) > 0) {
					quantity = Input.readInt("Introdueix la quantitat: (Estoc-" + storeController.getItemQuantity(decor) + ")", new Range (1, storeController.getItemQuantity(decor)));
					decor = storeController.pickUpItem(decor, quantity);
					
					invoice.addItemToMap(decor, quantity);
				} else if (storeController.ifExistItem(decor)) {
					System.out.println("No hi ha estoc del producte");
				} else {
					System.out.println("Producte no trobat");
				}
				break;

			case "Flower":
				Flower flower = new Flower(itemName);
				
				if (storeController.ifExistItem(new Flower(itemName)) && storeController.getItemQuantity(flower) > 0) {
					quantity = Input.readInt("Introdueix la quantitat: (Estoc-" + storeController.getItemQuantity(flower) + ")", new Range (1, storeController.getItemQuantity(flower)));
					flower = storeController.pickUpItem(flower, quantity);
					invoice.addItemToMap(flower, quantity);
					
				} else if (storeController.ifExistItem(flower)) {
					System.out.println("No hi ha estoc del producte");
				} else {
					System.out.println("Producte no trobat");
				}
				break;

			case "Tree":
				Tree tree = new Tree(itemName);
				
				if (storeController.ifExistItem(tree) && storeController.getItemQuantity(tree) > 0) {
					quantity = Input.readInt("Introdueix la quantitat: (Estoc-" + storeController.getItemQuantity(tree) + ")", new Range (1, storeController.getItemQuantity(tree)));	
					tree = storeController.pickUpItem(tree, quantity);
					invoice.addItemToMap(tree, quantity);
				} else if (storeController.ifExistItem(tree)) {
					System.out.println("No hi ha estoc del producte");
				}	else {
					System.out.println("Producte no trobat");
				}
				break;

			default:
				break;
			}
			
			exit = !Input.readYesNo("Voleu introduir més productes? (s= si, n= no)");
		} while (!exit);
		
		storeController.registerInvoice(invoice);
		System.out.println("Factura creada");
		Input.readString("Prem intro");
	}

	private String requestCategory() {
		String type = "";
		String userInput;

		do {
			userInput = Input.readString("Introdueix la categoria del producte: (d= Decoració, f= Flor, a= Arbre)");

			switch (userInput.toLowerCase()) {

			case "d":
				type = "Decor";
				break;

			case "f":
				type = "Flower";
				break;

			case "a":
				type = "Tree";
				break;

			default:
				break;
			}

		} while (!userInput.toLowerCase().equals("d") && !userInput.toLowerCase().equals("f")
				&& !userInput.toLowerCase().equals("a"));

		return type;
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
