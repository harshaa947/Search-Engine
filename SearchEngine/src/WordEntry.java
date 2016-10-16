
public class WordEntry {
	public String word = new String();
	MyLinkedList<Position> wordEntryList;   
	public WordEntry(String word)
	{
		this.word = word;
		wordEntryList = new MyLinkedList<Position>();
	}
	public void addPosition(Position position)
	{
		wordEntryList.add(position);
	}
	public void addPositions(MyLinkedList<Position> positions)
	{
		this.wordEntryList.extend(positions);
	}
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
		return wordEntryList;
	}
}
