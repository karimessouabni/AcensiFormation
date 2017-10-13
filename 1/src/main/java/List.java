public interface List<E> {
	
	boolean add(E e) throws Exception ;
	void add(int index, E element)throws Exception  ;
	E get(int index) throws Exception ;
	E remove(int index) throws Exception  ;
	boolean remove(Object o) throws Exception  ;
	int size();
}
