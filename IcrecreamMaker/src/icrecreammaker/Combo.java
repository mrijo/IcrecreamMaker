public class Combo {
    private String name;
    private int price;
    private int varYogurt;
    private int varFresas;
    private int varAlmendras;
    private int varChocolate;
    
    /**
     * Crea una combinacion por defecto para la maquina de helados.
     */
    public Combo() {
    	this.name = "";
    	this.price = 0;
    	this.varYogurt = 0;
    	this.varFresas = 0;
    	this.varAlmendras = 0;
    	this.varChocolate = 0;
    }
    
    /**
	 * @return   Retorna la variable varChocolate.
	 */
    public int getvarChocolate() {
		return varChocolate;
	}
    /**
	 * @param varChocolate   The varChocolate to set.
	 */
    public void setvarChocolate(String chocolate) throws ComboException {
    	int varChocolate = 0;
    	try {
    		varChocolate = Integer.parseInt(chocolate);
    	} catch (NumberFormatException e) {
    		throw new ComboException("Unidades de Chocolate debe ser un numero positivo");
    	}
		if (varChocolate >= 0) {
			this.varChocolate = varChocolate;
		} else {
			throw new ComboException("Unidades de Chocolate debe ser un numero entero positivo");
		}
	}
    /**
	 * @return   Retorna la variable varYogurt.
	 */
    public int getvarYogurt() {
		return varYogurt;
	}
    /**
	 * @param varYogurt   The varYogurt to set.
	 */
    public void setvarYogurt(String yogurt) throws ComboException {
    	int varYogurt = 0;
    	try {
    		varYogurt = Integer.parseInt(yogurt);
    	} catch (NumberFormatException e) {
    		throw new ComboException("Unidades de Yogurt debe ser un numero entero positivo");
    	}
		if (varYogurt >= 0) {
			this.varYogurt = varYogurt;
		} else {
			throw new ComboException("Unidades de Yogurt debe ser un numero entero positivo");
		}
	}
    /**
	 * @return   Retorna la variable varFresas.
	 */
    public int getvarFresas() {
		return varFresas;
	}
    /**
	 * @param varFresas   The varFresas to set.
	 */
    public void setvarFresas(String fresa) throws ComboException{
    	int varFresas = 0;
    	try {
    		varFresas = Integer.parseInt(fresa);
    	} catch (NumberFormatException e) {
    		throw new ComboException("Unidades de Fresas debe ser un numero entero positivo");
    	}
		if (varFresas >= 0) {
			this.varFresas = varFresas;
		} else {
			throw new ComboException("Unidades de Fresas debe ser un numero entero positivo");
		}
	}
    /**
	 * @return   Retorna la variable varAlmendras.
	 */
    public int getvarAlmendras() {
		return varAlmendras;
	}
    /**
	 * @param varAlmendras   The varAlmendras to set.
	 */
    public void setvarAlmendras(String almendras) throws ComboException {
    	int varAlmendras = 0;
    	try {
    		varAlmendras = Integer.parseInt(almendras);
    	} catch (NumberFormatException e) {
    		throw new ComboException("Unidades de Almendras debe ser un numero entero positivo");
    	}
		if (varAlmendras >= 0) {
			this.varAlmendras = varAlmendras;
		} else {
			throw new ComboException("Unidades de Almendras debe ser un numero entero positivo");
		}
	}
    /**
	 * @return   Retorna el nombre.
	 */
    public String getName() {
		return name;
	}
    /**
	 * @param name   The name to set.
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
	 * @return   Returns the price.
	 */
    public int getPrice() {
		return price;
	}
    /**
	 * @param price   The price to set.
	 */
    public void setPrice(String price) throws ComboException{
    	int amtPrice = 0;
    	try {
    		amtPrice = Integer.parseInt(price);
    	} catch (NumberFormatException e) {
    		throw new ComboException("Precio debe ser un numero entero positivo");
    	}
		if (amtPrice >= 0) {
			this.price = amtPrice;
		} else {
			throw new ComboException("Precio debe ser un numero entero positivo");
		}
	} 
    
    /**
     * Retorna el nombre de la combinacion.
     * @return String
     */
    public String toString() {
    	return name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Combo other = (Combo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
