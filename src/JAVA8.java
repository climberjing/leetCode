import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by Administrator on 2018/10/7.
 */
public class JAVA8 {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = Integer::parseInt;
        BiPredicate<List<String>,String> contains = List::contains;
        BiPredicate<List<String>,String> contain = List::contains;
    }
}
