import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
	 * @see List#add(java.lang.Object)
	 */
	public boolean add(E e) {
		ajusterTailleArray();
		this.data[this.size()] = e;
		return true;
	}

	private void ajusterTailleArray() {
		if (data.length < this.size() + 1) {
			Object[] dataResized = new Object[data.length + data.length / 2];
			System.arraycopy(data, 0, dataResized, 0, data.length);
			this.data = dataResized;
		}
	}

	public void add(int index, E element) throws Exception {
		checkIndex(index);
		ajusterTailleArray();
		System.arraycopy(this.data, index, this.data, index + 1, size() - index); // shift par rapport a
		this.data[index] = element;

	}

	private void checkIndex(int index) throws Exception {
		if (index <0 || index > data.length)
			throw new Exception("faut index");
	}

	public void clear() {
		
	}

	public E get(int index) throws Exception {
		checkIndex(index);
		return (E) this.data[index];
	}

	public E remove(int index) throws Exception {
		checkIndex(index);
		return null;
	}

	public boolean remove(Object o) {
		return false;
	}

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
