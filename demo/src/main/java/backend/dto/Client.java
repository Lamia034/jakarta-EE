package backend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private Integer code;
    private String name;
    private String prenoun;
    private String adresse;
    private String phone;
    private LocalDate birthDate;



    public Client(){

    }

    public Client(String name, String prenoun, LocalDate birthDate, String phone, Integer code, String adresse) {

        this.code = code;
        this.name = name;
        this.prenoun = prenoun;
        this.adresse = adresse;
        this.birthDate = birthDate;
        this.phone = phone;

    }

    public Client(String name, String prenoun, LocalDate birthdate, String phone, String adresse) {
        setName(name);
        setPrenoun(prenoun);
        setBirthDate(birthdate);
        setPhone(phone);
        setAdresse(adresse);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    // Getter and setter for hiringDate
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrenoun() {
        return prenoun;
    }

    public void setPrenoun(String prenoun) {
        this.prenoun = prenoun;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", prenoun='" + prenoun + '\'' +
                ", birthdate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
