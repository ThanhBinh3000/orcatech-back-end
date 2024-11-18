package vn.com.gsoft.security.util.system;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {

    public static <T> Page<T> convertPage(Page<Tuple> tuples, Class<T> clazz) {
        return tuples.map(tuple -> populateFields(tuple, clazz));
    }

    public static <T> List<T> convertList(List<Tuple> tuples, Class<T> clazz) {
        return tuples.stream()
                .map(tuple -> populateFields(tuple, clazz))
                .collect(Collectors.toList());
    }

    public static <T> T convertOne(Tuple tuple, Class<T> clazz) {
        if (tuple == null) {
            return null;
        }
        return populateFields(tuple, clazz);
    }

    private static <T> T populateFields(Tuple tuple, Class<T> clazz) {
        try {
            T e = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = tuple.get(field.getName());
                if (value != null) {
                    value = convertValueIfNeeded(value, field.getType());
                    field.set(e, value);
                }
            }
            return e;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException ex) {
            throw new RuntimeException("Error while converting tuple to entity: " + ex.getMessage(), ex);
        }
    }

    private static Object convertValueIfNeeded(Object value, Class<?> targetType) {
        if (value == null) {
            return null;
        }
        if (targetType.isInstance(value)) {
            return value;
        }
        if (value instanceof Integer && targetType.equals(Long.class)) {
            return ((Integer) value).longValue();
        }
        if (value instanceof Float && targetType.equals(Double.class)) {
            return ((Float) value).doubleValue();
        }
        if (value instanceof Number) {
            if (targetType.equals(Integer.class) || targetType.equals(int.class)) {
                return ((Number) value).intValue();
            } else if (targetType.equals(Long.class) || targetType.equals(long.class)) {
                return ((Number) value).longValue();
            } else if (targetType.equals(Double.class) || targetType.equals(double.class)) {
                return ((Number) value).doubleValue();
            } else if (targetType.equals(Float.class) || targetType.equals(float.class)) {
                return ((Number) value).floatValue();
            }
        }
        return value;
    }
}