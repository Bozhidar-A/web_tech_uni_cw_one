package web_tech_uni_cw_one;

public class Vehicle {
	private int ID;
	private String make;
	private String model;
	private int maxPassangers;
	private int manufactureYear;
	private int gasUsage;
	private String color;
	private String gearboxType;
	public enum gearboxTypeAvailable {
		manual,
		automatic
	}

	public Vehicle() {

	}


	public Vehicle(String make, String model, int maxp, int manfY, int gasu, String color, String gearboxType) {
		this.make = make;
		this.model = model;
		this.maxPassangers = maxp;
		this.manufactureYear = manfY;
		this.gasUsage = gasu;
		this.color = color;
		this.gearboxType = gearboxType;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxPassangers() {
		return maxPassangers;
	}

	public void setMaxPassangers(int maxPassangers) {
		this.maxPassangers = maxPassangers;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public int getGasUsage() {
		return gasUsage;
	}

	public void setGasUsage(int gasUsage) {
		this.gasUsage = gasUsage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getGearboxType() {
		return gearboxType;
	}

	public void setGearboxType(String gearboxType) {
		this.gearboxType = gearboxType;
	}

}
