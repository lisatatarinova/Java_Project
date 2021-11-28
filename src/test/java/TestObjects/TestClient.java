package TestObjects;

import domain.Client;
import menu.dbSideWork.DAO.ClientDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

public class TestClient {
    ClientDao clientDao = new ClientDao();

    @Test
    public void testGetLastId() throws SQLException {
        Assertions.assertEquals(1125, clientDao.getLastID());
    }

    @Test
    public void testBirthday() throws SQLException {
        Client client = clientDao.logInClient(1119);
        Assertions.assertEquals(Date.valueOf("1987-09-23"), client.getBirthDay());
    }
}
