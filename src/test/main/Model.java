package test.main;

import java.io.Serializable;

public class Model implements Serializable,Cloneable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2380070325739748044L;

	public String model;
	
	public String[] models = new String[1];
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String[] getModels() {
		return models;
	}

	public void setModels(String[] models) {
		this.models = models;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
