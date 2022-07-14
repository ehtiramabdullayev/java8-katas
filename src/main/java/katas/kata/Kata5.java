package katas.kata;

import katas.model.Movie;
import katas.util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies
                .stream()
                .map(Movie::getRating)
                .reduce(Double::max)
                .orElse(0.0d);

    }
}
