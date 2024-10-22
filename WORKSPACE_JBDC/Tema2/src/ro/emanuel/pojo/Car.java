package ro.emanuel.pojo;

public class Car {
	
	private int id;
	private String name;
	private String model;
	private int mileage;
	
	public Car(int id, String name, String model, int mileage) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.mileage = mileage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
}
