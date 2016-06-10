public class IcecreamMaker {
	/** Arreglo de combinaciones en la maquina de helados*/
	private static Catalogo catalogo;
	/** Inventario de la maquina de helados */
    private static Inventario inventario;
	
    /**
     * Constructor 
     *
     */
	public IcecreamMaker() {
	    catalogo = new Catalogo();
		inventario = new Inventario();
	}
	
	public boolean addCombo(Combo c) {
		return catalogo.addCombo(c);
	}
	
	public String deleteCombo(int comboToDelete) {
		return catalogo.deleteCombo(comboToDelete);
	}
	
	public String editCombo(int comboToEdit, Combo c) {
		return catalogo.editCombo(comboToEdit, c);
	}
    
    /**
     * Returna true si el inventario fue agregado exitosamente
     * @param varYogurt
     * @param varFresas
     * @param varAlmendras
     * @param varChocolate
     * @return boolean
     */
    public synchronized void addInventario(String varYogurt, String varFresas, String varAlmendras, String varChocolate) throws InventoryException {
	    inventario.addYogurt(varYogurt);
	    inventario.addFresas(varFresas);
	    inventario.addAlmendras(varAlmendras);
	    inventario.addChocolate(varChocolate);
    }
    
    public synchronized String checkInventario() {
        return inventario.toString();
    }
    
    public synchronized int makeIcecream(int comboToPurchase, int amtPaid) {
        int change = 0;
        
        if (getCombos()[comboToPurchase] == null) {
        	change = amtPaid;
        } else if (getCombos()[comboToPurchase].getPrice() <= amtPaid) {
        	if (inventario.useIngredients(getCombos()[comboToPurchase])) {
        		change = amtPaid - getCombos()[comboToPurchase].getPrice();
        	} else {
        		change = amtPaid;
        	}
        } else {
        	change = amtPaid;
        }
        
        return change;
    }


	public synchronized Combo[] getCombos() {
		return catalogo.getCombos();
	}
}
