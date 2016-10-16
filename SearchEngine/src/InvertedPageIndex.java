
public class InvertedPageIndex {
	MyHashTable hashT = new MyHashTable();
	public void addPage(PageEntry p)
	{
		for(int i=0; i<p.pageInfo.pageIndexList.size(); i++)
		hashT.addPositionsForWord(p.pageInfo.pageIndexList.get(i));
	}
	
	MySet<PageEntry> getPagesWhichContainWord(String str)
	{
		return hashT.getPagesWhichContainWord(str);
	}

	public MyLinkedList<Integer> getPositionsOfWordInAPage(String x, String y) {
		
		return hashT.getPositionsOfWordInAPage(x,y);
	}
	
	
}
