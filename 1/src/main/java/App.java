
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ArrayList a = new ArrayList(2);
		a.add(0, "karim");
		a.add(1, "object1");
		a.add(2, "object2");

		System.out.println(a);
		a.remove("object1");
		System.out.println(a);

		Map<String, String> map = new HashMap<>();

		String key1 = new String("K1");
		String key2 = new String("K1");
		String key3 = new String("K1");
		map.put(key1, "V1");
		map.put(key2, "V2");
		map.put(key3, "V3");

		map.put("j", "java");
		map.put(null, "c++");
		map.put(null, "C");

		map.put("p", "python");
		map.put("j", "java");
		String valeur = new String("AA");

		LinkedList l = new LinkedList();
		l.add("01");
		l.add("02");
		l.add(null);
		System.out.println(l);

	}

}
