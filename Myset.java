public class Myset<X>{
 protected MyLinkedList<X> set = new MyLinkedList ();
	public Myset(){
		
	}
	public MyLinkedList<X> getMyLinkedList(){
		return set;
	}
	
	public boolean isEmpty(){
		return set.isEmpty();
	}
	
	public boolean IsMember(X o){
		return set.IsMember(o);
	}
	
	public void Insert(X o){
		if(!IsMember(o))
		set.addFirst(o);
		
	}
	public int Size (){
		return set.size();
	}
	
	public void Delete(X o) throws Exception{
		set.remove(o);
	}
	public X getElementati(int i) {
		return set.getElementati(i);
	}
	public Myset<X> Union(Myset<X> a){
		Myset<X> newset = new Myset();
		//newset=a;
		for(int i=1;i<=a.Size();i++)
				newset.Insert(a.set.getElementati(i));
		for(int i=1;i<=set.size();i++)
		{
			if(!a.IsMember(set.getElementati(i))){
				newset.Insert(set.getElementati(i));
			}
		}
		return newset;
			}
			
	public Myset<X> Intersection(Myset<X> a){
		Myset<X> newset = new Myset();
		//newset=this;
		/*for(int i=1;i<=a.Size();i++)
				newset.Insert(a.set.getElementati(i));
		for(int i=1;i<=a.set.size();i++)
		{  try{if(!this.IsMember(a.set.getElementati(i))){
				newset.Delete(a.set.getElementati(i));
			}}
			catch(Exception e){
				System.out.println("Exception in delete");
			}*/
		
			
		for(int i=1;i<=a.Size();i++)
			if(this.IsMember(a.set.getElementati(i)))
				newset.Insert(a.set.getElementati(i));
		return newset;
			}
/*	public static void main ( String args []) throws Exception{
		Myset<Integer> a= new Myset();
          a.Insert(4);
          a.Insert(5);
			a.Insert(6);
			a.Insert(11);
		Myset<Integer> b= new Myset();
		b.Insert(4);
          b.Insert(7);
			b.Insert(8);
			b.Insert(9);
			b.Insert(15);
			b.Insert(11);
			System.out.println(a.IsMember(6));
		a.Delete(4);
		System.out.println(a.IsMember(4));
		Myset<Integer> d= new Myset();
		d.Insert(6);
          d.Insert(18);
			d.Insert(9);
			d.Insert(8);
			d.Insert(25);
			d.Insert(11);
		Myset<Integer> c= b.Intersection(a);
			System.out.println(c.IsMember(6));
		for(int i=1;i<=c.Size();i++)
			System.out.println(c.getElementati(i));
		System.out.println("changed");
		c=c.Intersection(d);
		for(int i=1;i<=a.Size();i++)
			System.out.println(a.getElementati(i));
		System.out.println("changed");
		for(int i=1;i<=b.Size();i++)
			System.out.println(b.getElementati(i));
		System.out.println("changed");
		for(int i=1;i<=c.Size();i++)
			System.out.println(c.getElementati(i));
		System.out.println("changed");
		for(int i=1;i<=d.Size();i++)
			System.out.println(d.getElementati(i));
	}*/}