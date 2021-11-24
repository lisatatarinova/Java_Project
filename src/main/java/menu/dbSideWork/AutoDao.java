package main.java.menu.dbSideWork;

import main.java.domain.Automobile;
import main.java.domain.Client;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AutoDao implements DaoAutoFactory {
    public static final String SQL_SELECT_ALL_AUTOMOBILES = "select a.* from AUTOMOBILE a\n" +
            "left join CLIENT c on a.ID=c.RENTED_AUTO_ID\n" +
            "where c.ID is null";
    public static final String SQL_Rent_AUTOMOBILE = "insert into ORDERS values(?, ?, ?, ?)";

    @Override
    public void getAllAuto() throws SQLException {
        Connection connection = ConnectionSource.getConnection();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_AUTOMOBILES);
        Set<Automobile> automobiles= new AutoSetMapper().automobileSetMapper().mapSet(rs);
        Iterator iter = automobiles.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }

    @Override
    public void rentAuto(Client client, int idA, Date startDate, Date endDate, String passport) throws SQLException, WrongPassportNumberException {
        if(client.getPassportNumber().equals(passport)==true){
            Connection connection = ConnectionSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_Rent_AUTOMOBILE, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1,client.getId());
            statement.setInt(2,idA);
            statement.setDate(3,startDate);
            statement.setDate(4,endDate);
            statement.execute();
            new ClientDao().setRentedAuto(client, idA, startDate);
        } else{
            throw new WrongPassportNumberException();
        }

    }



}
