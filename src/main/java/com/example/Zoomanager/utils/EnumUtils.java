package com.example.Zoomanager.utils;

public class EnumUtils {
    public static <E extends Enum<E>> E getEnumValueFromString(Class<E> classEnum, String strValue) {
        for (E enumValue : classEnum.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(strValue)) {
                return enumValue;
            }
        }
        return null;
    }
}