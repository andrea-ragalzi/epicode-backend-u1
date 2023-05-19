package com.ragalzi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Book;
import models.Library;
import models.Magazine;
import models.Publication;
import models.User;
import dao.LoanDAO;
import dao.PublicationDAO;
import dao.UserDAO;

import models.Loan;

public final class App {
        private static Library library;

        public static void main(String[] args) {
                // Generate and save random library
                library = Library.randomLibrary(10);
                PublicationDAO publicationDAO = new PublicationDAO();
                publicationDAO.saveAll(library.getAllPublications());

                // Aggiunta di un elemento del catalogo
                Book book = Book.randomBook();
                publicationDAO.save(book);

                Magazine magazine = Magazine.randomMagazine();
                publicationDAO.save(magazine);

                // Rimozione di un elemento del catalogo dato un codice ISBN
                System.out.println(
                                String.format(
                                                "Publication removed by ISBN: %s\n\n %s",
                                                book.getIsbn(), book));
                publicationDAO.removeByIsbn(book.getIsbn());

                // Ricerca per ISBN
                Publication publicationFound = publicationDAO.getByIsbn("00008");
                System.out.println(
                                String.format(
                                                "Publication found by ISBN: %s\n\n %s",
                                                publicationFound.getIsbn(), publicationFound));

                // Ricerca per anno pubblicazione
                int year = 2017;
                List<Publication> publicationsByYear = publicationDAO.getByYear(year);
                System.out.println(
                                String.format(
                                                "Publications found by year: %s\n\n %s",
                                                year, publicationsByYear));

                // Ricerca per autore
                String author = "George Orwell";
                List<Publication> publicationsByAuthor = publicationDAO.getByAuthor(author);
                System.out.println(
                                String.format(
                                                "Publications found by author: %s\n\n %s",
                                                author, publicationsByAuthor));

                // Ricerca per titolo o parte di esso
                String searchTerm = "The Great Gatsby";
                List<Publication> publicationsByTitle = publicationDAO.getByTitle(searchTerm);
                System.out.println(
                                String.format(
                                                "Publications found by title: %s\n\n %s",
                                                searchTerm, publicationsByTitle));

                // Generate and save random users
                List<User> users = randomUsers(10);
                UserDAO userDAO = new UserDAO();
                userDAO.saveAll(users);

                // Generate and save random loans
                List<Loan> loans = randomLoans(10);
                System.out.println(loans);
                LoanDAO loanDAO = new LoanDAO();
                loanDAO.saveAll(loans);

                // Ricerca degli elementi attualmente in prestito dato un numero di tessera
                // utente
                long cardNumber = 5;
                List<Loan> loansByUser = loanDAO.getLoansByCardNumber(cardNumber);
                System.out.println(
                                String.format(
                                                "Loans found by card number: %s\n\n %s",
                                                cardNumber, loansByUser));

                // Ricerca di tutti i prestiti scaduti e non ancora restituiti
                List<Loan> loansNotReturned = loanDAO.getExpiredNotReturnedLoans();
                System.out.println(
                                String.format(
                                                "Loans not returned:\n\n %s",
                                                loansNotReturned));
        }

        public static List<User> randomUsers(int quantity) {
                System.out.println(
                                String.format(
                                                "Generating %d random users\n", quantity));
                List<User> users = new ArrayList<User>();
                for (int i = 0; i < quantity; i++) {
                        users.add(User.randomUser());
                }
                return users;
        }

        public static List<Loan> randomLoans(int quantity) {
                System.out.println(
                                String.format(
                                                "Generating %d random loans\n", quantity));
                Random random = new Random();
                UserDAO userDAO = new UserDAO();
                List<User> users = new ArrayList<User>();
                users = userDAO.getAll();
                PublicationDAO publicationDAO = new PublicationDAO();
                List<Publication> publications = new ArrayList<Publication>();
                publications = publicationDAO.getAll();
                List<Loan> loans = new ArrayList<Loan>();
                for (int i = 0; i < quantity; i++) {
                        User user = users.get(random.nextInt(users.size()));
                        Publication publication = publications.get(random.nextInt(publications.size()));
                        LocalDate startDate = LocalDate.now().minusDays(random.nextInt(30));
                        LocalDate endDate = LocalDate.now().minusDays(random.nextInt(30));
                        LocalDate returnDate = endDate.plusDays(random.nextInt(7));
                        Loan loan = new Loan(user, publication, startDate, endDate, returnDate);
                        loans.add(loan);
                }
                return loans;
        }

}