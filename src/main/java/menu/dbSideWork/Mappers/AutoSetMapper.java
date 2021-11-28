package menu.dbSideWork.Mappers;

import main.java.domain.Automobile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class AutoSetMapper{

    public SetMapper<Set<Automobile>> automobileSetMapper(){
        SetMapper<Set<Automobile>> SetMapperAutomobile = new SetMapper<Set<Automobile>>() {
            @Override
            public Set<Automobile> mapSet(ResultSet resultSet) throws SQLException {
                Set<Automobile> automobiles = new LinkedHashSet<>();

                resultSet.beforeFirst();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String model = resultSet.getString(2);
                    String colour = resultSet.getString(3);

                    automobiles.add(new Automobile(id, model, colour));

                }
                return automobiles;
            }
        };
        return SetMapperAutomobile;
    }
}
