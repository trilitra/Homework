package ru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private DBUtil() {
    }

    public static void renewDatabase() throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcDB", "postgres", "qwerty");
             Statement statement = connection.createStatement();
        ) {
            statement.execute("-- Database: jdbcDB\n"
                    + "DROP TABLE IF EXISTS author;"
                    + "\n"
                    + "CREATE TABLE author (\n"
                    + "    id bigserial primary key,\n"
                    + "    name varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO author (name)\n"
                    + "VALUES\n"
                    + "   ('Алексей-автор'),\n"
                    + "   ('Михаил-автор'),\n"
                    + "   ('Иван-автор'),\n"
                    + "   ('Даниил-автор');"
                    + "\n"
                    + "DROP TABLE IF EXISTS reader;"
                    + "\n"
                    + "CREATE TABLE reader (\n"
                    + "    id bigserial primary key,\n"
                    + "    name varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO reader (name)\n"
                    + "VALUES\n"
                    + "   ('Читатель-1'),\n"
                    + "   ('Читатель-2'),\n"
                    + "   ('Читатель-3'),\n"
                    + "   ('Читатель-4'),\n"
                    + "   ('Читатель-5');"
                    + "\n"
                    + "DROP TABLE IF EXISTS article;"
                    + "\n"
                    + "CREATE TABLE article (\n"
                    + "    id bigserial primary key,\n"
                    + "    name varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO article (name)\n"
                    + "VALUES\n"
                    + "   ('Статья-1'),\n"
                    + "   ('Статья-2'),\n"
                    + "   ('Статья-3'),\n"
                    + "   ('Статья-4');"
                    + "\n");
        }
    }
}
