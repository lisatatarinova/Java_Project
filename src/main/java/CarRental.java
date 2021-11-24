package main.java;//11.     Система Прокат автомобилей.
//        Клиент выбирает Автомобиль из списка доступных.
//        Заполняет форму Заказа, указывая паспортные данные, срок аренды.

import main.java.menu.Menu;
import main.java.menu.dbSideWork.WrongPassportNumberException;

import java.sql.SQLException;

public class CarRental {
   public static void main(String[] args) throws SQLException, WrongPassportNumberException {
       new Menu();
    }
}
