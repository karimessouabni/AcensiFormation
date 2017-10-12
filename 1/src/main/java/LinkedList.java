
public class LinkedList<E> implements List<E> {

	
	 private  Entree<E> entree1 = new Entree<E>(null, null, null);
	 private int size ;
	 
	 
	 
	 
	public LinkedList() {
//		entree1.elmAvant = entree1.elemApres = entree1;
		this.size = 0 ; 
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, E element) throws Exception {
		Entree<E> refElem = entree1; 
		if (index>size || index <0)  {
			throw new Exception("faux index !!");
		}else if (index == 0) { // ajout au debut  refElem = premier 
			Entree<E> nouvellEntree = new Entree<E>(element, entree1, null);
			refElem.elmAvant = nouvellEntree ;
			entree1 = nouvellEntree ;
			size++;
			
		}else  { // ajout a la fin refElem = dernier
			
			while( --index > 0 ) {
				refElem = refElem.elemApres;
			}
			Entree<E> nouvellEntree = new Entree<E>(element, refElem.elemApres, refElem);
			refElem.elemApres = nouvellEntree;
			size++ ;
		} 
		
	}

	@Override
	public E get(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		
		E value ;
		Entree<E> elmAvant ; 
		Entree<E> elemApres ; 
		
		
		Entree(E elem, Entree<E> elemApres, Entree<E> elmAvant) {
			
			this.value = elem ; 
			this.elmAvant = elmAvant ;
			this.elemApres = elemApres ;
		}
		
	}


	public Entree<E> getEntree1() {
		return entree1;
	}

	public void setEntree1(Entree<E> entree1) {
		this.entree1 = entree1;
	}


	
	
}
