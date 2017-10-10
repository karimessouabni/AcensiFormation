public interface List<E> {
	
	boolean add(E e) ;
	void add(int index, E element)throws Exception  ;
	void clear(); 
	E get(int index) throws Exception ;
	E remove(int index) throws Exception  ;
	boolean remove(Object o)  ;
	int size();
}
