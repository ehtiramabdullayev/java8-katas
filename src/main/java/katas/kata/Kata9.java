package katas.kata;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.model.BoxArt;
import katas.model.InterestingMoment;
import katas.model.Movie;
import katas.model.MovieList;
import katas.util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .flatMap(item -> item.getVideos().stream())
                .map(functionMovieToMap())
                .collect(Collectors.toList());
    }

    static Function<Movie, Map<String, Object>> functionMovieToMap() {
        return movie -> ImmutableMap.of(
                "id", movie.getId(),
                "title", movie.getTitle(),
                "time", movie.getInterestingMoments().stream()
                        .filter(moment -> "Middle".equals(moment.getType()))
                        .findFirst()
                        .map(InterestingMoment::getTime),
                "url", movie.getBoxarts().stream()
                        .reduce((box1, box2) -> box1.getWidth() < box2.getWidth() ? box1 : box2)
                        .map(BoxArt::getUrl));
    }
}
