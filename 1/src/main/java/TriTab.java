
public interface TriTab {

	/**
	 * O(n^2) pire des cas O(n) meilleur des cas
	 * 
	 * @param <E
	 *            extends Comparable>
	 * 
	 * @throws Exception
	 */
	public static <E extends Comparable> void triAbulle(ArrayList<E> tabDefault) throws Exception {

		for (int i = tabDefault.size() - 1; i > 0; i--) {
			boolean tabTrie = true;
			for (int j = 0; j < i; j++) {
				E swap = tabDefault.get(j);
				if (tabDefault.get(j + 1).compareTo(swap) < 0) {
					tabDefault.getData()[j] = tabDefault.get(j + 1);
					tabDefault.getData()[j + 1] = swap;
					tabTrie = false;
				}

			}
			if (tabTrie)
				break;
		}

	}

	/**
	 * complexité de n(n-1)/2 -> O(n^2) environ
	 * 
	 * @throws Exception
	 */
	public static <E extends Comparable> void triParselection(ArrayList<E> tabDefault) throws Exception {

		for (int i = 0; i < tabDefault.size(); i++) {
			E min = tabDefault.get(i);

			for (int j = i + 1; j < tabDefault.size(); j++) {
				E elem = tabDefault.get(j);
				if (elem.compareTo(min) < 0) {
					tabDefault.getData()[i] = elem;
					tabDefault.getData()[j] = min;
					min = elem;
					continue;
				}

			}

		}

	}

	/**
	 * O(n^2) a O(n) si le tab est deja trtié
	 * 
	 * @param tabDefault
	 * @throws Exception
	 */
	public static <E extends Comparable> void triParInsertion(ArrayList<E> tabDefault) throws Exception {

		for (int i = 0; i < tabDefault.size(); i++) {
			E elm = tabDefault.get(i);
			int j = i - 1;
			while (j >= 0 && tabDefault.get(j).compareTo(elm) > 0) {
				tabDefault.getData()[j + 1] = tabDefault.get(j);
				j--;
			}
			tabDefault.getData()[j + 1] = elm;

		}

	}

	
	/**
	 * @param tab
	 * @throws Exception
	 * Complexite pire des cas O(n^2) et meilleur des cas O(nlogn)
	 */
	public static <E extends Comparable> void triRapid(ArrayList<E> tab) throws Exception {

		triRapideFunc(tab, 0, tab.size() - 1);

	}

	public static <E extends Comparable> void triRapideFunc(ArrayList<E> tableau, int début, int fin) throws Exception {
		if (début < fin) {
			int indicePivot = partition(tableau, début, fin);
			triRapideFunc(tableau, début, indicePivot - 1);
			triRapideFunc(tableau, indicePivot + 1, fin);
		}
	}

	public static <E extends Comparable> int partition(ArrayList<E> t, int start, int end) throws Exception {
		E valeurPivot = t.get(start);
		int d = start + 1;
		int f = end;
		while (d < f) {
			while (d < f && t.get(f).compareTo(valeurPivot) >= 0)
				f--;
			while (d < f && t.get(d).compareTo(valeurPivot) <= 0)
				d++;
			E temp = t.get(d);
			t.getData()[d] = t.get(f);
			t.getData()[f] = temp;
		}
		if (t.get(d).compareTo(valeurPivot) > 0)
			d--;
		t.getData()[start] = t.get(d);
		t.getData()[d] = valeurPivot;
		return d;
	}
	
	

	/**
	 * @param tab
	 * Complexité pareil que le tri rapide
	 */
	public static <E extends Comparable> void triFusion(java.util.ArrayList<E> tab)  {

		triFusionFunc(tab, 0, tab.size() - 1);

	}
	
	public static <E extends Comparable> void triFusionFunc (java.util.ArrayList<E> tab, int début, int fin)
	{
		int milieu;
		if(début < fin)
		{
			milieu = (début+fin) / 2;
			triFusionFunc(tab, début, milieu);
			triFusionFunc(tab, milieu + 1, fin);
			fusionner (tab, début, milieu, fin);
		}
	}
	
	
	public static  <E extends Comparable>  void fusionner (java.util.ArrayList<E>  tab, int début, int milieu, int fin)
	{
		java.util.ArrayList<E> old_tab = (java.util.ArrayList<E>) tab.clone(); 

		int i1 = début; //indice dans la première moitié de old_tab
		int i2 = milieu + 1; // indice dans la deuxième moitié de old_tab
		int i = début; //indice dans le tableau tab

		while (i1 <= milieu && i2 <= fin)
		{
			// la plus petite tête de liste?
			if(old_tab.get(i1).compareTo( old_tab.get(i2))<=0)
			{
				tab.set(i, old_tab.get(i1)) ;
				i1++;
			}
			else
			{
				tab.set(i, old_tab.get(i2)) ;
				i2++;
			}
			i++;
		}
		if (i <= fin)
		{
			while(i1 <= milieu)  // le reste de la première moitié
			{
				tab.set(i, old_tab.get(i1)) ;
				i1++;
				i++;
			}
			while(i2 <= fin) // le reste de la deuxième moitié
			{
				tab.set(i, old_tab.get(i2)) ;
				i2++;
				i++;
			}
		}
	}
	
	

}
