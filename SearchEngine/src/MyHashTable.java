
public class MyHashTable {
	
	@SuppressWarnings("unchecked")
	MyLinkedList<WordEntry>[] hashtable = new MyLinkedList[500];
	
	/*for(int i=0; i<100; i++)
	{
		hashtable[i]=new MyLinkedList<WordEntry>();
	}
	*/
	public int getHashIndex(String str)
	{
		int hash = 7;
		for (int i=0; i<str.length(); i++)
		{
			hash = ((hash*31 + str.charAt(i))|500);
		}
		return hash;
	}
	public void addPositionsForWord(WordEntry w)
	{
		
		int hash = getHashIndex(w.word);
		if(hashtable[hash].contains(w))
		{
			int i;
			for(i=0; i<hashtable[hash].size(); i++)
			{
				if(hashtable[hash].get(i)==w)
					break;
			}
			hashtable[hash].get(i).addPositions(w.getAllPositionsForThisWord());
		}
		else
		{
			hashtable[hash].add(w);
		}
		
	}
	@SuppressWarnings("unused")
	public MySet<PageEntry> getPagesWhichContainWord(String str)
	{
		int hash = getHashIndex(str);
		if(hashtable[hash]==null)
		return null;
		
		MySet<PageEntry> temp = new MySet<PageEntry>();
		for(int i=0; i<hashtable[hash].size(); i++)
		{
			if(hashtable[hash].get(i).word.equalsIgnoreCase(str))
			{
				MySet<PageEntry> temp1 = new MySet<PageEntry>();
				for(int j=0; j<hashtable[hash].get(i).wordEntryList.size(); j++)
				{
					temp1.addElement(hashtable[hash].get(i).wordEntryList.get(j).getPageEntry());
					temp=temp.union(temp1);
				}
			}
			return temp;
		}
		return null;
	}
	public MyLinkedList<Integer> getPositionsOfWordInAPage(String x, String y) {
		int hash=getHashIndex(x);
        if(hashtable[hash]==null)
        return null;
		for(int i=0; i<hashtable[hash].size(); i++)
		{
			if(hashtable[hash].get(i).word.equals(x))
			{
				MyLinkedList<Integer> list=new MyLinkedList<Integer>();
				for(int j=0; j<hashtable[hash].get(i).wordEntryList.size(); j++)
				{
					if(hashtable[hash].get(i).wordEntryList.get(j).getPageEntry().name.equals(y))
						list.add(hashtable[hash].get(i).wordEntryList.get(j).wordIndex);
		
				}
				return list;
			}
		}
		return null;
	}
}
