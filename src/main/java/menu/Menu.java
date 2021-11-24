package main.java.menu;

import main.java.domain.Automobile;
import main.java.domain.Client;
import main.java.menu.dbSideWork.AutoDao;
import main.java.menu.dbSideWork.ClientDao;
import main.java.menu.dbSideWork.WrongPassportNumberException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** Меню
 *
 * Класс Меню действий
 *
 */
public class Menu {
    String choice;
    int selectedMenuOption;
    Scanner scanner = new Scanner(System.in);


    public Menu() throws SQLException, WrongPassportNumberException {
        System.out.println("Пожалуйста, выберите действие:");
        System.out.println("1. Регистрация в системе");
        System.out.println("2. Заказ автомобиля");
        System.out.println("Другой символ: Выход");
        System.out.print("Ваш выбор -> ");
        this.choice = scanner.nextLine();
        this.selectedMenuOption = Integer.parseInt(choice);

        this.selectedMenuOption();
    }

    public void selectedMenuOption() throws SQLException, WrongPassportNumberException {
        switch (selectedMenuOption){
            case 1:
                System.out.println("Вы выбрали пункт Регистрация в системе");
                System.out.print("Введите имя: ");
                String entered_FName = scanner.nextLine();
                System.out.print("Введите фамилию: ");
                String entered_LName = scanner.nextLine();
                System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                //напоминалка себе
                //надо-таки шото сделать с вводом ДР
                System.out.println("ЛИЗА!!! ПОПРАВЬ ВВОД ДР!!! ЭТО ЖЕ ПОЗОР КАКОЙ-ТО");
                String entered_Date = scanner.nextLine();
                System.out.print("Введите номер вашего паспорта для завершения регистрации: ");
                String entered_passport = scanner.nextLine();
                Client new_client = new Client(entered_FName, entered_LName, Date.valueOf(entered_Date), entered_passport);
                new ClientDao().registerClient(new_client);
                menuRentAuto(new_client);
                break;
            case 2:
                System.out.println("Сначала войдите в систему");
                System.out.print("Введите свой ID: ");
                String entered_ID = scanner.nextLine();
                int id = Integer.valueOf(entered_ID);

                Client client = new ClientDao().logInClient(id);
                if (client == null){
                    new Menu();
                    break;
                }

                menuRentAuto(client);

                break;
            default:
                System.out.println("Вcего доброго!\nЖдем Вас снова!");
                break;
        }
    }

    public void menuRentAuto(Client client) throws SQLException, WrongPassportNumberException{
        final Client CLIENT_CONST = client;

        System.out.println("Выберите автомобиль из списка ниже");
        AutoDao autoDao = new AutoDao();
        autoDao.getAllAuto();
        System.out.print("Введите ID выбранного автомобиля: ");
        String entered_AutoID = scanner.nextLine();
        int auto_ID = Integer.valueOf(entered_AutoID);
        System.out.print("Введите дату начала брони в формате ГГГГ-ММ-ДД: ");
        String entered_startDate = scanner.nextLine();
        Date startDate = Date.valueOf(entered_startDate);
        System.out.print("Введите дату окончания брони в формате ГГГГ-ММ-ДД: ");
        String entered_endDate = scanner.nextLine();
        Date endDate = Date.valueOf(entered_endDate);
        System.out.print("Введите номер вашего паспорта для завершения бронирования авто: ");
        String entered_passport1 = scanner.nextLine();
        autoDao.rentAuto(CLIENT_CONST,auto_ID,startDate,endDate,entered_passport1);
    }

}
