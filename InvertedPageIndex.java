public class  InvertedPageIndex {
 private MyHashTable hashmap = new MyHashTable();
 public void addPage(PageEntry p){
	  
	 MyLinkedList<WordEntry> wordlist = p.getPageIndex().getWordEntries();
	  
	 for(int i=1;i<=wordlist.size;i++)
		 hashmap.addPositionsForWord(wordlist.getElementati(i));
	
 }
 
 public  Myset<PageEntry> getPagesWhichContainWord(String str) throws Exception{
	 Myset<PageEntry> toreturn = new Myset();
	 
	 if(hashmap.returnlist(str)==null)
		 return toreturn;
	 AvlTree<Position> list =hashmap.returnlist(str).getAllPositionsForThisWord();
	
	 for(int i=1;i<=list.size;i++)
	 {
		 PageEntry tmp = list.getElementati(i).getPage();
		 
		 toreturn.Insert(tmp);
	 }
	 return toreturn;
	 
 }
 
 public  Myset<PageEntry> getPagesWhichContainPhrase(String[] str) throws Exception {
	 String test = str[0];
	 Myset<PageEntry> superset = getPagesWhichContainWord(test);
	 Myset<PageEntry> answer= new Myset();
	 for(int i=1;i<=superset.Size();i++)
	 {
		 if(superset.getElementati(i).containphrase(str))
			 answer.Insert(superset.getElementati(i));
			 
			//	 System.out.print(answer.Size()+"h ");
			 
	 }
	 return answer;
 }
}