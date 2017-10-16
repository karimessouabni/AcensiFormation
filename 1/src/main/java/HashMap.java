import java.util.Arrays;

public class HashMap<K, V> implements Map<K, V> {

	private Bucket[] listBuckets; // tableau de linkedList d'objet Entree ( key value hashKey and next )
									// bucket[i] contient une list de linkedList
	private int size; // le nombre des (k,V) dans la hashmap
	private static final float loadVariance = 0.75f;

	public HashMap() throws Exception {
		this(16);
	}

	public HashMap(int nbrElements) throws Exception {
		if (nbrElements < 0)
			throw new Exception("nbrElements <0");
		listBuckets = new Bucket[nbrElements];

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Map#get(java.lang.Object) Complexité = O(1) si pas de collision sur les
	 * bucket O(n)
	 */
	@Override
	public V get(Object key) {
		if (key != null) {
			int hash = hash(key.hashCode());
			int index = indexFor(hash);
			for (Bucket<K, V> entree = this.listBuckets[index]; entree != null; entree = entree.next) {
				if (key.equals(entree.key)) {
					return entree.value;
				}

			}

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Map#put(java.lang.Object, java.lang.Object) O(1) à  ( O (2n) ~ O(n) )
	 */
	@Override
	public V put(K key, V value) {

		int hash = hash(key.hashCode());
		int bucketIndex = indexFor(hash);

		Bucket<K, V> entree = this.listBuckets[bucketIndex];
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
		} // O(n) au pire des cas jusqu'a ici 
		entree = this.listBuckets[bucketIndex]; // entree point sur le bucket qui ne contient pas value
		// 2 ajout d'une nouvelle entrée(K,V) dans le Bucket concerné
		// ajouter au debut
		this.listBuckets[bucketIndex] = new Bucket<K, V>(key, value, entree, hash); // decalage du Bucket avec la nouvel
		// (K,V) -> entree

		// resize de la taille du Bucket si besoin et recalcule des hash de tout ses
		// elements
		if (this.size++ >= (int) (this.listBuckets.length * loadVariance)) {

			Bucket<K, V>[] newListeBuckets = new Bucket[this.listBuckets.length * 2];// doubler la taille de la liste des Buckets
			for (int i = 0; i < this.listBuckets.length; i++) { // parcourir tous les buckets de la HashMap pour un
																// recalcule de hash et une nouvelle redistribution sur
																// l'enemble des buckets

				Bucket<K, V> elemBucket = this.listBuckets[i]; // premier element de chaque Bucket
				if (elemBucket != null) { // parcourir tous les elements d'un bucket
					// this.bucket[i] = null;
					do {
						Bucket<K, V> next = elemBucket.next;
						int bucketIndx = indexFor(elemBucket.hash, newListeBuckets.length); // nouveau index pour chaque
																							// element du bucket
						elemBucket.next = newListeBuckets[bucketIndx]; // decalage de la valeur deja existante ( decalage du null
															// pour le premier passage) -> la linkedList doit pointer
															// sur un null au final
						newListeBuckets[bucketIndx] = elemBucket;

						elemBucket = next; // passage au prochain
					} while (elemBucket != null);

				}

			}
			
			// O(1) ~ O(n)
			this.listBuckets = newListeBuckets;// affectation du newBucket resizer

		}
		return null; // no previous mapping with the key

	}

	@Override
	public V remove(Object key) {

		if (key != null) {
			int hash = hash(key.hashCode());
			int index = indexFor(hash);
			int i = 0;
			Bucket<K, V> prev = this.listBuckets[index];
			Bucket<K, V> elem = this.listBuckets[index];
			while (elem != null) { // si on n'est pas a la fin de la linkedList

				if (elem.key.equals(key)) {
					if (i == 0) { // element tout au debut de la linkedList
						this.listBuckets[index] = elem.next;
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

		@Override
		public String toString() {
			return "Bucket [key=" + key + ", value=" + value + ", next=" + next + "]";
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
		return h & (this.listBuckets.length - 1);
	}

	int indexFor(int h, int taille) {
		return h & (taille - 1);
	}

	public Bucket[] getBucket() {
		return listBuckets;
	}

	public void setBucket(Bucket[] bucket) {
		this.listBuckets = bucket;
	}

	@Override
	public String toString() {
		return "HashMap [listBuckets=" + Arrays.toString(listBuckets) + "]";
	}
	
	
	
	

}
