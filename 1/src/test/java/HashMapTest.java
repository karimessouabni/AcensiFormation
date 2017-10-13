import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HashMapTest extends TestCase {

	/**
	 * Test Put
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPut() throws Exception {

		HashMap<String, String> map = ConstructMap();

		Assert.assertEquals(map.getBucket().length, 16); // test sur la taille initial

		for (int i = 0; i < 20; i++) {

			map.put("k" + i, "v" + i);
		}

		Assert.assertEquals(map.getBucket().length, 32); // tailole doublée du map suite au depassage de nombre des
															// elements contenus à 0.75*size
		Assert.assertEquals(map.size(), 23);

	}

	@Test
	public void testGet() throws Exception {
		HashMap<String, String> map = ConstructMap();

		Assert.assertEquals(map.get("K1"), "V1");
		Assert.assertEquals(map.get("K3"), "V3");
	}

	@Test
	public void testRemove() throws Exception {
		HashMap<String, String> map = ConstructMap();
		for (int i = 0; i < 30; i++) {
			map.put("K" + i, "V" + i);
		}
		
		Assert.assertEquals(map.remove("K1"), "V1");
		Assert.assertEquals(map.remove("K3"), "V3");
		Assert.assertEquals(map.remove("K2"), "V2");
		Assert.assertEquals(map.remove("K28"), "V28");
		Assert.assertEquals(map.remove("K0"), "V0");
		Assert.assertEquals(map.remove("K29"), "V29");

	}

	private HashMap<String, String> ConstructMap() throws Exception {
		// pas de gestion des key null...
		HashMap<String, String> map = new HashMap<>();
		map.put("K1", "V1");
		map.put("K2", "V2");
		map.put("K3", "V3");
		return map;
	}

}
