package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data
public class MovieManager {
    private int amountMovies = 10;
    private Movie[] movies = new Movie[0];

    public MovieManager(int amountMovies) { // конструктор с возможностью менять длину массива
        this.amountMovies = amountMovies;
    }

    public MovieManager() { // конструктор с размером "по умолчанию"
    }


    public Movie[] getMovies() {

        int resultLength;
        if (movies.length > amountMovies) {
            resultLength = amountMovies;
        } else {
            resultLength = movies.length;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void addMovie(Movie item) {
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

}
