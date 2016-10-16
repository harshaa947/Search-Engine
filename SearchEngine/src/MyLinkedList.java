import java.util.LinkedList;


public class MyLinkedList<X> {
	public LinkedList<X> list = new LinkedList<X>();
	
	public void add(X element)
	{
		this.list.add(element);
	}
	public void remove(X element)
	{
		this.list.remove(element);
	}
	public void extend(MyLinkedList<X> list)
	{
		for(int i=0; i<list.size(); i++)
		{
			this.add(list.get(i));
		}
	}
	public int size()
	{
		return this.list.size();
	}
	public X get(int i)
	{
		return this.list.get(i);
	}
	public boolean contains(X element)
	{
		return this.list.contains(element);
	}
}
