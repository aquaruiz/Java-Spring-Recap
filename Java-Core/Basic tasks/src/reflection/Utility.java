package reflection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
				if (isPrivate(field)) {
					field.setAccessible(true);
				}
			}

			for (Field field : sourceFields) {
				if (isPrivate(field)) {
					field.setAccessible(true);
				}
			}
		} else {
			sourceFields = sourseClass.getFields();
			destinationFields = destinationClass.getFields();
		}

		if (sourceFields.length == 0 || destinationFields.length == 0) {
			return true;
		}

		for (Field field : destinationFields) {
			if (hasMatchingField(field, sourseClass)) {
				destination = copy(field, destination, source, sourseClass);
			}
		}

		return true;
	}

	@SuppressWarnings("rawtypes")
	private static <T> T copy(Field field, T destinationObj, Object sourceObj, Class sourseClass) {
		Field sourceField;
		try {
			sourceField = sourseClass.getField(field.getName());
			Object sourceFieldValue = sourceField.get(sourceObj);
			
			// add deep copying
			if (field.getType().getSuperclass() != null 
					&& !field.getType().getSuperclass().equals(Object.class)) {

				sourceFieldValue = deepCopy(sourceFieldValue);
			}

			field.set(destinationObj, sourceFieldValue);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return destinationObj;
	}

	@SuppressWarnings({ "unchecked" })
	private static <T> T deepCopy(T object) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(bais);
			return (T) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static boolean isPrivate(Field field) {
		int fieldModifiers = field.getModifiers();
		return Modifier.isPrivate(fieldModifiers);
	}

	@SuppressWarnings("rawtypes")
	private static boolean hasMatchingField(Field field, Class sourseClass) {
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
