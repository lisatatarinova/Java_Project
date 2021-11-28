package menu.dbSideWork.Mappers;

import domain.Client;
import domain.FullName;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Работа с клиентом БД
 *
 *
 */
public class ClientRowMapper {

    public RowMapper<Client> getRowMapperClient() {
         RowMapper<Client> RowMapperClient = new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet) throws SQLException {

                resultSet.first();
                //System.out.println(resultSet.getString(2));
                Client client = null;
                try {
                    int id = resultSet.getInt(1);
                    FullName fullName = new FullName(resultSet.getString(2), resultSet.getString(3));
                    Date date = resultSet.getDate(4);
                    String passport = resultSet.getString(6);
                    client = new Client(id, fullName, date, passport);
                } catch (SQLException e){
                    System.out.println("Такого ID не существует, пожалуйста зарегистрируйтесь");
                }

                return client;
            }
        };
        return RowMapperClient;
    }


}
