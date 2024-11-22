package ma.emsi.entities;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;

	@ManyToOne
	@JoinColumn(name = "category_id") // Specifies the foreign key column
	private Category category;

	// Default constructor
	public Product() {}

	// Constructor with fields
	public Product(int id, String name, double price, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	// Getters and Setters
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
