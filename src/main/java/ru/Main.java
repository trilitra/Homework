package ru;


import org.postgresql.core.SqlCommand;

import java.sql.*;

/**
 * Задание 1. Взять за основу предметную область выбранную на занятии по UML:
 * <p>
 * Спроектировать базу данных для выбранной предметной области (минимум три таблицы).
 * Типы и состав полей в таблицах на ваше усмотрение.
 * Связи между таблицами делать не обязательно.
 * Задание 2. Через JDBC интерфейс описать CRUD операции с созданными таблицами:
 * <p>
 * Применить параметризованный запрос.
 * Применить батчинг.
 * Использовать ручное управление транзакциями.
 * Предусмотреть использование savepoint при выполнении логики из нескольких запросов.
 * Предусмотреть rollback операций при ошибках.
 * Желательно предусмотреть метод сброса и инициализации базы данных.
 */

/**
 * В этом методе я показываю пример работы с базой данных, состоящей из трех таблиц: reader - читатели блога,
 * author - авторы блога, article - статьи блога. Взаимосвязей между таблицами нет, что допустимо по заданию.
 */
public class Main {
    private static final String INSERT_SQL = "INSERT INTO reader " + "(name) VALUES (?)";
    private static Integer[] localArgs = new Integer[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbcDB", "postgres", "qwerty")) {

            //Сброс и инициализация базы данных
            DBUtil.renewDatabase();

            /*Параметризорованный запрос - вывод в консоль данных из таблицы reader для записи с заданным нами именем
            "Читатель-1"*/

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM reader WHERE name = ?")) {
                preparedStatement.setString(1, "Читатель-1");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.print("id = " + resultSet.getInt("id"));
                        System.out.println(" name = " + resultSet.getString("name"));
                    }
                }
            }

            //Батчинг. Меняем имена всем читателям - на имя "Любимый читатель"
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "update reader set name = 'Любимый читатель' where id = ?")) {
                for (Integer arg : localArgs) {
                    preparedStatement.setInt(1, arg);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }

            /*Ручное управление транзакциями. Использование savepoint и rollback. Мы добавляем 3 читателей к
            5 существующим и делаем  savepoint потом добавляем еще читателя и создаем ошибку SQLException.
            Делаем rollback к savepoint и видим что добавились только 3 читателя вставленные до savepoint.*/

            DBUtil.renewDatabase();
            connection.setAutoCommit(false);
            Savepoint savepoint = null;
            try (PreparedStatement insertStmt = connection.prepareStatement(INSERT_SQL)) {
                // 1 запись
                insertStmt.setString(1, "Читатель-6");
                insertStmt.executeUpdate();

                // 2 запись
                insertStmt.setString(1, "Читатель-7");
                insertStmt.executeUpdate();

                // 3 запись
                insertStmt.setString(1, "Читатель-8");
                insertStmt.executeUpdate();

                // Создание Savepoint
                savepoint = connection.setSavepoint("first_savepoint");

                // 4 запись
                insertStmt.setString(1, "Читатель-9");
                insertStmt.executeUpdate();

                //Создание ошибки
                throw new SQLException();

                // Rollback к savepoint. Commit
            }
            catch (SQLException e){
                System.out.println("SQLException. Executing rollback to savepoint...");
                connection.rollback(savepoint);
                connection.commit();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}