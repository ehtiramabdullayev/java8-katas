package katas;

import katas.kata.Kata6;
import org.junit.Assert;
import org.junit.Test;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.equalTo;


public class Kata6Test {

    @Test
    public void testExecuteStructure() {
        Assert.assertThat(Kata6.execute(),
                equalTo(Optional.of("http://cdn-0.nflximg.com/images/2891/Fracture300.jpg").get()));
        System.out.println(Kata6.execute());
    }
}