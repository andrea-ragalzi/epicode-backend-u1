package interfaces;

import java.util.List;

import models.Publication;

public interface IPublicationDAO {
    public void save(Publication publication);

    public void saveAll(List<Publication> publications);

    public Publication getByIsbn(String isbn);

    public List<Publication> getAll();

    public void removeByIsbn(String isbn);

    public List<Publication> getByYear(int year);

    public List<Publication> getByAuthor(String author);

    public List<Publication> getByTitle(String title);
}
