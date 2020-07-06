package p2Reflection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Utility {
	public static boolean copyFields(Object source, Object destination, boolean includePrivate) {
		if (source == null || destination == null) {
			return false;
		}

		Class<?> sourseClass = source.getClass();
		Class<?> destinationClass = destination.getClass();

		Field[] sourceFields;
		Field[] destinationFields;

		if (includePrivate) {
			sourceFields = sourseClass.getDeclaredFields();
			destinationFields = destinationClass.getDeclaredFields();
		} else {
			sourceFields = sourseClass.getFields();
			destinationFields = destinationClass.getFields();
		}

		if (sourceFields.length == 0 || destinationFields.length == 0) {
			return true;
		}

		for (Field field : destinationFields) {
			if (hasMatchingField(field, sourseClass, includePrivate)) {
				copy(field, destination, source, sourseClass, includePrivate);
			}
		}

		return true;
	}

	private static <T> T copy(Field field, T destinationObj, Object sourceObj, Class<?> sourseClass, boolean includePrivate) {
		Field sourceField;
		try {
			sourceField = includePrivate ? sourseClass.getDeclaredField(field.getName()) : sourseClass.getField(field.getName());
			sourceField.setAccessible(true);
			Object sourceFieldValue = sourceField.get(sourceObj);
			
			// adding deep copying
			if (field.getType().getSuperclass() != null 
					&& !field.getType().getSuperclass().equals(Object.class)) {

				sourceFieldValue = deepCopy(sourceFieldValue, includePrivate);
			}

			field.set(destinationObj, sourceFieldValue);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return destinationObj;
	}

	@SuppressWarnings({ "unchecked" })
	private static <T> T deepCopy(T object, boolean includePrivate) {
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
	private static boolean hasMatchingField(Field field, Class sourseClass, boolean includePrivate) {
		try {
			String fieldName = field.getName();
			
			Field sourseField = includePrivate ? sourseClass.getDeclaredField(fieldName) : sourseClass.getField(fieldName);
			sourseField.setAccessible(true);
			if (field.getType().equals(sourseField.getType())) {
				return true;
			}
		} catch (NoSuchFieldException e) {
			return false;
		}

		return false;
	}
}
