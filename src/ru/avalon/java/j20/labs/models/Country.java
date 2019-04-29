package ru.avalon.java.j20.labs.models;

import java.text.ParseException;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
    
    @Override
    public int hashCode() {
        return code.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Country other = (Country)obj;
        return code.equals(other.code) && name.equals(other.name);
    }

    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */
        
        final Character separator = ':';
        int countOfSeparators = text.replaceAll("[^" + separator.toString() + "]+", "").length();

        if (countOfSeparators > 1 || countOfSeparators == 0) {
            throw new ParseException("incorrect format", 0);
        }

        String code = text.replaceAll(":.+", "");
        String name = text.replaceAll("[^:]+:", "");

        return new Country(code, name);
    }
}
