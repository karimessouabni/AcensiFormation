import java.io.File;

/**
 * @author karim
 *
 *         ABR : Def : Un arbre binaire a est un arbre binaire de recherche si,
 *         pour tout nœud s de a, les contenus des nœuds du sous-arbre gauche de
 *         s sont strictement inférieurs au contenu de s, et que les contenus
 *         des nœuds du sous-arbre droit de s sont strictement supérieurs au
 *         contenu de s
 * @param <E>
 */
public class Abr<E extends Comparable<E>> implements IAbr<E> {
	Noeud<E> noeud1;
	int h; // hauteur de l'arbre
	int size; // nombre de noeud;

	public Abr() {

		this.noeud1 = new Noeud<E>(null, null, null);
		this.h = 0;
		size = 0;

	}

	@Override
	public boolean add(E e) {
		if (size() == 0) {
			this.noeud1.value = e;
			size++;
			return true;
		}
		return addR(this.noeud1, e);
	}

	public boolean addR(Noeud<E> n, E e) {

		if (n.value == e) // element deja existant
			return false;
		if (n.value.compareTo(e) > 0) {
			if (n.noeudG != null)
				return addR(n.noeudG, e);
			else {
				n.noeudG = new Noeud<E>(e);
				size++;
				return true;
			}
		} else if (n.value.compareTo(e) < 0) {
			if (n.noeudD != null)
				return addR(n.noeudD, e);
			else {
				n.noeudD = new Noeud<E>(e);
				size++;
				return true;
			}
		} else
			return false;

	}

	public int getHauteur() {
		return this.hauteur(this.noeud1);
	}

	public int hauteur(Noeud<E> n) {
		if (n == null)
			return 0;
		else if (hauteur(n.noeudD) > hauteur(n.noeudG)) {
			return 1 + hauteur(n.noeudD);
		} else
			return 1 + hauteur(n.noeudG);

	}

	@Override
	public boolean find(E e) {
		return recursiveFind(this.noeud1, e);
	}

	public boolean recursiveFind(Noeud<E> n, E e) {
		if (e.compareTo(n.value) == 0)
			return true;
		else if (e.compareTo(n.value) > 0) { // chercher dans le s-ABRD
			if (n.noeudD != null)
				return recursiveFind(n.noeudD, e);
			return false;
		} else {
			if (n.noeudG != null)
				return recursiveFind(n.noeudG, e);
			return false;
		}
	}

	@Override
	public boolean remove(E e) {
		noeud1 = recursiveRemove(noeud1, e);
		return true;
	}

	public Noeud<E> recursiveRemove(Noeud<E> n, E e) {
		if (n == null)
			return n;
		if (e.compareTo(n.value) == 0)
			return removeNoeud(n);
		if (e.compareTo(n.value) < 0)
			n.noeudG = recursiveRemove(n.noeudG, e);
		else
			n.noeudD = recursiveRemove(n.noeudD, e);
		return n;
	}

	public Noeud<E> removeNoeud(Noeud<E> n) {
		// 1 : si n a au plus 1 S-noeud G/D
		if (n.noeudG == null)
			return n.noeudD; // return null si feuille (ND == null aussi)
		else if (n.noeudD == null)
			return n.noeudG;// return null si feuille (NG == null aussi)
		// 2 : si n a deux S-noeud G D: on a donc le choix de prendre un
		// remplacant du S-arbreG ou S-arbreD

		else {
			Noeud<E> tete = findRemplacant(n.noeudD);

			n.value = tete.value; // on remplace juste la valeur on supprime le
									// remplacant apres
			n.noeudD = recursiveRemove(n.noeudD, tete.value); // suppresstion du
																// noeud
																// remplacant
			return n;
		}
	}

	/**
	 * DGGG ou GDDD pour trouver un remplacant qui respecte l'ABR
	 * 
	 * @param n
	 * @return
	 */
	public Noeud<E> findRemplacant(Noeud<E> n) {
		if (n.noeudG != null)
			return findRemplacant(n.noeudG);
		return n;

	}

	public void parcoursInfixe() {

		parcoursInfixe(this.noeud1);
	}

	public void parcoursPrefixe() {

		parcoursPrefixe(this.noeud1);
	}

	public void parcoursSuffixe() {

		parcoursSuffixe(this.noeud1);
	}

	public void parcoursPrefixe(Noeud<E> n) {
		if (n == null)
			return;
		System.out.print(n.value + " ");
		parcoursPrefixe(n.noeudG);// return ramene ici
		parcoursPrefixe(n.noeudD);
	}

	public void parcoursInfixe(Noeud<E> n) {
		if (n == null)
			return;
		parcoursInfixe(n.noeudG);
		System.out.print(n.value + " ");// return ramene ici
		parcoursInfixe(n.noeudD);
		// ou ici
	}

	public void parcoursSuffixe(Noeud<E> n) {
		if (n == null)
			return;
		parcoursSuffixe(n.noeudG);
		parcoursSuffixe(n.noeudD);
		System.out.print(n.value + " ");
	}

	public void parcoursLargeur() throws Exception {
	
		ArrayList<Noeud<E>> tab = new ArrayList<>(); // FIFO
		tab.add(this.noeud1);
		while(tab.size()>0){
			Noeud<E> n = tab.get(0);
			tab.remove(0);
			System.out.print(n.value+ " ");
			if(n.noeudG != null ) tab.add(n.noeudG);
			if(n.noeudD != null ) tab.add(n.noeudD);
		}
		
		
		
	}

	public int size() {
		return size; // size de l'arbre a partire du noeud 1(tete de
						// l'arbre)
	}

	static class Noeud<E> {

		E value;
		Noeud<E> noeudG;
		Noeud<E> noeudD;

		public Noeud(E value) {
			this.value = value;
			this.noeudD = null;
			this.noeudG = null;
		}

		public Noeud(Noeud<E> noeudG, E value, Noeud<E> noeudD) {
			super();
			this.value = value;
			this.noeudG = noeudG;
			this.noeudD = noeudD;
		}

		//
		public String toStringS() {
			String gStr = (noeudG != null && noeudG.value != null ? noeudG.value
					+ ""
					: "");
			String dStr = (noeudD != null && noeudD.value != null ? noeudD.value
					+ ""
					: "");
			return gStr + "-[" + value + "]-" + dStr;

		}

		
		
	
		
		@Override
		public String toString() {
			if (value == null)
				return " ABR vide ";

			String res = value.toString() + " ";
			if (noeudG != null || noeudD != null) {
				res += "(";
				if (noeudG != null) {
					res += noeudG.toString() + " ";
				}
				if (noeudD != null) {
					res += noeudD.toString();
				}
				res += ")";
			}
			return res;
		}
		// public int size() {
		// if (this == null)
		// return 0;
		// return 1 + noeudG.size() + noeudD.size();
		// }

	}

}
