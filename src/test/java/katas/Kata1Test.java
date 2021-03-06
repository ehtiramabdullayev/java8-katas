package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.kata.Kata1;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata1Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata1.execute().size(), equalTo(4));
    }
    @Test
    public void testExecuteStructure() {
        List<Map> data = ImmutableList.of(
                ImmutableMap.of("id", 70111470, "title", "Die Hard"),
                ImmutableMap.of("id", 654356453, "title", "Bad Boys"),
                ImmutableMap.of("id", 65432445, "title", "The Chamber"),
                ImmutableMap.of("id", 675465, "title", "Fracture")
        );
        Assert.assertThat(Kata1.execute(), equalTo(data));
        System.out.println(Kata1.execute());
    }
}
