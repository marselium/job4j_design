package ru.job4j.jdbc;

import ru.job4j.iterator.io.Config;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws SQLException, IOException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream("data/app.properties"));
        String url = properties.getProperty("datasource.url");
        String login = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
