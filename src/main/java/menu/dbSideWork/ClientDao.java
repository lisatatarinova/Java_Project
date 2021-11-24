package main.java.menu.dbSideWork;

import main.java.domain.Client;

import java.sql.*;

public class ClientDao implements DaoClientFactory {
    public static final String SQL_SELECT_CLIENT_ID =
            "SELECT * FROM CLIENT WHERE id=?";
    public static final String SQL_REGISTER_CLIENT =
            "INSERT INTO CLIENT(FIRST_NAME, LAST_NAME,BIRTH_DAY,ID,PASSWORD_NUMBER) VALUES(?,?,?,?,?)";
    public static final String SQL_SET_RENTED_AUTO =
            "UPDATE CLIENT SET RENTED_AUTO_ID = ? where ID =?";

    @Override
    public Client logInClient(int i) throws SQLException {

        Connection connection = ConnectionSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_ID,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, i);

        ResultSet rs = statement.executeQuery();

        Client client = new ClientRowMapper().getRowMapperClient().mapRow(rs);

        return client;
    }

    @Override
    public String registerClient(Client client) throws SQLException {
        Connection connection = ConnectionSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_REGISTER_CLIENT);
        statement.setString(1, client.getFullName().getFirstName());
        statement.setString(2,client.getFullName().getLastName());
        statement.setDate(3, Date.valueOf(client.getBirthDay().toLocalDate()));
        statement.setInt(4, getLastID()+1);
        statement.setString(5,client.getPassportNumber());
        statement.execute();

        System.out.printf("Ваш ID: %s \n",getLastID());
        return null;
    }

    @Override
    public int getLastID() throws SQLException {
        Connection connection = ConnectionSource.getConnection();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("SELECT MAX(ID) from CLIENT");
        rs.first();
        return rs.getInt(1);
    }

    @Override
    public void setRentedAuto(Client client, int idA, Date date) throws SQLException {
        Connection connection = ConnectionSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_SET_RENTED_AUTO,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, idA);
        statement.setInt(2, client.getId());
        statement.execute();
        System.out.printf("Автомобиль будет готов к выдаче %s \n", date.toLocalDate().minusDays(5).toString());
        System.out.println("Большое спасибо, что пользуетесь услугами нашего автосалона!");
    }
}
