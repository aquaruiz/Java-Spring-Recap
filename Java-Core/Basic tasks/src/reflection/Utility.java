package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Utility {
	@SuppressWarnings("rawtypes")
	public static boolean copyFields(Object source, Object destination, boolean includePrivate) {
		if (source == null || destination == null) {
			return false;
		}
		
		Class sourseClass = source.getClass();
		Class destinationClass = destination.getClass();
		
		Field[] sourceFields;
		Field[] destinationFields;
		
		if (includePrivate) {
			sourceFields = sourseClass.getDeclaredFields();
			destinationFields = destinationClass.getDeclaredFields();
			
			// find private fields, allow access
			for (Field field : destinationFields) {
				if(isPrivate(field)) {
					field.setAccessible(true);
				}
			}
			
			for (Field field : sourceFields) {
				if(isPrivate(field)) {
					field.setAccessible(true);
				}
			}
		}
		
		sourceFields = sourseClass.getFields();
		destinationFields = destinationClass.getFields();
		
		for (Field field : destinationFields) {
			if (hasMatchingFiled(field, sourseClass)) {
				try {
					field.set(destination, sourseClass.getField(field.getName()));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
						| SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}

	private static boolean isPrivate(Field field) {
		int fieldModifiers = field.getModifiers();
		return Modifier.isPrivate(fieldModifiers);
	}

	@SuppressWarnings("rawtypes")
	private static boolean hasMatchingFiled(Field field, Class sourseClass) {
		try {
			String fieldName = field.getName();
			Field sourseField = sourseClass.getField(fieldName);
			if (field.getType().equals(sourseField.getType())) {
				return true;
			}
		} catch (NoSuchFieldException e) {
			return false;
		}
		
		return false;
	}
}
