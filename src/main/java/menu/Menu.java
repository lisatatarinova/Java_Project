package menu;

import domain.Client;
import domain.DateCustomized;
import menu.dbSideWork.DAO.AutoDao;
import menu.dbSideWork.DAO.ClientDao;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

/** Меню
 *
 * Класс Меню действий
 *
 */
public class Menu {
    String choice;
    public int selectedMenuOption;
    Scanner scanner = new Scanner(System.in);


    public Menu(String choice) throws SQLException, NumberFormatException {
        System.out.println("Пожалуйста, выберите действие:");
        System.out.println("1. Регистрация в системе");
        System.out.println("2. Заказ автомобиля");
        System.out.println("Другая цифра: Выход");
        System.out.print("Ваш выбор -> ");
        if(choice==null){
            this.choice = scanner.nextLine();
        }
        else this.choice = choice;

        try {
            this.selectedMenuOption = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }


        this.selectedMenuOption();
    }

    public void selectedMenuOption() throws SQLException {
        switch (selectedMenuOption){
            case 1:
                System.out.println("Вы выбрали пункт Регистрация в системе");
                System.out.print("Введите имя: ");
                String entered_FName = scanner.nextLine();
                System.out.print("Введите фамилию: ");
                String entered_LName = scanner.nextLine();
                System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                String entered_date = scanner.nextLine();
                DateCustomized dateCustomized = new DateCustomized(entered_date);
                System.out.print("Введите номер вашего паспорта для завершения регистрации: ");
                String entered_passport = scanner.nextLine();

                Client new_client = new Client(entered_FName, entered_LName,dateCustomized.getOutputDate() , entered_passport);
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
                    new Menu(null);
                    break;
                }

                menuRentAuto(client);

                break;
            default:
                System.out.println("Вcего доброго!\nЖдем Вас снова!");
                break;
        }
    }

    public void menuRentAuto(Client client) throws SQLException{
        final Client CLIENT_CONST = client;

        System.out.println("Выберите автомобиль из списка ниже");
        AutoDao autoDao = new AutoDao();
        autoDao.getAllAuto();
        System.out.print("Введите ID выбранного автомобиля: ");
        String entered_AutoID = scanner.nextLine();
        int auto_ID = Integer.valueOf(entered_AutoID);
        System.out.print("Введите дату начала брони в формате ГГГГ-ММ-ДД: ");
        String entered_startDate = scanner.nextLine();
        DateCustomized dateCustomized = new DateCustomized(entered_startDate);
        Date startDate = dateCustomized.getOutputDate();
        System.out.print("Введите дату окончания брони в формате ГГГГ-ММ-ДД: ");
        String entered_endDate = scanner.nextLine();
        DateCustomized dateCustomized2 = new DateCustomized(entered_endDate);
        Date endDate =  dateCustomized2.getOutputDate();
        System.out.print("Введите номер вашего паспорта для завершения бронирования авто: ");
        String entered_passport1 = scanner.nextLine();
        autoDao.rentAuto(CLIENT_CONST,auto_ID,startDate,endDate,entered_passport1);
    }

}
