package TestDates;

import domain.Client;
import menu.dbSideWork.DAO.ClientDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.stream.Stream;

public class TestDate {
    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("2021-09-02", "2021-09-07"),
                Arguments.of("2022-08-20", "2022-08-25"),
                Arguments.of("2023-11-11", "2023-11-16")
        );
    }


    @ParameterizedTest
    @MethodSource("testCases")
    public void testCarReadyToRent(String expected, String in) throws SQLException {
        Assertions.assertEquals(expected, new ClientDao().setRentedAuto(new Client(),1231, Date.valueOf(in)));
    }
}
