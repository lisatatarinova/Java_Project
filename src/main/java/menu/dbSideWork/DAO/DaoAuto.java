package menu.dbSideWork.DAO;

import domain.Client;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;

import java.sql.Date;
import java.sql.SQLException;

public interface DaoAuto {
    void getAllAuto() throws SQLException;
    void rentAuto(Client client, int idA, Date startDate, Date endDate, String passport) throws SQLException, WrongPassportNumberException, WrongPassportNumberException;

}
