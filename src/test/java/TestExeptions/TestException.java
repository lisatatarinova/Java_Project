package TestExeptions;

import menu.Menu;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;
import org.junit.Test;
import org.hamcrest.SelfDescribing;
import java.sql.SQLException;

public class TestException {

    @Test(expected = IllegalArgumentException.class)
    public void testNotIntMenuOption() throws SQLException {
        new Menu("fdv");
    }

}
