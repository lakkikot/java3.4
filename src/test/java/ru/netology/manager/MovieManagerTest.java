package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTest {

    Movie m1 = new Movie(1, "First", "text", "text");
    Movie m2 = new Movie(2, "Second", "text", "text");
    Movie m3 = new Movie(3, "Third", "text", "text");
    Movie m4 = new Movie(4, "Fourth", "text", "text");
    Movie m5 = new Movie(5, "Fifth", "text", "text");
    Movie m6 = new Movie(6, "Sixth", "text", "text");
    Movie m7 = new Movie(7, "Seventh", "text", "text");
    Movie m8 = new Movie(8, "Eighth", "text", "text");
    Movie m9 = new Movie(9, "Ninth", "text", "text");
    Movie m10 = new Movie(10, "Tenth", "text", "text");
    Movie m11 = new Movie(11, "Eleventh", "text", "text");



    @Test // добавляет фильм + проверка выдачи одного фильма
    public void shouldAddMovie() {
        MovieManager movie = new MovieManager(5);

        movie.addMovie(m1);

        Movie[] expected = new Movie[]{m1};
        Movie[] actual = movie.getMovies();

        assertArrayEquals(expected, actual);
    }


    @Test // выдает добавленные фильмы в правильном порядке
    public void shouldGetMovies() {
        MovieManager movie = new MovieManager(5);

        movie.addMovie(m1);
        movie.addMovie(m2);
        movie.addMovie(m3);
        movie.addMovie(m4);
        movie.addMovie(m5);

        Movie[] expected = new Movie[]{m5, m4, m3, m2, m1};
        Movie[] actual = movie.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test // выдает ограниченное количество фильмов, если добавлено больше
    public void shouldGetRightAmountOfMovies() {
        MovieManager movie = new MovieManager(5);

        movie.addMovie(m1);
        movie.addMovie(m2);
        movie.addMovie(m3);
        movie.addMovie(m4);
        movie.addMovie(m5);
        movie.addMovie(m6);

        Movie[] expected = new Movie[]{m6, m5, m4, m3, m2};
        Movie[] actual = movie.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test // выдает 10 фильмов на стандартном конструкторе
    public void shouldGet10Movies() {
        MovieManager movie = new MovieManager();

        movie.addMovie(m1);
        movie.addMovie(m2);
        movie.addMovie(m3);
        movie.addMovie(m4);
        movie.addMovie(m5);
        movie.addMovie(m6);
        movie.addMovie(m7);
        movie.addMovie(m8);
        movie.addMovie(m9);
        movie.addMovie(m10);

        Movie[] expected = new Movie[]{m10, m9, m8, m7, m6, m5, m4, m3, m2, m1};
        Movie[] actual = movie.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test // выдает не больше 10 фильмов
    public void shouldGetMax10Movies() {
        MovieManager movie = new MovieManager();

        movie.addMovie(m1);
        movie.addMovie(m2);
        movie.addMovie(m3);
        movie.addMovie(m4);
        movie.addMovie(m5);
        movie.addMovie(m6);
        movie.addMovie(m7);
        movie.addMovie(m8);
        movie.addMovie(m9);
        movie.addMovie(m10);
        movie.addMovie(m11);

        Movie[] expected = new Movie[]{m11, m10, m9, m8, m7, m6, m5, m4, m3, m2};
        Movie[] actual = movie.getMovies();

        assertArrayEquals(expected, actual);
    }



}