package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(str -> {
                String[] nameMail = str.split(";", 2);
                if (nameMail[0].isEmpty() || nameMail[1].isEmpty()) {
                    throw new IllegalArgumentException("Your string must be like: \"name;email;\"");
                }
                users.add(new User(nameMail[0], nameMail[1].replace(";", "")));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("driver_class"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users spam(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "db/dump.txt");
        db.save(db.load());
    }
}