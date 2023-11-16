package ru.job4j.parsing.parse.model;

import java.time.LocalDate;

public class PrCred {

    private long id;

    private String num_dog;
    private LocalDate date_beg;
    private LocalDate date_end;
    private double summa;
    private String val;
    private String kind_credit;
    private long list_pay;
    private long list_plan_pay;
    private String state;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PrCred{" +
                "id=" + id +
                ", num_dog='" + num_dog + '\'' +
                ", date_beg=" + date_beg +
                ", date_end=" + date_end +
                ", summa=" + summa +
                ", val='" + val + '\'' +
                ", kind_credit='" + kind_credit + '\'' +
                ", list_pay=" + list_pay +
                ", list_plan_pay=" + list_plan_pay +
                ", state='" + state + '\'' +
                '}';
    }
}
