
public interface Map<K, V> {

	V get(Object key);

	V put(K key, V value);

	V remove(Object key);

	int size();
}
