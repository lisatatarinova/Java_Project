package menu.dbSideWork.DAO;

import main.java.domain.Automobile;
import domain.Client;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;
import menu.dbSideWork.Mappers.AutoSetMapper;

import java.sql.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AutoDao implements DaoAuto {
    public static final String SQL_SELECT_ALL_AUTOMOBILES = "select a.* from AUTOMOBILE a\n" +
            "left join CLIENT c on a.ID=c.RENTED_AUTO_ID\n" +
            "where c.ID is null";
    public static final String SQL_Rent_AUTOMOBILE = "insert into ORDERS values(?, ?, ?, ?)";

    @Override
    public void getAllAuto() throws SQLException {
        Connection connection = main.java.menu.dbSideWork.ConnectionSource.getConnection();
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
    public void rentAuto(Client client, int idA, Date startDate, Date endDate, String passport) throws SQLException {
        if(client.getPassportNumber().equals(passport)==true){
            Connection connection = main.java.menu.dbSideWork.ConnectionSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_Rent_AUTOMOBILE, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1,client.getId());
            statement.setInt(2,idA);
            statement.setDate(3,startDate);
            statement.setDate(4,endDate);
            statement.execute();
            new ClientDao().setRentedAuto(client, idA, startDate);
        } else{
            System.out.println("Неверный номер паспорта, повторите ввод");
            String passport_new = new Scanner(System.in).nextLine();
            rentAuto(client, idA, startDate, endDate, passport_new);
        }

    }



}
