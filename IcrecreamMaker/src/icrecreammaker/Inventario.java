public class Inventario {
    
    private static int yogurt;
    private static int fresas;
    private static int almendras;
    private static int chocolate;
    

    public Inventario() {
    	setYogurt(15);
    	setFresas(15);
    	setAlmendras(15);
    	setChocolate(15);
    }
    
     public int getChocolate() {
        return chocolate;
    }

    public synchronized void setChocolate(int chocolate) {
    	if(chocolate >= 0) {
    		this.chocolate = chocolate;
    	}
        
    }
    
    public synchronized void addChocolate(String chocolate) throws InventoryException {
    	int amtChocolate = 0;
    	try {
    		amtChocolate = Integer.parseInt(chocolate);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Unidades de Chocolate debe ser un numero entero positivo");
    	}
		if (amtChocolate >= 0) {
			this.chocolate += amtChocolate;
		} else {
			throw new InventoryException("Unidades de Chocolate debe ser un numero entero positivo");
		}
    }
    
    public int getYogurt() {
        return yogurt;
    }
    
    public synchronized void setYogurt(int yogurt) {
    	if(yogurt >= 0) {
    		this.yogurt = yogurt;
    	}
    }
    
    public synchronized void addYogurt(String yogurt) throws InventoryException {
    	int amtyogurt = 0;
    	try {
    		amtyogurt = Integer.parseInt(yogurt);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Unidades de Yogurt debe ser un numero entero positivo");
    	}
		if (amtyogurt >= 0) {
			this.yogurt += amtyogurt;
		} else {
			throw new InventoryException("Unidades de Yogurt debe ser un numero entero positivo");
		}
    }

    public int getFresas() {
        return fresas;
    }
    
    public synchronized void setFresas(int fresas) {
    	if(fresas >= 0) {
    		this.fresas = fresas;
    	}
    }
    
    public synchronized void addFresas(String fresas) throws InventoryException {
    	int amtfresas = 0;
    	try {
    		amtfresas = Integer.parseInt(fresas);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Unidades de Fresas debe ser un numero entero positivo");
    	}
		if (amtfresas >= 0) {
			this.fresas += amtfresas;
		} else {
			throw new InventoryException("Unidades de Fresas debe ser un numero entero positivo");
		}
    }
    
    public int getAlmendras() {
        return almendras;
    }
    
    public synchronized void setAlmendras(int almendras) {
    	if(almendras >= 0) {
    		this.almendras = almendras;
    	}
    }

    public synchronized void addAlmendras(String almendras) throws InventoryException {
    	int amtalmendras = 0;
    	try {
    		amtalmendras = Integer.parseInt(almendras);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Unidades de Almendras debe ser un numero entero positivo");
    	}
		if (amtalmendras >= 0) {
			this.almendras += amtalmendras;
		} else {
			throw new InventoryException("Unidades de Almendras debe ser un numero entero positivo");
		}
    }

    protected synchronized boolean enoughIngredients(Combo c) {
        boolean isEnough = true;
        if(this.yogurt < c.getvarYogurt()) {
            isEnough = false;
        }
        if(this.fresas < c.getvarFresas()) {
            isEnough = false;
        }
        if(this.almendras < c.getvarAlmendras()) {
            isEnough = false;
        }
        if(this.chocolate < c.getvarChocolate()) {
            isEnough = false;
        }
        return isEnough;
    }
    
    public synchronized boolean useIngredients(Combo c) {
    	if (enoughIngredients(c)) {
	    	this.yogurt -= c.getvarYogurt();
	    	this.fresas -= c.getvarFresas();
	    	this.almendras -= c.getvarAlmendras();
	    	this.chocolate -= c.getvarChocolate();
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    public String toString() {
    	StringBuffer buf = new StringBuffer();
    	buf.append("Yogurt: ");
    	buf.append(getYogurt());
    	buf.append("\n");
    	buf.append("Fresas: ");
    	buf.append(getFresas());
    	buf.append("\n");
    	buf.append("Almendras: ");
    	buf.append(getAlmendras());
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(getChocolate());
    	buf.append("\n");
    	return buf.toString();
    }
}
