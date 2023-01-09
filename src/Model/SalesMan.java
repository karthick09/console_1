package Model;

import java.time.LocalDate;

public class SalesMan extends Person{
    private final String salesManId;
    private final LocalDate dateOfJoin;

    public SalesMan(String name, String email, String phone, Account account, String salesManId) {
        super(name, email, phone, account);
        this.salesManId = salesManId;
        this.dateOfJoin=LocalDate.of(2022,1,4);
    }

    public String getSalesManId() {
        return salesManId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

}
