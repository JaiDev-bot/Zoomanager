package com.example.Zoomanager.utils;

public class EnumUtils {
    public static <E extends Enum<E>> E getEnumFromString(Class<E> classEnum, String strValue) {
        for (E enumValue : classEnum.getEnumConstants()) {
            if (enumValue.name().equals(strValue)) {
                return enumValue;
            }
        }
        return null;
    }
}