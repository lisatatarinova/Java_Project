package domain;

import java.math.BigDecimal;
import java.sql.Date;

/** Клиент
 *
 * Класс Клиента
 *
 */

public class Client {
    private int id;
    private FullName fullName;
    private Date birthDay;
    private BigDecimal rentedAutoId;
    private String passportNumber;

    public Client(){

    }

    public Client(int id, FullName fullName, Date localDate, String passportNumber) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = localDate;
        this.passportNumber = passportNumber;
        //System.out.printf("Добрый день, %s %s! \n", fullName.getFirstName(), fullName.getLastName());
    }

    public Client(String fName, String lName, Date localDate, String passportNumber) {
        fullName = new FullName(fName,lName);
        birthDay = localDate;
        this.passportNumber = passportNumber;

        //System.out.printf("Добро пожаловать, %s %s! \n", fullName.getFirstName(), fullName.getLastName());
    }


    public FullName getFullName() {
        return fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getId() {
        return id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}
