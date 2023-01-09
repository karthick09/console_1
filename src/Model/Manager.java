package Model;

import java.time.LocalDate;

public class Manager extends Person{

    private final String mangerId;
    private final LocalDate dateOfJoin;

    public Manager(String name, String email, String phone, Account account, String mangerId) {
        super(name, email, phone, account);
        this.mangerId = mangerId;
        this.dateOfJoin=LocalDate.of(2022,1,4);
    }


    public String getMangerId() {
        return mangerId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }
}
