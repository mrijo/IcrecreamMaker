import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static IcecreamMaker iceMaker;

    /**
     * Imprime el menu principal y maneja la entrada del usuario para
     * las opciones de menu.
     */
    public static void mainMenu() {
        System.out.println("1. Agregar una combinacion");
        System.out.println("2. Borrar una combinacion");
        System.out.println("3. Editar una combinacion");
        System.out.println("4. Agregar inventario");
        System.out.println("5. Revisar inventario");
        System.out.println("6. Preparar Helado");
        System.out.println("0. Salir\n");
        
        //Get user input
        try {
        	int userInput = Integer.parseInt(inputOutput("Favor presione el numero que corresponde a lo que desea realizar en la Maquina de Helados."));
        	
        	if (userInput >= 0 && userInput <=6) {
		        if (userInput == 1) addCombo();
		        if (userInput == 2) deleteCombo();
		        if (userInput == 3) editCombo();
		        if (userInput == 4) addInventario();
		        if (userInput == 5) checkInventario();
		        if (userInput == 6) makeIcecream();
		        if (userInput == 0) System.exit(0);
        	} else {
        		System.out.println("Favor entrar un numero en el rango 0 - 6");
            	mainMenu();
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Favor entrar un numero en el rango 0 - 6");
        	mainMenu();
        }
    }
    
	public static void addCombo() {
		
	    String name = inputOutput("\nFavor entrar el nombre del Combo: ");
	    String priceString = inputOutput("\nFavor entrar el precio del Combo: $");
	    String yogurtString = inputOutput("\nFavor entrar las Unidades de Yogurt en el Combo: ");
	    String fresaString = inputOutput("\nFavor entrar las Unidades de Fresas en el Combo: ");
	    String almendraString = inputOutput("\nFavor entrar las Unidades de Almendras en el Combo: ");
	    String chocolateString = inputOutput("\nFavor entrar las Unidades de Chocolate en el Combo: ");
	    	    
		Combo r = new Combo();
		try {
			r.setName(name);
			r.setPrice(priceString);
			r.setvarYogurt(yogurtString);
			r.setvarFresas(fresaString);
			r.setvarAlmendras(almendraString);
			r.setvarChocolate(chocolateString);
			
			boolean ComboAdded = iceMaker.addCombo(r);
		    
		    if(ComboAdded) {
		    	System.out.println(name + " agregado exitosamente.\n");
		    } else {
		    	System.out.println(name + " no pudo ser agregado.\n");
		    }
		} catch (ComboException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    public static void deleteCombo() {
        Combo [] Combos = iceMaker.getCombos();
        for(int i = 0; i < Combos.length; i++) {
        	if (Combos[i] != null) {
        		System.out.println((i+1) + ". " + Combos[i].getName());
        	}
        }
        int ComboToDelete = ComboListSelection("Favor seleccione el numero del combo a remover.");
        
	    if(ComboToDelete < 0) {
	    	mainMenu();
	    }
	    
        String ComboDeleted = iceMaker.deleteCombo(ComboToDelete);
        
        if (ComboDeleted != null) {
        	System.out.println(ComboDeleted + " borrado exitosamente.\n");
        } else {
	        System.out.println("El Combo seleccionado no existe y no pudo ser borrado.\n");
        }
        mainMenu();
    }
    
    public static void editCombo() {
        Combo [] Combos = iceMaker.getCombos();
        for(int i = 0; i < Combos.length; i++) {
        	if (Combos[i] != null) {
        		System.out.println((i+1) + ". " + Combos[i].getName());
        	}
        }
        int ComboToEdit = ComboListSelection("Favor seleccione el numero del combo a editar.");
        
	    if(ComboToEdit < 0) {
	    	mainMenu();
	    }
	    
	    
	    String priceString = inputOutput("\nFavor entrar el precio del Combo: $");
	    String yogurtString = inputOutput("\nFavor entrar las Unidades de Yogurt en el Combo: ");
	    String fresaString = inputOutput("\nFavor entrar las Unidades de Fresas en el Combo: ");
	    String almendraString = inputOutput("\nFavor entrar las Unidades de Almendras en el Combo: ");
	    String chocolateString = inputOutput("\nFavor entrar las Unidades de Chocolate en el Combo: ");
	    
	    Combo newCombo = new Combo();
	    try {
			newCombo.setPrice(priceString);
			newCombo.setvarYogurt(yogurtString);
			newCombo.setvarFresas(fresaString);
			newCombo.setvarAlmendras(almendraString);
			newCombo.setvarChocolate(chocolateString);
			
			String ComboEdited = iceMaker.editCombo(ComboToEdit, newCombo);
	        
	        if (ComboEdited != null) {
	        	System.out.println(ComboEdited + " editado exitosamente.\n");
	        }
		    else {
		    	System.out.println(ComboEdited + "no puede ser editado.\n");
		    }
		} catch (ComboException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    public static void addInventario() {
	    String yogurtString = inputOutput("\nFavor entrar las Unidades de Yogurt en el Combo: ");
	    String fresaString = inputOutput("\nFavor entrar las Unidades de Fresas en el Combo: ");
	    String almendraString = inputOutput("\nFavor entrar las Unidades de Almendras en el Combo: ");
	    String chocolateString = inputOutput("\nFavor entrar las Unidades de Chocolate en el Combo: ");
	    
	    	    
        try {
        	iceMaker.addInventario(yogurtString, fresaString, almendraString, chocolateString);
        	System.out.println("Inventario agregado exitosamente");
        } catch (InventoryException e) {
        	System.out.println("Inventario no pudo ser agregado");
        } finally {
        	mainMenu();
        }
    }
    
    public static void checkInventario() {
    	System.out.println(iceMaker.checkInventario());
    	mainMenu();
    }
    
    public static void makeIcecream() {
        Combo [] Combos = iceMaker.getCombos();
        for(int i = 0; i < Combos.length; i++) {
        	if (Combos[i] != null) {
        		System.out.println((i+1) + ". " + Combos[i].getName());
        	}
        }
        
        int ComboToPurchase = ComboListSelection("Favor seleccione el numero del combo a comprar: ");
        
        String amountPaid = inputOutput("Favor entrar el monto que desea pagar: ");
        int amtPaid = 0;
        try {
        	amtPaid = Integer.parseInt(amountPaid);
        } catch (NumberFormatException e) {
        	System.out.println("Favor entrar un numero entero positivo");
        	mainMenu();
        }
        
        int change = iceMaker.makeIcecream(ComboToPurchase, amtPaid);
        
        if (change == amtPaid) {
        	System.out.println("Fondos insuficientes para pagar.");
        } else {
        	System.out.println("Gracias por su compra: -> " + iceMaker.getCombos()[ComboToPurchase].getName());
        }
        System.out.println("Su cambio es: " + change + "\n");
        mainMenu();
    }
    
    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error en la lectura del valor");
	        mainMenu();
	    }
	    return returnString;
    }
    
    private static int ComboListSelection(String message) {
    	String userSelection = inputOutput(message);
    	int Combo = 0;
        try {
        	Combo = Integer.parseInt(userSelection) - 1;
        	if (Combo >= 0 && Combo <=2) {
        		//do nothing here.
        	} else {
        		Combo = -1;
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Favor seleccione un numero desde el 1-3.");
        	Combo = -1;
        }
        return Combo;
    }

    public static void main(String[] args) {
	    iceMaker = new IcecreamMaker();
	    System.out.println("Bienvenido a la Maquina de Helados!\n");
	    mainMenu();
	}
}
