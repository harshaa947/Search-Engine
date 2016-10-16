public class PageIndex {
	private MyLinkedList<WordEntry> wordlist = new MyLinkedList() ;
	public PageIndex(){
		
	}
public 	void addPositionForWord(String str, Position p){
	if(!search(str)){
		  //System.out.println("me called");
		WordEntry word= new WordEntry(str);
		word.addPosition(p);
		wordlist.addFirst(word);
	}
	else {
		  //System.out.println("me called");
		getword(str).addPosition(p);
	}
	}
public boolean search (String str){
	for(int i=1;i<=wordlist.size;i++){
	
		if(wordlist.getElementati(i).getstring().equals(str))
			return true;
	}
	return false;
}
public WordEntry getword(String str){
	for(int i=1;i<=wordlist.size;i++){
		
		if(wordlist.getElementati(i).getstring().equals(str))
			return wordlist.getElementati(i);
	}
	return null;
}
 public MyLinkedList<WordEntry> getWordEntries(){
	 return wordlist;
 }
}