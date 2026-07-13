package com.ucacue.api.domain.model;

import java.util.List;
import java.util.UUID;

public class Author {

    private UUID id;
    private String firstName;
    private String lastName;
    private List<Book> books;

    public Author() {
    }

    public Author(UUID id, String firstName, String lastName, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    public UUID getId() {
    return id;
  }

    public void setId(UUID id) {
    this.id = id;
  }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
