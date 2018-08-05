package pl.coderslab.dao;

import pl.coderslab.entity.Book;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDao {

    public static void save(Book book) throws Exception {
        if (book.getId() == null) {

            add(book);


        } else {

            update(book);
        }


    }

    private static void update(Book book) throws Exception {
        String query = "Update books set title=?, author=?, isbn=? where id=?;";
        List<String> params = new ArrayList<>();
        params.add(book.getTitle());
        params.add(book.getAuthor());
        params.add(book.getIsbn());
        params.add(String.valueOf(book.getId()));

        DbService.executeQuery(query, params);
    }

    private static void add(Book book) throws Exception {
        String query = "Insert into books Values(null,?,?,?);";
        List<String> params = new ArrayList<>();
        params.add(book.getTitle());
        params.add(book.getAuthor());
        params.add(book.getIsbn());

        Integer id = DbService.insertIntoDatabase(query, params);
        book.setId(id);
    }

    public static List<Book> findAll() throws Exception {
        String query = "select * from books;";
        List<Map<String, String>> data = DbService.getData(query, null);

        List<Book> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createObjectBook(row));
        }
        return result;
    }

    private static Book createObjectBook(Map<String, String> row) {
        Book book = new Book();
        book.setTitle(row.get("title"));
        book.setAuthor(row.get("author"));
        book.setIsbn(row.get("isbn"));
        return book;
    }
}
