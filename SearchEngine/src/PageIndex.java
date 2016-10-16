

public class PageIndex {
	
	MyLinkedList<WordEntry> pageIndexList = new MyLinkedList<WordEntry>();
	public void addPositionForWord(String str, Position p)
	{
		int n = pageIndexList.size();
		int flag=0;
		int i;
		for(i=0; i<n; i++)
		{
			if(pageIndexList.get(i).word.equals(str))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			pageIndexList.get(i).wordEntryList.add(p);
		}
		else
		{
			WordEntry temp = new WordEntry(str);
			temp.wordEntryList.add(p);
		}
	}
	public MyLinkedList<WordEntry> getWordEntries()
	{
		return pageIndexList;
	}
	
}
