import java.util.Collection;
import java.util.Iterator;

public interface List<E> {
	
	boolean add(E e) ;
	void add(int index, E element) ;
	boolean addAll(Collection<? extends E> c) ; 
	boolean addAll(int index, Collection<? extends E> c) ; 
	void clear(); 
	boolean contains(Object o) ;
	boolean equals(Object o) ;
	E get(int index) ;
	int indexOf(Object o) ;
	boolean isEmpty() ;
	Iterator<E> iterator() ;
	E remove(int index)  ;
	boolean remove(Object o)  ;
	boolean removeAll(Collection<?> c) ;
	boolean retainAll(Collection<?> c)  ; 
	E set(int index, E element) ; 
	int size() ; 
	List<E> subList(int fromIndex, int toIndex) ;
	Object[] toArray() ;
	<T> T[] toArray(T[] a);
	
	

}
