
public class LinkedList<E> implements List<E> {

	private Entree<E> entree1 ;
	private int size;

	public LinkedList() {
		this.size = 0;
		entree1 = new Entree<E>(null, null, null);
	}

	/* (non-Javadoc)
	 * @see List#add(java.lang.Object)
	 * 
	 * Complextié = O(n) = Ajout a la fin 
	 * A change pour O(1) Ajout au debut de la linkedList....
	 */
	@Override
	public boolean add(E e) throws Exception {
		this.add(size, e);
		return true;
	}

	/* (non-Javadoc)
	 * @see List#add(int, java.lang.Object)
	 * 
	 * Complexité entre O(1) et O(n)==complexité du get
	 */
	@Override
	public void add(int index, E element) throws Exception {
		Entree<E> refElem = entree1;
		if (index > size || index < 0) {
			throw new Exception("faux index !!");
		} else if (index == 0) { // ajout au debut refElem = premier -> le plus optimal O(1)
			Entree<E> nouvellEntree = new Entree<E>(element, entree1, null);
			refElem.elmAvant = nouvellEntree;
			entree1 = nouvellEntree;
			size++;

		} else { // ajout a la fin refElem = dernier
			Entree<E> elemApres =  getElem(index) ; 
			Entree<E> elemAvant = getElem(--index) ; 
			
			
			Entree<E> nouvellEntree = new Entree<E>(element, elemApres, elemAvant);
			elemAvant.elemApres = nouvellEntree ; 
			elemApres.elmAvant = nouvellEntree;
			size++;
		}

	}

	/* (non-Javadoc)
	 * @see List#get(int
	 * Complexité = O(n) 
	 */
	@Override
	public E get(int index) throws Exception {
		Entree<E> refElem = entree1;
		while (--index >= 0) {
			refElem = refElem.elemApres;
		}
		return refElem.value;
	}

	public E getWithRecursivite(int index) throws Exception {
		return this.getForRecursive(index,entree1 );
	}
	
	public E getForRecursive(int index, Entree<E> refElem) throws Exception {
		if(index==0)
			return refElem.value;
		return getForRecursive(--index, refElem.elemApres);
	}
	
	/**
	 * @param index
	 * @return
	 * @throws Exception
	 * Complexité = O(n) en generale = pire des cas 
	 */
	public Entree<E> getElem(int index) throws Exception {
		Entree<E> refElem = entree1;
		while (--index >= 0) {
			refElem = refElem.elemApres;
		}
		return refElem;
	}

	/* (non-Javadoc)
	 * @see List#remove(int)
	 * Complexité = O(1) si index ==0 O(n) en generale 
	 * O(n) depuis le get 
	 */
	@Override
	public E remove(int index) throws Exception {
		Entree<E> refElem = entree1;
		Entree<E> valToreturn = null;
		if (index > size || index < 0) {
			throw new Exception("faux index !!");
		} else if (index == 0) {
			valToreturn = entree1 ; 
			entree1.elemApres.elmAvant = null;
			entree1 = entree1.elemApres;
			size--;
			return valToreturn.value;
		} else {
			refElem = getElem(index);
			valToreturn = refElem; 
			refElem.elmAvant.elemApres = refElem.elemApres;
			refElem.elemApres.elmAvant = refElem.elmAvant;
			refElem.elemApres = null;
			refElem.elmAvant = null;
			size--;
			return valToreturn.value;
		}
	}

	@Override
	public boolean remove(Object o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	static class Entree<E> {

		E value;
		Entree<E> elmAvant;
		Entree<E> elemApres;

		Entree(E elem, Entree<E> elemApres, Entree<E> elmAvant) {

			this.value = elem;
			this.elmAvant = elmAvant;
			this.elemApres = elemApres;
		}

	}

	public Entree<E> getEntree1() {
		return entree1;
	}

	public void setEntree1(Entree<E> entree1) {
		this.entree1 = entree1;
	}

}
