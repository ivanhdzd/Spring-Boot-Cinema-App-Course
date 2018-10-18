package dev.ivanhdzd.app;

public class Enumerator {
	public enum Status {
		ACTIVE("ACTIVE"),
		INACTIVE("INACTIVE");

		String value;

		Status(String value) {
			this.value = value;
		}
	}

	public enum Classification {
		A("A"),
		B("B"),
		C("C");

		String value;

		Classification(String value) {
			this.value = value;
		}
	}
}