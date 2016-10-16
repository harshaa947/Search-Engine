
public class WordEntry {
	private String word="";
	//private MyLinkedList<Position> mypositions = new MyLinkedList();
	private AvlTree<Position> mypositions = new AvlTree();
public WordEntry(String word){
	this.word=word;
}
public void addPosition(Position position){
	//mypositions.addFirst(position);
	//System.out.println("me called");
	if(position!=null)
	mypositions.Insert(position,position.getWordIndex());
}
public void addPositions(MyLinkedList<Position> positions){
	//System.out.println("me called");
	if(positions==null)
		return;
	for(int i=1;i<=positions.size;i++)
		if(mypositions.getElementati(i)!=null)
		mypositions.Insert(positions.getElementati(i),positions.getElementati(i).getWordIndex());
	
}
public void addPositions(AvlTree<Position> positions){
	if(positions==null)
		return;
	for(int i=1;i<=positions.size;i++)
		if(mypositions.getElementati(i)!=null)
		mypositions.Insert(positions.getElementati(i),positions.getElementati(i).getWordIndex());
	
}
public String getstring(){
	return word;
}
public AvlTree<Position> getAllPositionsForThisWord() {
	return mypositions;
}
}