package menu.dbSideWork.DAO;

import domain.Client;

import java.sql.Date;
import java.sql.SQLException;

public interface DaoClient {
    Client logInClient(int i) throws SQLException;
    String registerClient(Client client) throws SQLException;
    int getLastID() throws SQLException;
    String setRentedAuto(Client client, int idA, Date date) throws SQLException;
}
