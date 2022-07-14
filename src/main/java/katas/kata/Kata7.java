package katas.kata;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.model.BoxArt;
import katas.model.Movie;
import katas.model.MovieList;
import katas.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists
                .stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(functionMovieToMap())
                .collect(Collectors.toList());
    }

    static Function<Movie, ImmutableMap<String, Object>> functionMovieToMap() {
        return item -> ImmutableMap.of(
                "id", item.getId(),
                "title", item.getTitle(),
                "boxart", item.getBoxarts()
                        .stream()
                        .reduce((box1, box2) -> box1.getWidth() < box2.getWidth() ? box1 : box2)
                        .map(BoxArt::getUrl));
    }
}
