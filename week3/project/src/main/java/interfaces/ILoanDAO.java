package interfaces;

import java.util.List;

import models.Loan;

public interface ILoanDAO {
    public void save(Loan loan);

    public void saveAll(List<Loan> loans);

    public Loan getById(Long id);

    public List<Loan> getAll();

    public void update(Loan loan);

    public void removeById(Long id);

    public List<Loan> getLoansByCardNumber(long cardNumber);

    public List<Loan> getExpiredNotReturnedLoans();
}
