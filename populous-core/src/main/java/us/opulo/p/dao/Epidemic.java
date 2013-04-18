package us.opulo.p.dao;


public class Epidemic {
	private String name;
	private String strain;
	private String mutation;
	private String vector;

	public Epidemic(String name, String strain, String mutation, String vector) {
		this.name = name;
		this.strain = strain;
		this.mutation = mutation;
		this.vector = vector;
	}
	
	public String getName() {
		return name;
	}

	public String getMutation() {
		return mutation;
	}

	public String getStrain() {
		return strain;
	}

	public String getVector() {
		return vector;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
