

public class SearchEngine
{
    InvertedPageIndex inv;
    MySet<String> set=new MySet<String>();
    
    public SearchEngine()
    {
        inv=new InvertedPageIndex();
    }
    
    public void performAction(String actionMessage)
    {
        try
        {
            String s=actionMessage.substring(0,actionMessage.indexOf(' '));
            switch(s)
            {
                case "addPage": s=actionMessage.substring(actionMessage.indexOf(' ')+1);
                                if(!set.isMember(s))
                                {
                                    try
                                    {
                                        PageEntry pa=new PageEntry(s);
                                        inv.addPage(pa);
                                        set.addElement(s);
                                    }
                                    catch(Exception e1)
                                    {
                                        System.out.println("addPage "+s+" : Webpage "+s+" not found");
                                    }
                                }
                                else
                                {
                                    System.out.println("addPage "+s+" : "+s+" webpage is already present");
                                }
                                break;
                
                case "queryFindPagesWhichContainWord": s=actionMessage.substring(actionMessage.indexOf(' ')+1);                                                
                                                       System.out.print("queryFindPagesWhichContainWord "+s+" : ");
                                                       s=s.toLowerCase();
                                                       if(inv.getPagesWhichContainWord(s)==null||inv.getPagesWhichContainWord(s).isEmpty())
                                                       System.out.println("No webpage contains word "+s);
                                                       /*else{
                                                       Mynode<PageEntry> p=inv.getPagesWhichContainWord(s).getList().head();                                                      
                                                       while(p!=null)
                                                       {
                                                           System.out.print(p.getData().getName()+", ");
                                                           p=p.getLink();
                                                       }
                                                       System.out.println();}
                                                       break;*/
                                                       System.out.print(inv.getPagesWhichContainWord(s).get(0).name);
                                                       for(int i=1; i<inv.getPagesWhichContainWord(s).size(); i++)
                                                       {
                                                    	   System.out.print(", "+inv.getPagesWhichContainWord(s).get(i).name); 
                                                       }
               
                case "queryFindPositionsOfWordInAPage": actionMessage=actionMessage.substring(actionMessage.indexOf(' ')+1);
                                                        String x=actionMessage.substring(0,actionMessage.indexOf(' '));
                                                        String y=actionMessage.substring(actionMessage.indexOf(' ')+1);
                                                        System.out.print("queryFindPositionsOfWordInAPage "+x+" "+y+" : ");
                                                        x=x.toLowerCase();
                                                        if(set.isMember(y))
                                                        {
                                                            MyLinkedList<Integer> list=inv.getPositionsOfWordInAPage(x,y);  
                                                            if((list==null)||(list.size()==0))
                                                            System.out.println("Webpage "+y+" does not contain "+x);
                                                            else
                                                            {
                                                                   /* Mynode<Integer> nod=list.head();
                                                                    while(nod!=null)
                                                                    {
                                                                        System.out.print(nod.getData()+", ");
                                                                        nod=nod.getLink();
                                                                    }
                                                                    System.out.println(); */
                                                            	
                                                            	System.out.print(", "+list.get(0));
                                                            	for(int i=1; i<list.size(); i++)
                                                            	{
                                                            		System.out.print(", "+list.get(i));
                                                            	}
                                                            }
                                                        }
                                                        else
                                                        System.out.println("Webpage "+y+" is not present in the SearchEngine database.");
                                                        break;
                
                default: System.out.println("INVALID INPUT!");
                         break;                         
            }
        }
        catch(Exception e)
        {
            System.out.println("INVALID!!!");
        }
    }
}