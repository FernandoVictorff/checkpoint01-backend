package io.github.checkpoint01.backend.msmovies.domain.dto;

import java.util.Objects;

public class CreateMovieDTO {
    private String name;
    private String genre;
    private String urlStream;

    private CreateMovieDTO(Builder builder) {
        this.name = builder.name;
        this.genre = builder.genre;
        this.urlStream = builder.urlStream;
    }

    public CreateMovieDTO() {}

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
        CreateMovieDTO that = (CreateMovieDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(genre, that.genre) && Objects.equals(urlStream, that.urlStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, urlStream);
    }

    @Override
    public String toString() {
        return "CreateMovieDTO{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", urlStream='" + urlStream + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String genre;
        private String urlStream;

        private Builder() {}

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

        public CreateMovieDTO build() {
            return new CreateMovieDTO(this);
        }
    }
}
