import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;


public class AbrTest extends TestCase{

	@Test
	public void testAdd() {
		Abr<Integer> abr = constructAbr();
		
		Assert.assertEquals(abr.noeud1.value, (Integer)15);
		Assert.assertEquals(abr.noeud1.noeudD.value, new Integer(20));
		Assert.assertEquals(abr.noeud1.noeudG.value, (Integer)12);
		Assert.assertEquals(abr.noeud1.noeudD.noeudG.value, (Integer)16);
		Assert.assertEquals(abr.noeud1.noeudG.noeudD.value, (Integer)14);
		Assert.assertEquals(abr.noeud1.noeudG.noeudG.value, (Integer)8);
		Assert.assertEquals(abr.noeud1.noeudD.noeudG.noeudD.value, (Integer)17);
		Assert.assertEquals(abr.size, 11);
	}



	
	@Test 
	public void testGethauteur(){
		Abr<Integer> abr = constructAbr();
		Assert.assertEquals(abr.getHauteur(), 5);
	}

	
	@Test 
	public void testFind(){
		Abr<Integer> abr = constructAbr();
		Assert.assertTrue(abr.find(new Integer(15)));
		Assert.assertTrue(abr.find(new Integer(12)));
		Assert.assertTrue(abr.find(new Integer(21)));
		Assert.assertTrue(abr.find(new Integer(16)));
		Assert.assertTrue(abr.find(new Integer(8)));
		Assert.assertTrue(abr.find(new Integer(20)));
		Assert.assertTrue(abr.find(new Integer(14)));
		Assert.assertTrue(!abr.find(new Integer(240)));
		Assert.assertTrue(!abr.find(new Integer(0)));
		
	}
	
	
	@Test 
	public void testRemove(){
		Abr<Integer> abr = constructAbr();

		// Remove feuille 
		Assert.assertEquals(abr.noeud1.noeudG.noeudG.noeudD.noeudG.value, (Integer)9);
		abr.remove(new Integer(9));
		Assert.assertEquals(abr.noeud1.noeudG.noeudG.noeudD.noeudG, null);
		
		// Removing Noeud with one leaf
		Assert.assertEquals(abr.noeud1.noeudG.noeudG.value, (Integer)8);
		abr.remove(new Integer(8));
		Assert.assertEquals(abr.noeud1.noeudG.noeudG.value, (Integer)10);
		
		//removing First noeud 
		abr.remove(new Integer(15));
		Assert.assertEquals(abr.noeud1.value, (Integer)16);
		Assert.assertEquals(abr.noeud1.noeudD.noeudG.value, (Integer)17);
	}


	@Test 
	public void testParcous() throws Exception{
		Abr<Integer> abr = constructAbr();
		System.out.println("Parcours infixe : ");
		abr.parcoursInfixe();
		System.out.println("\nParcours prefixe : ");
		abr.parcoursPrefixe();
		System.out.println("\nParcours suffixe : ");
		abr.parcoursSuffixe();
		System.out.println("\nParcours Largeur : ");
		abr.parcoursLargeur();
	}

	private Abr<Integer> constructAbr() {
		Abr<Integer> abr = new Abr<>();
		abr.add(new Integer(15));
		abr.add(new Integer(12));
		abr.add(new Integer(20));
		abr.add(new Integer(21));
		abr.add(new Integer(16));
		abr.add(new Integer(8));
		abr.add(new Integer(14));
		abr.add(new Integer(13));
		abr.add(new Integer(17));
		abr.add(new Integer(10));
		abr.add(new Integer(9));
		
		
		return abr;
	}
	
}
