import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	@Test
	public void testAdd() throws Exception {
		LinkedList<String> liste = new LinkedList<>();
		liste.add(0, "elem0"); // 2de
		liste.add(1, "elem1"); // 4d
		liste.add(2, "elem2"); /// 5th
		liste.add(0, "elem00"); // 1st
		liste.add(2, "willgetThe3dplace"); // 3th
		Assert.assertEquals(liste.size(), 5);
		Assert.assertEquals(liste.getEntree1().value, "elem00");
		Assert.assertEquals(liste.getEntree1().elemApres.value, "elem0");
		Assert.assertEquals(liste.getEntree1().elemApres.elmAvant.value, "elem00"); // test element avant

		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.value, "willgetThe3dplace");
		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.elemApres.value, "elem1");
		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.elemApres.elemApres.value, "elem2");

	}

	@Test
	public void testGet() throws Exception {

		LinkedList<String> liste = creerLinkedList();

		Assert.assertEquals(liste.get(0), "elem0");
		Assert.assertEquals(liste.get(1), "elem1");
		Assert.assertEquals(liste.get(2), "elem2");
		Assert.assertEquals(liste.get(3), "elem3");
		Assert.assertEquals(liste.get(4), "elem4");

	}

	@Test
	public void testRemove() throws Exception {
		LinkedList<String> liste = creerLinkedList();
		
		Assert.assertEquals(liste.get(4), "elem4");
		Assert.assertEquals(liste.remove(4), "elem4");
		Assert.assertEquals(liste.get(4), null);
		
		Assert.assertEquals(liste.get(0), "elem0");
		Assert.assertEquals(liste.remove(0), "elem0");
		Assert.assertEquals(liste.get(0), "elem1");
		
		Assert.assertEquals(liste.size(), 3);
		
		

	}

	private LinkedList<String> creerLinkedList() throws Exception {
		LinkedList<String> liste = new LinkedList<>();
		liste.add("elem0");
		liste.add("elem1");
		liste.add(2, "elem2");
		liste.add(3, "elem3");
		liste.add(4, "elem4");
		return liste;
	}

}
