package main.java.menu.dbSideWork;

import main.java.domain.Client;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface DaoClientFactory {
    Client logInClient(int i) throws SQLException;
    String registerClient(Client client) throws SQLException;
    int getLastID() throws SQLException;
    void setRentedAuto(Client client, int idA, Date date) throws SQLException;
}
