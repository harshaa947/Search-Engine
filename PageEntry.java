import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class PageEntry {
	private String mypagename="";
	public PageEntry(){}
private PageIndex pageindex=new PageIndex();
	private String[] connectors=  { "a", "an", "the","they" ,"these" ,"for" ,"is","are", "of", "or", "and", "does","will","whose","was" };
 private AvlTree<Position> mywaste = new AvlTree(); 
 public PageEntry(String pageName) throws IOException{
	
	 mypagename=pageName;
  BufferedReader br1 = null;
  String myline="";
  int i=1;
  br1 = new BufferedReader(new FileReader("webpages/"+pageName));
  while((myline = br1.readLine()) != null)
	  
  {  myline = myline.replace(",", " ");
    myline = myline.replace(".", " ");
    myline = myline.replace(";", " ");
    myline = myline.replace("!", " ");
    myline = myline.replace("?", " ");
    myline = myline.replace("(", " ");
    myline = myline.replace(")", " ");
    myline = myline.replace("{", " ");
    myline = myline.replace("}", " ");
    myline = myline.replace("[", " ");
    myline = myline.replace("]", " ");
    myline = myline.replace("<", " ");
    myline = myline.replace(">", " ");
    myline = myline.replace("#", " ");
	myline = myline.replace("=", " ");
	myline = myline.replace("-", " ");
	myline = myline.replace("'", " ");
	myline = myline.replace("\"", " ");
  String [] tokens = myline.toLowerCase().split("\\s+");
  
  for(int j=0;j<tokens.length;j++){
	 String myword=tokens[j];
	 if(myword.equals("stacks"))
		 myword="stack";
	 if(myword.equals("structures"))
		 myword="structure";
	 if(myword.equals("applications"))
		 myword="application";
;
 myword=myword.replace(" ","");
 if (myword.equals(""))
	 continue;
  
	 
	  Position myposition=new Position(this,i);
	if(!isConnector(myword)){
	  pageindex.addPositionForWord(myword,myposition);}
	  else
		  mywaste.Insert(myposition,myposition.getWordIndex());
   i++;
 }  
	
  }
 }
public String myname(){
	return mypagename;
}
 public PageIndex getPageIndex(){
	return pageindex;
}

public boolean isConnector(String str){
	for(int j=0;j<connectors.length;j++)
		if(str.equals(connectors[j]))
		{   
			return true;}
		return false;
}
/*
public void temp(){
	for(int i=0;i<pageindex.getWordEntries().size;i++){
		System.out.print(pageindex.getWordEntries().getElementati(i).getstring()+" ");
		System.out.println(pageindex.getWordEntries().getElementati(i).getAllPositionsForThisWord().getElementati(1).getWordIndex());
	}
}*/
public boolean containphrase ( String[] str){
	AvlTree<Position> test = pageindex.getword(str[0]).getAllPositionsForThisWord();
	for(int i=1;i<=test.size();i++)
	{
		boolean match=true;
		int t = test.getElementati(i).getWordIndex();
		t++;
		for(int j=1;j<str.length;j++)
		{
			while(true){
				if(mywaste.find(t)==null)
					break;
				t++;
			}
			if(pageindex.getword(str[j])==null)
				return false;
			AvlTree<Position> temp=pageindex.getword(str[j]).getAllPositionsForThisWord();
			if(temp.find(t)==null)
			{
				match=false;
				break;
			}
		}
		if(match==true)
			return true;
		//System.out.print(test.getElementati(i).getWordIndex()+" "+ match+this.myname()+" "+t);
	}
	return false;
}
public float relevanceOfWord(String str){
	float answer=0;
	if(pageindex.getword(str)!=null){
	AvlTree<Position> temp= pageindex.getword(str).getAllPositionsForThisWord();
	for(int i=1;i<=temp.size();i++){
		int to = temp.getElementati(i).getWordIndex();
		to=to*to;
		answer+=1/(to+0.0f);
	}}
	return answer;	
}
public float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase){
	float answer=0;
	int[] position = new int[str.length];
	if(doTheseWordsRepresentAPhrase){
		AvlTree<Position> test = pageindex.getword(str[0]).getAllPositionsForThisWord();
	for(int i=1;i<=test.size();i++)
	{
		boolean match=true;
		int t = test.getElementati(i).getWordIndex();
		position[0]=t;
		for(int j=1;j<str.length;j++)
		{
			while(true){
				if(mywaste.find(t)==null)
					break;
				t++;
			}
			AvlTree<Position> temp=pageindex.getword(str[j]).getAllPositionsForThisWord();
			if(temp.find(t)==null)
			{
				match=false;
				break;
			}
			else{
				position[j]=t;
			}
		}
		
		
	}
	for(int i=0;i<position.length;i++)
	{   if(position[i]!=0)
		{int to =position[i]*position[i];
		answer+=1/(to+0.0f);}
	}
		return answer;
	}
	else{
		for(int i=0;i<str.length;i++)
		answer+=relevanceOfWord(str[i]);	
	}
	return answer;
}
}