package io.github.checkpoint01.backend.msmovies.domain.dto;

import java.util.Objects;

public class MovieDTO {
    private String name;
    private String genre;
    private String urlStream;

    private MovieDTO(Builder builder) {
        name = builder.name;
        genre = builder.genre;
        urlStream = builder.urlStream;
    }

    public MovieDTO() {}

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
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(name, movieDTO.name) && Objects.equals(genre, movieDTO.genre) && Objects.equals(urlStream, movieDTO.urlStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, urlStream);
    }

    @Override
    public String toString() {
        return (
            "MovieDTO{" +
            "name='" +
            name +
            '\'' +
            ", genre='" +
            genre +
            '\'' +
            ", url_stream='" +
                    urlStream +
            '\'' +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String genre;
        private String urlStream;

        private Builder() {
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

        public MovieDTO build() {
            return new MovieDTO(this);
        }
    }
}
