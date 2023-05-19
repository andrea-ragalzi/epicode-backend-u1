package models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_number", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "isbn", nullable = false)
    private Publication publication;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Loan () {
        
    }

    public Loan(User user, Publication publication,
            LocalDate startDate, LocalDate endDate, LocalDate returnDate) {
        this.user = user;
        this.publication = publication;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
    }

    public Loan(Long id, User user, Publication publication,
            LocalDate startDate, LocalDate endDate, LocalDate returnDate) {
        this.id = id;
        this.user = user;
        this.publication = publication;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "\n\tid=" + id +
                ",\n\tuser=" + user +
                ",\n\tpublication=" + publication +
                ",\n\tstartDate=" + startDate +
                ",\n\tendDate=" + endDate +
                ",\n\treturnDate=" + returnDate +
                "\n}";
    }
}
