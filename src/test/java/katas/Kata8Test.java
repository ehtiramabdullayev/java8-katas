package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.kata.Kata8;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata8Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata8.execute().size(), equalTo(3));
    }

    @Test
    public void testExecuteStructure() {
        List<Map> data = ImmutableList.of(
                ImmutableMap.of("videoId", 70111470, "bookmarkId", 470),
                ImmutableMap.of("videoId", 654356453, "bookmarkId", 453),
                ImmutableMap.of("videoId", 65432445, "bookmarkId", 445));
        Assert.assertThat(Kata8.execute(), equalTo(data));
        System.out.println(Kata8.execute());
    }
}
