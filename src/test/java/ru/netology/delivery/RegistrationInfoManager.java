package ru.netology.delivery;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class RegistrationInfoManager {
    private String locale = "ru";
    private RegistrationInfo info;

    public RegistrationInfoManager() {
        this.info = new RegistrationInfo();
    }

    public void generateInfo() {
        Faker faker = new Faker(new Locale(this.locale));
        this.info.setCity(faker.address().city());
        this.info.setName(faker.name().name());
        this.info.setPhone(faker.phoneNumber().phoneNumber());

        Date from = DateManager.convertLocalDateToDate(LocalDate.now().plusDays(3));
        Date to = DateManager.convertLocalDateToDate(LocalDate.now().plusDays(6));
        LocalDate date = DateManager.convertDateToLocalDate(faker.date().between(from, to));

        this.info.setDate(DateManager.formatLocalDate(date));
    }

    public void changeDate() {
        Faker faker = new Faker(new Locale(this.locale));

        Date from = DateManager.convertLocalDateToDate(LocalDate.now().plusDays(7));
        Date to = DateManager.convertLocalDateToDate(LocalDate.now().plusDays(10));
        LocalDate date = DateManager.convertDateToLocalDate(faker.date().between(from, to));

        this.info.setDate(DateManager.formatLocalDate(date));
    }

    public RegistrationInfo getInfo() {
        return this.info;
    }
}
