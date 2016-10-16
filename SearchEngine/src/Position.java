
public class Position {
	PageEntry p;
	int wordIndex;
	
	Position(PageEntry p, int WordIndex)
	{
		this.p = p;
		this.wordIndex = WordIndex;
	}
	public PageEntry getPageEntry()
	{
		return p;
	}
	public int getWordIndex()
	{
		return wordIndex;
	}
}
