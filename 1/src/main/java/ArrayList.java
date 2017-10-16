/**
 * @author karim.essouabni
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

	private Object[] data;

	public ArrayList() throws Exception {
		this(10);
	}

	public ArrayList(int nbrElements) throws Exception {
		if (nbrElements < 0)
			throw new Exception("nbrElements <0");
		data = new Object[nbrElements];

	}

	/*
	 * Ajout de l'element e a la fin de la liste (non-Javadoc)
	 * 
	 * complexité = O(1) en general O(n) si besoin de ajusater la taille du tableau
	 * 
	 * @see List#add(java.lang.Object)
	 */
	public boolean add(E e) {
		if (data.length < this.size() + 1)
			ajusterTailleArray();
		this.data[this.size()] = e;
		return true;
	}

	private void ajusterTailleArray() {

		Object[] dataResized = new Object[data.length + data.length / 2];
		System.arraycopy(data, 0, dataResized, 0, data.length);
		this.data = dataResized;

	}

	/* (non-Javadoc)
	 * Ajout d'un elmeent a une position existante du tableau 
	 * Complexité : O(1) au meilleur des cas si ajout a la fin du tableau (index==size)
	 *  O(n) au pire des cas ajout au tout debut du tableau => deplacement de tous ses elements 
	 *  En generale O(n)
	 * @see List#add(int, java.lang.Object)
	 */
	public void add(int index, E element) throws Exception {
		checkIndex(index);
		ajusterTailleArray();
		System.arraycopy(this.data, index, this.data, index + 1, size() - index); // shift par rapport a
		this.data[index] = element;

	}

	private void checkIndex(int index) throws Exception {
		if (index < 0 || index > data.length)
			throw new Exception("faut index");
	}

	/* (non-Javadoc)
	 * Complexité =  O(1)
	 * @see List#get(int)
	 */
	public E get(int index) throws Exception {
		checkIndex(index);
		return (E) this.data[index];
	}

	/* (non-Javadoc)
	 * @see List#remove(int)
	 * Complexité = O(1) meilleur des cas si suppression de la fin 
	 * O(n) pire des cas si suppression du debut => shit 
	 * En general O(n)
	 */
	public E remove(int index) throws Exception {
		checkIndex(index);
		E toRemove = get(index); // O(1)
		System.arraycopy(this.data, index + 1, this.data, index, size() - index - 1); // shift par rapport a
		this.data[size() - 1] = null;
		return toRemove;
	}

	/* (non-Javadoc)
	 * @see List#remove(java.lang.Object)
	 * Complexité = O(1) ~ O(n) => O(n) en general
	 */
	public boolean remove(Object o) throws Exception {
		for (int i = 0; i < this.data.length; i++) {
			if (o.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see List#size()
	 * Complexité O(n) 
	 */
	public int size() {
		int size = 0;
		for (int i = 0; i < this.data.length; i++)
			if (data[i] != null)
				size++;
		return size;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

}
