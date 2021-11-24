package main.java.menu.dbSideWork;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SetMapper<T> {
    T mapSet(ResultSet resultSet) throws SQLException;
}
