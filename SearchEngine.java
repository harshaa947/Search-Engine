import java.util.Arrays;
import java.util.ArrayList;
public class SearchEngine{
	InvertedPageIndex hashindex;
	public SearchEngine() {
		 hashindex = new InvertedPageIndex();
	}

	public void performAction(String actionstring) throws Exception {
		
	/*int i1=actionstring.indexOf(" ");
		 int i2=actionstring.substring(i1+1).indexOf(" ");*/
				System.out.print(actionstring+ " : ");
	String [] tokens =actionstring.split("\\s+");
		 String methodname=tokens[0];
		//System.out.print( Arrays.deepToString(tokens)+ " : "); 	 
		/*	 
		 int i=1;
		 if(i2!=-1)
			 i=2;
	     String[] arg=new String[i];
		 if(i==1)
		 {   
			 arg[0]=actionstring.substring(i1+1);
		 }
		 else
		 {
			 arg[0]=actionstring.substring(i1+1,i1+1+i2);
			 arg[1]=actionstring.substring(i1+i2+2);
		 }
		 if(i==1)
		System.out.print(methodname+"("+arg[0]+")   ");
	  else
		  System.out.print(methodname+"("+arg[0]+" , "+arg[1]+")  ");*/
	  switch(methodname){
		  case("addPage") :
		  
				addPage(tokens[1]);
				System.out.println("");
				break;
		  case("queryFindPagesWhichContainWord") :
				queryFindPagesWhichContainWord(tokens[1].toLowerCase());
				break;
		  case("queryFindPositionsOfWordInAPage") :
		        queryFindPositionsOfWordInAPage(tokens[1].toLowerCase(),tokens[2]);
				break;
		  case("queryFindPagesWhichContainAllWords") :
		  for(int i=0;i<tokens.length;i++)
			    tokens[i]=tokens[i].toLowerCase();
				queryFindPagesWhichContainAllWords(Arrays.copyOfRange(tokens,1,tokens.length));
				break;
		 case("queryFindPagesWhichContainAnyOfTheseWords"):
		  for(int i=0;i<tokens.length;i++)
			    tokens[i]=tokens[i].toLowerCase();
		       queryFindPagesWhichContainAnyOfTheseWords(Arrays.copyOfRange(tokens,1,tokens.length));
			   break;
		 case("queryFindPagesWhichContainPhrase") :
		  for(int i=0;i<tokens.length;i++)
			    tokens[i]=tokens[i].toLowerCase();
		       queryFindPagesWhichContainPhrase(Arrays.copyOfRange(tokens,1,tokens.length));
			   break;
		  default :
		        // verify();
		        throw new Exception("no such method exists");
	  }
	  
	}
	
 public void addPage(String str) throws Exception {
	 
	 PageEntry p = new PageEntry(str);
	 hashindex.addPage(p);
	
 }
 
 public void queryFindPagesWhichContainWord(String str){
	 try{
		 Myset<PageEntry> tmp = new Myset();
		tmp= hashindex.getPagesWhichContainWord(str);
		
		Myset<SearchResult> ans = new Myset();
		for(int i=1;i<=tmp.Size();i++)
		{
			PageEntry y = tmp.getElementati(i);
			SearchResult x = new SearchResult(y,y.relevanceOfWord(str));
			ans.Insert(x);
		}
		MySort tosort = new MySort();
		ArrayList<SearchResult> answer= tosort.sortThisList(ans);
		System.out.println(answer);
		//System.out.println("");
		
		
	 }
	 catch(Exception e){
		
		 System.out.println("No webpage contains word "+ str);
	 }
 }
 public void queryFindPositionsOfWordInAPage(String word , String page){
	 
	try{
		
		PageEntry p = new PageEntry(page);
		
		AvlTree<Position> tmp2 =p.getPageIndex().getword(word).getAllPositionsForThisWord();
		for(int j=1;j<=tmp2.size;j++)
		System.out.print(tmp2.getElementati(j).getWordIndex() + " , ");
	  System.out.println("");
	 }
	 catch(Exception e){
		 System.out.println("Webpage "+ page +" does not contain word"+ word);

	 }
  
 }
  
  public void queryFindPagesWhichContainAllWords(String[] str){
	   
	  try{
		  Myset<PageEntry> temp, temp1,temp2=new Myset();
		  temp=hashindex.getPagesWhichContainWord(str[0]);
		  //System.out.print(str[0]);
		  for(int i=1; i<str.length;i++)
		  {
			  
            //System.out.print(temp.Size()+" ");
			  temp1=hashindex.getPagesWhichContainWord(str[i]);
			  
			  temp=temp.Intersection(temp1);
			  
			  //System.out.print(temp.Size()+" ");
		  }
		  Myset<SearchResult> ans = new Myset();
		 // System.out.println(temp.Size()+" size");
		for(int i=1;i<=temp.Size();i++)
		{ 
			PageEntry y = temp.getElementati(i);
			
			SearchResult x = new SearchResult(y,y.getRelevanceOfPage(str,false));
			ans.Insert(x);
		}
		if(ans.Size()==0){
			System.out.println("No webpage contains all word "+ Arrays.deepToString(str));
			return;
		}
		MySort tosort = new MySort();
		ArrayList<SearchResult> answer= tosort.sortThisList(ans);
		System.out.print(answer);
		  System.out.println("");
	  }
	  catch(Exception e){
		//e.printStackTrace();
		 System.out.println("No webpage contains all word "+ Arrays.deepToString(str));
	 }
  }
  
  public void queryFindPagesWhichContainAnyOfTheseWords(String[] str){
	  try{ Myset<PageEntry> temp, temp1;
	  
		  temp=hashindex.getPagesWhichContainWord(str[0]);
		  for(int i=1; i<str.length;i++)
		  {
			  temp1=hashindex.getPagesWhichContainWord(str[i]);
			  if(temp1!=null && temp!=null)
			  temp=temp.Union(temp1);
		  }
		  Myset<SearchResult> ans = new Myset();
		for(int i=1;i<=temp.Size();i++)
		{
			PageEntry y = temp.getElementati(i);
			SearchResult x = new SearchResult(y,y.getRelevanceOfPage(str,false));
			ans.Insert(x);
		}
		MySort tosort = new MySort();
		ArrayList<SearchResult> answer= tosort.sortThisList(ans);
		System.out.print(answer);
	  System.out.println("");}
	  catch(Exception e){
		//e.printStackTrace();
		 System.out.println("No webpage contains any word "+ Arrays.deepToString(str));
	 }
  }
 
 public void queryFindPagesWhichContainPhrase(String[] str){
	 try{
		Myset<PageEntry> temp=hashindex.getPagesWhichContainPhrase(str); 
		if(temp.Size()==0)
		{
			System.out.print("No webpage contains phrase ");
		 System.out.println( Arrays.deepToString(str));
			return;
		}
		Myset<SearchResult> ans = new Myset();
		for(int i=1;i<=temp.Size();i++)
		{
			PageEntry y = temp.getElementati(i);
			SearchResult x = new SearchResult(y,y.getRelevanceOfPage(str,true));
			ans.Insert(x);
		}
		MySort tosort = new MySort();
		ArrayList<SearchResult> answer= tosort.sortThisList(ans);
		System.out.println(answer);
	 System.out.println("");}
	 catch(Exception e){
		//e.printStackTrace();
		 System.out.print("No webpage contains phrase ");
		 System.out.println( Arrays.deepToString(str));
	 }
 }
 
 
 }
