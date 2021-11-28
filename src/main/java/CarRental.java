//        Клиент выбирает Автомобиль из списка доступных.
//        Заполняет форму Заказа, указывая паспортные данные, срок аренды.

import menu.Menu;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;

import java.sql.SQLException;

public class CarRental {
   public static void main(String[] args) throws SQLException, WrongPassportNumberException {
       new Menu(null);
    }
}
