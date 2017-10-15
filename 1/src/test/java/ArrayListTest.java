import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

	@Test
	public void testArrayList() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>();
		ArrayList<String> tabWithSize = new ArrayList<>(40);

		Assert.assertEquals(tabDefault.getData().length, 10);
		Assert.assertEquals(tabWithSize.getData().length, 40);
	}

	@Test
	public void testAdd() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>(2);
		Assert.assertEquals(tabDefault.size(), 0);
		tabDefault.add("karim");
		tabDefault.add("P2");
		Assert.assertEquals(tabDefault.size(), 2);
		tabDefault.add("P3");
		Assert.assertEquals(tabDefault.getData().length, 3); // incrementer la taille de 1/2
		Assert.assertEquals(tabDefault.size(), 3);
	}

	@Test
	public void testAddWithIndex() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>(2);

		tabDefault.add("karim");
		tabDefault.add(1, "karim1");
		Assert.assertEquals(tabDefault.getData()[1], "karim1");
		tabDefault.add(1, "karim11");
		Assert.assertEquals(tabDefault.getData()[1], "karim11");
		Assert.assertEquals(tabDefault.getData()[2], "karim1");
		tabDefault.add(1, "karim111");
		Assert.assertEquals(tabDefault.getData()[1], "karim111");
		Assert.assertEquals(tabDefault.getData()[2], "karim11");
		Assert.assertEquals(tabDefault.getData()[3], "karim1");

		tabDefault = new ArrayList<>(2);
		tabDefault.add("P1");
		tabDefault.add("P2");
		Assert.assertEquals(tabDefault.getData()[1], "P2");
		tabDefault.add(0, "P0");
		Assert.assertEquals(tabDefault.getData()[0], "P0");
		Assert.assertEquals(tabDefault.getData()[2], "P2");
		tabDefault.add(3, "P3");
		Assert.assertEquals(tabDefault.getData()[3], "P3");

	}

	@Test
	public void testGet() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>();

		constructArray(tabDefault);
		Assert.assertEquals(tabDefault.get(0), "P0");
		Assert.assertEquals(tabDefault.get(1), "P1");
		Assert.assertEquals(tabDefault.get(2), "P2");
	}

	@Test
	public void testRemove() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>();

		constructArray(tabDefault);
		tabDefault.remove(0);
		Assert.assertEquals(tabDefault.get(0), "P1");
		Assert.assertEquals(tabDefault.get(2), null);

	}

	@Test
	public void testRemoveObject() throws Exception {
		ArrayList<String> tabDefault = new ArrayList<>();

		constructArray(tabDefault);
		tabDefault.remove("P0");
		Assert.assertEquals(tabDefault.get(0), "P1");
		Assert.assertEquals(tabDefault.get(2), null);

	}

	private void constructArray(ArrayList<String> tabDefault) {
		tabDefault.add("P0");
		tabDefault.add("P1");
		tabDefault.add("P2");
	}

}
