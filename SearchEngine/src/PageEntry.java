import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PageEntry {
	PageIndex pageInfo;
	String name = new String();
	
    String[] arr= {"a","an","the","they","these","this","for","is","are","was","of","or","and","does","will","whose"};
    @SuppressWarnings("resource")
	public PageEntry(String pageName)throws IOException
    {
        BufferedReader obj;
        name=pageName;
        pageInfo=new PageIndex();
        
        
        obj=new BufferedReader(new FileReader(pageName));
        String s;
        int ind=1;
        while((s=obj.readLine())!=null)
        { 
             s=s+" ";
             String x="";
             for(int i=0;i<s.length();i++)
             {
                 int flag=0;
                 char ch=s.charAt(i);
                
                 if((ch=='{')||(ch=='}')||(ch=='[')||(ch==']')||(ch=='<')||(ch=='>')||(ch=='=')||(ch=='(')||(ch==')')||(ch=='.')||(ch==',')||(ch==';')||(ch=='\'')||(ch=='\"')||(ch=='?')||(ch=='#')||(ch=='!')||(ch=='-')||(ch==':')||(ch==' '))
                 {
                     for(int j=0;j<=15;j++)
                     {
                         if(x.equalsIgnoreCase(arr[j]))
                         {
                             flag=1;
                             break;
                         }
                     }
                     if(flag==0&&!x.equals(""))
                     {
                         Position pos=new Position(this,ind);
                         x=x.toLowerCase();
                         if(x.equals("stacks")||x.equals("structures")||x.equals("applications"))
                         x=x.substring(0,x.length()-1);
                         pageInfo.addPositionForWord(x,pos);
                         ind++;
                         x="";
                     }
                     else if(!x.equals(""))
                     {
                         ind++;
                         x="";
                     }
                 }
                 else
                 x=x+ch;
             }
        }
       
    }
	/*public PageEntry(String pageName)
	{
		this.pageName = pageName;
		// Read the file
		// Add words to the PageIndex
		BufferedReader br = null;
		//SearchEngine r = new SearchEngine();
		int count=0;
		try {
			String wordInFile;
			br = new BufferedReader(new FileReader("pageName.txt"));

			while ((wordInFile = br.readLine()) != null) {
				//if(wordInFile=="a"||"an"|| "the"||"they"|| "these"|| "this"||"for"|| "is"||"are"||"was"||"of"||"or"||"and"||"does"|| "will"|| "whose"))
			
			// replace punctuation marks ***********
			// replace plural by singular*****
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	} */
	public PageIndex getPageIndex()
	{
		
		return this.pageInfo;
	}
	
}
