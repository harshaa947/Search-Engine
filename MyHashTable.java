public class MyHashTable {
private int size=0;
private MyLinkedList<WordEntry>[] wordmap= new MyLinkedList[500] ;

public MyHashTable(){
	
}
private int getHashIndex(String str){
	
		int hash = 7;
for (int i = 0; i < str.length(); i++)
    hash = (31* hash + str.charAt(i)) % 500;


	return hash;
 }
 
 public void addPositionsForWord(WordEntry w){
	 
		int b=getHashIndex(w.getstring());
	      
		if(wordmap[b]==null)
		{wordmap[b]=new MyLinkedList<WordEntry>();
		wordmap[b].addFirst(w);}
		else {
		MyLinkedList<WordEntry> tmp3 = 	wordmap[b];
		boolean already=false;
		for(int i=1;i<=tmp3.size;i++)
			if(tmp3.getElementati(i).getstring().equals(w.getstring())){
				tmp3.getElementati(i).addPositions(w.getAllPositionsForThisWord());
				already=true;
			break;}
		if(!already)
        wordmap[b].addFirst(w);			
		}
	
 }
 public WordEntry returnlist(String str)throws Exception{
	 int b=getHashIndex(str);
	 boolean already=false;
	   if(wordmap[b]!=null)
	  {
		  for(int i=1;i<=wordmap[b].size;i++)
			if(wordmap[b].getElementati(i).getstring().equals(str))
			{  already=true;
				return wordmap[b].getElementati(i) ;
		    }
		 if(!already)
			 return null;
		 else throw new Exception ("Error-word not found");
			 
	  }
	  else throw new Exception ("Error-word not found");
	
 }
 
}