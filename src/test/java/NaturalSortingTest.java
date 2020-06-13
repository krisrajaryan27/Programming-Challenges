import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NaturalSortingTest {
    @Test
    public void intSort() {
        int[] num = {-3, -5, 1, 7, 4, -2};
        int[] expected = {-5, -3, -2, 1, 4, 7};
        Arrays.sort(num);
        Assert.assertArrayEquals(num, expected);

    }

}
