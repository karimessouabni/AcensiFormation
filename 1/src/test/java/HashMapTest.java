import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HashMapTest extends TestCase {

	@Test
	public void testHashMap() throws Exception {

		HashMap<String, String> map = new HashMap<>();
		String key1 = new String("K1");
		String key2 = new String("K2");
		String key3 = new String("K3");
		map.put(key1, "V1");
		map.put(key2, "V2");
		map.put(key3, "V3");
		
		for(int i=0; i<20; i++) {
			
			map.put("k"+i, "v"+i);
		}
		
		
		Assert.assertEquals(map.getBucket().length, 16);

	}

}
