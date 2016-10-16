public class Position {
private PageEntry p =new PageEntry();
private int wordIndex;
public Position(PageEntry p, int wordIndex){
	this.p=p;
	this.wordIndex=wordIndex;
} 
public int getWordIndex() {
	return wordIndex;
}
public PageEntry getPage (){
	return p;
}
}