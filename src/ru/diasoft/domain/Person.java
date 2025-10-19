package ru.diasoft.domain;

import ru.diasoft.service.exceptions.InvalidPhoneNumberException;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Person {
   private String firstName;
   private String secondName;
   private int age;
   private String phone;
   private final int VALID_RUSSIAN_PHONE_NUMBERS_LENGTH = 11;

    Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName, int age, String phone) throws InvalidPhoneNumberException {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        setPhone(phone);
    }
// Убираем так как теперь используем Lombook для генерации
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public void setPhone(String phone) throws InvalidPhoneNumberException {
        if (phone != null && !phone.isEmpty()) {
            validatePhoneNumber(phone);
        }
        this.phone = phone;

    }

    private void validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
        String cleanPhone = phone.replaceAll("[\\s\\-\\(\\)\\+]", "");

        if (!cleanPhone.matches("\\d+")) {
            throw new InvalidPhoneNumberException(
                    "Номер содержит недопустимые символы: " + phone + "- Разрешены только цифры."
            );
        }
        if (cleanPhone.length() != VALID_RUSSIAN_PHONE_NUMBERS_LENGTH) {
            throw new InvalidPhoneNumberException(
                    "Номер телефона не соответствует параметрам: " + phone + " - Длина номера в России - 11 цифр."
            );
        }
    }
}
