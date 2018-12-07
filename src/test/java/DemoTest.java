import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hanlipeng
 * @date 2018/10/23
 */
public class DemoTest {
    public static void main(String[] args) {
        ArrayList<Object> collect = Stream.of(new String[]{"2", "2"}, new String[]{"2", "2"}, new String[]{"3", "2"})
                .collect(
                        ArrayList::new,
                        (x, l) -> {
                            TestObject t = new TestObject();
                            x.add(t);
                            t.key = l[0];
                            t.value = new LinkedList<>();
                            t.value.add(l[1]);
                        },
                        (t, l) -> {

                        }
                );
        System.out.println(collect);
    }

    static class TestObject {
       public String key;
       public List<String> value;

        public TestObject() {

        }
    }
}
