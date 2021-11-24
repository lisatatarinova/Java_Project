package main.java.menu.dbSideWork;

import main.java.domain.Automobile;
import main.java.domain.Client;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface DaoAutoFactory {
    void getAllAuto() throws SQLException;
    void rentAuto(Client client, int idA, Date startDate, Date endDate, String passport) throws SQLException, WrongPassportNumberException;

}
