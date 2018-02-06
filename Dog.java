package main;

public class Dog
{
	private int age;
	private String name;
	private String breed;
	
	
	private double height;
	private double weight;
	
	private boolean hasBone;
	private boolean tailWagging;

	
	
	
	public Dog(int age, String name, double height, double weight) {
		super();
		this.age = age;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isHasBone() {
		return hasBone;
	}

	public void setHasBone(boolean hasBone) {
		this.hasBone = hasBone;
		this.tailWagging = hasBone;
	}
	
	public boolean isTailWagging() {
		return tailWagging;
	}


	
	/**
	 * Returns the dog's age in years
	 * @return age * 7
	 */
	public int getDogYears()
	{
		return this.age * 5;
	}
	
	/**
	 * Speaks. What a good dog.
	 * @return
	 */
	public String speak()
	{
		return "WOOF WOOF";
	}
	
}
