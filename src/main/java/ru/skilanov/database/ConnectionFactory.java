package ru.skilanov.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для подключения к базе данных.
 */
public class ConnectionFactory {
    /**
     * Конструктор.
     */
    public ConnectionFactory() {
        Config config = new Config();
        config.load();
        try {
            Class.forName(config.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод соединения с БД.
     *
     * @return соединение
     * @throws SQLException исключение
     */
    public static Connection getConnection() throws SQLException {
        Config config = new Config();
        config.load();
        return DriverManager.getConnection(config.getUrl(), config.getLogin(), config.getPassword());
    }
}
