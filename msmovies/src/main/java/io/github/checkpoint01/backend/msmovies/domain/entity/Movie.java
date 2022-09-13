package io.github.checkpoint01.backend.msmovies.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "url_stream")
    private String urlStream;

    public Movie() {}

    private Movie(Builder builder) {
        id = builder.id;
        name = builder.name;
        genre = builder.genre;
        urlStream = builder.urlStream;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getUrlStream() {
        return urlStream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre) && Objects.equals(urlStream, movie.urlStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, urlStream);
    }

    @Override
    public String toString() {
        return (
            "Movie{" +
            "id=" +
            id +
            ", name='" +
            name +
            '\'' +
            ", genre='" +
            genre +
            '\'' +
            ", urlStream='" +
            urlStream +
            '\'' +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String genre;
        private String urlStream;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder urlStream(String urlStream) {
            this.urlStream = urlStream;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
