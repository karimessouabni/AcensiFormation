
public class HashMap<K, V> implements Map<K, V> {

	private Bucket[] bucket; // tableau de linkedList d'objet Entree ( key value hashKey and next )
								// bucket[i] contient une list de linkedList
	private int size; // le nombre des (k,V) dans la hashmap
	private static final float loadVariance = 0.75f;

	public HashMap() throws Exception {
		this(16);
	}

	public HashMap(int nbrElements) throws Exception {
		if (nbrElements < 0)
			throw new Exception("nbrElements <0");
		bucket = new Bucket[nbrElements];

	}

	@Override
	public V get(Object key) {
		if (key != null) {
			int hash = hash(key.hashCode());
			int index = indexFor(hash);
			for (Bucket<K, V> entree = this.bucket[index]; entree != null; entree = entree.next) {
				if (key.equals(entree.key)) {
					return entree.value;
				}

			}

		}
		return null;
	}

	@Override
	public V put(K key, V value) {

		int hash = hash(key.hashCode());
		int bucketIndex = indexFor(hash);

		Bucket<K, V> entree = this.bucket[bucketIndex];
		// 1 chercher si la clé exite deja dans le bucket associé
		while (entree != null) {
			// element de
			// la linkedlist
			if (key.equals(entree.key)) { // key deja existant dans la linkedList/bucket
				V returnValue = entree.value;
				entree.value = value;
				return returnValue;
			}
			entree = entree.next; // next element of the Bucket
		}
		entree = this.bucket[bucketIndex];
		// 2 ajout d'une nouvelle entrée(K,V) dans le Bucket concerné
		this.bucket[bucketIndex] = new Bucket<K, V>(key, value, entree, hash); // decalage du Bucket avec la nouvel
																				// (K,V)
		// ajouter au debut
		if (this.size++ >= (int) (this.bucket.length * loadVariance)) {

			Bucket<K, V>[] newBucket = new Bucket[this.bucket.length * 2];// doubler la taille du Bucket
			for (int i = 0; i < this.bucket.length; i++) { // parcourir l'ancien bucket pour le transferer dans le
															// nouveau
				Bucket<K, V> newElemBucket = this.bucket[i]; // transferer le premier element du Buket
				if (newElemBucket != null) {
					// this.bucket[i] = null;
					do {
						Bucket<K, V> next = newElemBucket.next;
						int bucketIndx = indexFor(newElemBucket.hash, newBucket.length); // nouveau index pour le
																							// nouveau Bucket
						newElemBucket.next = newBucket[i]; // decalage de la valeur deja existante ( decalage du null
															// pour le premier passage) -> la linkedList doit pointer
															// sur un null au final
						newBucket[i] = newElemBucket;

						newElemBucket = next; // passage au prochain
					} while (newElemBucket != null);

				}

			}
			this.bucket = newBucket;// affectation du newBucket resizer

		}
		return null; // no previous mapping with the key

	}

	@Override
	public V remove(Object key) {

		if (key != null) {
			int hash = hash(key.hashCode());
			int index = indexFor(hash);
			int i = 0;
			Bucket<K, V> prev = this.bucket[index];
			Bucket<K, V> elem = this.bucket[index];
			while (elem != null) { // si on n'est pas a la fin de la linkedList

				if (elem.key.equals(key)) {
					if (i == 0) { // element tout au debut de la linkedList
						this.bucket[index] = elem.next;
					} else
						prev.next = elem.next;
					--size;
					return elem.value;

				} else {
					prev = elem;
					elem = elem.next;

				}
				++i;
			}

		}
		return null;

	}

	@Override
	public int size() {
		return size;
	}

	static class Bucket<K, V> {
		K key;
		V value;
		Bucket<K, V> next; // linkedlist
		final int hash;

		Bucket(K key, V value, Bucket<K, V> n, int h) {
			this.key = key;
			this.value = value;
			this.next = n;
			this.hash = h; // pour garder en memoire lors du transfer ( la fonction du calcul d'index a
							// partir du hash change suite au changement de la taille)
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * @param h
	 *            : la valaue key hashé
	 * @return une valauer entre 0 et la taille du data[] deux Key qui ont la meme
	 *         valeur du hashCode auront egalement le meme index sur le tableau de
	 *         linkedList
	 */
	int indexFor(int h) {
		return h & (this.bucket.length - 1);
	}

	int indexFor(int h, int taille) {
		return h & (taille - 1);
	}

	public Bucket[] getBucket() {
		return bucket;
	}

	public void setBucket(Bucket[] bucket) {
		this.bucket = bucket;
	}

}
