
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;;

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

		LinkedList liste = new LinkedList();
		liste.add(0, "elem0"); // 2de
		liste.add(1, "elem1"); // 4d
		liste.add(2, "elem2"); /// 5th
		liste.add(0, "elem00"); // 1st
		liste.add(2, "willgetThe3dplace");
		System.out.println(liste);

	}

}
