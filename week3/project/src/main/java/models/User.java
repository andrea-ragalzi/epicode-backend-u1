package models;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

    static private Long count = 0L;

    @Id
    @Column(name = "card_number")
    private Long cardNumber = 0L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private LocalDate birthDate;

    public User() {
        
    }


    public User(String name, String surname, LocalDate birthDate) {
        this.cardNumber = ++User.count;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public User(Long cardNumber, String name, String surname, LocalDate birthDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Long getCardNumer() {
        return cardNumber;
    }

    public void setCardNumer(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public static User randomUser() {
        final String[] NAMES = {
                "Eren", "Mikasa", "Armin", "Levi", "Erwin",
                "Hanji", "Jean", "Sasha", "Connie", "Reiner",
                "Bertholdt", "Annie", "Zeke", "Pieck", "Gabi", "Falco",
                "Ymir", "Historia", "Ymir Fritz", "Grisha", "Dina",
                "Karina", "Kiyomi", "Ramzi", "Zofia"
        };
        final String[] SURNAMES = {
                "Yeager", "Ackerman", "Arlert", "Ackermann",
                "Smith", "Zoe", "Kirschtein", "Braus", "Springer",
                "Braun", "Hoover", "Leonhart", "Jaeger", "Finger",
                "Braun", "Grice", "Dreyse", "Reiss", "Fritz",
                "Jaeger", "Togli", "Tybur", "Atiyeh", "Braun", "Magath"
        };
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String surname = SURNAMES[random.nextInt(SURNAMES.length)];
        LocalDate birthDate = LocalDate.now().minusYears(random.nextInt(18, 65)).minusDays(random.nextInt(365));
        return new User(name, surname, birthDate);
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "\n\tcardNumber=" + cardNumber +
                ",\n\t name='" + name + '\'' +
                ",\n\t surname='" + surname + '\'' +
                ",\n\t birthDate=" + birthDate +
                "\n}";
    }

}
