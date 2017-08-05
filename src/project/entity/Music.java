package project.entity;

import java.util.StringJoiner;

public class Music {

    final private String composer;
    final private String name;
    final private Genre genre;
    final private int year;

    public Music(String composer, String name, Genre genre, int year) {
        this.composer = composer;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        if (year != music.year) return false;
        if (composer != null ? !composer.equals(music.composer) : music.composer != null) return false;
        if (name != null ? !name.equals(music.name) : music.name != null) return false;
        return genre == music.genre;
    }

    @Override
    public int hashCode() {
        int result = composer != null ? composer.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    public String convertToString(String join_string){
        StringJoiner joiner = new StringJoiner(join_string);
        joiner .add(this.getComposer());
        joiner .add(this.getName());
        joiner .add(this.getGenre().name());
        joiner .add(this.getYear()+"");
        return joiner.toString().toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getComposer() {
        return composer;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return composer + " - " + name + " ("+year+") "+ " genre: "+genre.name();
    }
}
