package main.java.domain;

import java.sql.Date;

public class Order {
    private int clientId;
    private int autoId;
    private Date startDate;
    private Date endDate;

    Order(int clientId, int autoId, Date d1, Date d2){
        this.autoId = autoId;
        this.clientId = clientId;
        this.startDate=d1;
        this.endDate=d2;
    }
}
