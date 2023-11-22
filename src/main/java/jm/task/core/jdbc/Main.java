package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Персона1", "Фамилия1", (byte) 10);
        userService.saveUser("Персона2", "Фамилия2", (byte) 20);
        userService.saveUser("Персона3", "Фамилия3", (byte) 30);
        userService.saveUser("Персона4", "Фамилия4", (byte) 40);

        userService.getAllUsers().toString();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
