public class Catalogo {
	
	/** Arreglo de combinaciones en Maquina Helados***/
	private Combo [] comboArray;
	/** Numero de combos en Maquina Helados */
	private final int NUM_COMBOS = 4; 
	
	/**
	 * Constructor Default para un Catalogo.
	 */
	public Catalogo() {
		comboArray = new Combo[NUM_COMBOS];
	}
	
	/**
	 * Returna el arreglo de combinaciones
	 * @param c
	 * @return Combo[]
	 */
	public synchronized Combo[] getCombos() {
		return comboArray;
	}
	
	public synchronized boolean addCombo(Combo c) {
		//Asume que la combinacion no existe en el arreglo hasta
		//que descubre lo contrario
		boolean exists = false;
		//Revisa que la combinacion no exista previamente en el arreglo
		for (int i = 0; i < comboArray.length; i++ ) {
			if (c.equals(comboArray[i])) {
				exists = true;
			}
		}
		//Asume que la combinacion no puede ser agregada hasta encontrar un espacio
		//disponible
		boolean added = false;
		//Revisa si el primer espacio en el arreglo esta vacio
		if (!exists) {
			for (int i = 0; i < comboArray.length && !added; i++) {
				if (comboArray[i] == null) {
					comboArray[i] = c;
					added = true;
				}
			}
		}
		return added;
	}

	/**
	 * Returna el nombre de la combinacion borrada en la posicion
	 * especificada y null en caso de que la combinacion no exista.
	 * @param comboToDelete
	 * @return String
	 */
	public synchronized String deleteCombo(int comboToDelete) {
		if (comboArray[comboToDelete] != null) {
			String comboName = comboArray[comboToDelete].getName();
			comboArray[comboToDelete] = new Combo();
			return comboName;
		} else {
			return null;
		}
	}
	
	/**
	 * Returna el nombre de la combinacion editada en la posicion
	 * especificada y null si la combinacion no existe.
	 * @param comboToEdit
	 * @param newCombo
	 * @return String
	 */
	public synchronized String editCombo(int comboToEdit, Combo newCombo) {
		if (comboArray[comboToEdit] != null) {
			String comboName = comboArray[comboToEdit].getName();
			newCombo.setName("");
			comboArray[comboToEdit] = newCombo;
			return comboName;
		} else {
			return null;
		}
	}

}
