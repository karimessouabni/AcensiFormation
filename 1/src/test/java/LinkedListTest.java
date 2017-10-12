import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	@Test
	public void test() throws Exception {
		LinkedList<String> liste = new LinkedList<>();
		liste.add(0, "elem0"); //2de
		liste.add(1, "elem1"); //4d
		liste.add(2, "elem2"); ///5th
		liste.add(0, "elem00"); //1st
		liste.add(2, "willgetThe3dplace"); //3th
		Assert.assertEquals(liste.size(), 5);
		Assert.assertEquals(liste.getEntree1().value, "elem00");
		Assert.assertEquals(liste.getEntree1().elemApres.value, "elem0");
		Assert.assertEquals(liste.getEntree1().elemApres.elmAvant.value, "elem00"); // test element avant 
		
		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.value, "willgetThe3dplace");
		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.elemApres.value, "elem1");
		Assert.assertEquals(liste.getEntree1().elemApres.elemApres.elemApres.elemApres.value, "elem2");
		
		
	}

}
