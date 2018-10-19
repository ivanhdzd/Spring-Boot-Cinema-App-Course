package dev.ivanhdzd.app.enumerator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {
	@Override
	public String convertToDatabaseColumn(Status attribute) {
		switch (attribute) {
			case ACTIVE:
				return "ACTIVE";
			case INACTIVE:
				return "INACTIVE";
			default:
				throw new IllegalArgumentException("Unknown " + attribute);
		}
	}

	@Override
	public Status convertToEntityAttribute(String dbData) {
		switch (dbData) {
			case "ACTIVE":
				return Status.ACTIVE;
			case "INACTIVE":
				return Status.INACTIVE;
			default:
				throw new IllegalArgumentException("Unknown " + dbData);
		}
	}
}