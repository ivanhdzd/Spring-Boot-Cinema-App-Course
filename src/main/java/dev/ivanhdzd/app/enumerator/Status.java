package dev.ivanhdzd.app.enumerator;

public enum Status {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");

	String value;

	Status(String value) {
		this.value = value;
	}
}