package dev.ivanhdzd.app.enumerator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ClassificationConverter implements AttributeConverter<Classification, String> {
	@Override
	public String convertToDatabaseColumn(Classification attribute) {
		switch (attribute) {
			case A:
				return "A";
			case B:
				return "B";
			case C:
				return "C";
			default:
				throw new IllegalArgumentException("Unknown " + attribute);
		}
	}

	@Override
	public Classification convertToEntityAttribute(String dbData) {
		switch (dbData) {
			case "A":
				return Classification.A;
			case "B":
				return Classification.B;
			case "C":
				return Classification.C;
			default:
				throw new IllegalArgumentException("Unknown " + dbData);
		}
	}
}