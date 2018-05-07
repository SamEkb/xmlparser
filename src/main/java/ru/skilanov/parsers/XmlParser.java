package ru.skilanov.parsers;

/**
 * Интерфейс содержащий методы трансформации объекта в xml и обратно в объект.
 */
public interface XmlParser {

    /**
     * Трансформация в xml.
     */
    void marshall();

    /**
     * Трансформация в объект.
     */
    void unMarshall();
}
