import java.util.LinkedList;


public class MySet<X> {                       //defined generic class
	LinkedList<X> set = new LinkedList<X>();      
	
	public void addElement(X element)
	{
		set.add(element);
	}
	public MySet<X> union(MySet<X> otherSet)
	{
		if(this!=null && otherSet==null)
		{
			return this;
		}
		else
		{
			MySet<X> temp1 = new MySet<X>();
			temp1.set=this.set;
			for(int i=0; i<otherSet.set.size(); i++)
			{
				if(this.set.contains(otherSet.set.get(i)))
				{
					
				}
				else
					temp1.set.add(otherSet.set.get(i));
			}
			return temp1;
		}
	}
	
	public MySet<X> intersection(MySet<X> otherSet)
	{
		if(this==null || otherSet==null)
		{
			return null;
		}
		else
		{
			MySet<X> temp2 = new MySet<X>();
			for(int i=0; i<otherSet.set.size(); i++)
			{
				if(this.set.contains(otherSet.set.get(i)))
					temp2.set.add(otherSet.set.get(i));
			}
		return temp2;
		}
	}
	public boolean isMember(X element) {
		return set.contains(element);
		
	}
	public boolean isEmpty() {
		
		return set.isEmpty();
	}
	public int size()
	{
		return set.size();
	}
	public X get(int i) {
		
		return set.get(i);
	}
}
