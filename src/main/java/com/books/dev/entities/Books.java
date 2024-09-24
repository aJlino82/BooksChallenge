package com.books.dev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publishing;
    private String author;
    private String photo;

    public Books() {

    }

    public Books(Long id, String title, String publishing, String author, String photo) {

        this.id = id;
        this.title = title;
        this.publishing = publishing;
        this.author = author;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, id, photo, publishing, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Books other = (Books) obj;
        return Objects.equals(author, other.author) && Objects.equals(id, other.id)
                && Objects.equals(photo, other.photo) && Objects.equals(publishing, other.publishing)
                && Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "Books [id=" + id + ", title=" + title + ", publishing=" + publishing + ", author=" + author + ", photo="
                + photo + "]";
    }

}
