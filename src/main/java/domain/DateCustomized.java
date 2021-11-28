package domain;

import menu.Menu;
import menu.dbSideWork.Exceptions.WrongPassportNumberException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class DateCustomized {
    String inputDate;
    Date outputDate;

    public DateCustomized(String inputDate) {
        this.inputDate = inputDate;
        dateCheck(inputDate);
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void dateCheck(String inputDate){

        this.inputDate = inputDate;

        String[] strings = inputDate.split("-");
            if(Integer.valueOf(strings[0])>2021 || Integer.valueOf(strings[0])<1910
                    || Integer.valueOf(strings[1])>12 || Integer.valueOf(strings[1])<1
                    || Integer.valueOf(strings[2])>31 || Integer.valueOf(strings[2])<1){
                    System.out.println("Неверно введена дата, повторите ввод");
                    this.inputDate = new Scanner(System.in).nextLine();
                    new DateCustomized(this.inputDate);
            }


        this.outputDate=Date.valueOf(this.inputDate);

    }

}
