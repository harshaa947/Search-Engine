import java.util.*;
public class  MySort {
	
public ArrayList<SearchResult> sortThisList(Myset<SearchResult> listOfSortableEntries) throws Exception{
	ArrayList<SearchResult> sortedlist=new ArrayList<SearchResult>();
	for(int i=1;i<=listOfSortableEntries.Size();i++)
	{  sortedlist.add(listOfSortableEntries.getElementati(i));
 /*int maxat=1;
        SearchResult temp=listOfSortableEntries.getElementati(i);
		for(int j=2;j<=listOfSortableEntries.Size();j++)
		{
			
			if(temp.compareTo(listOfSortableEntries.getElementati(j))==-1)
			{temp=listOfSortableEntries.getElementati(j);
		      maxat=j;  
			}
		}
		sortedlist.add(listOfSortableEntries.getElementati(maxat));
		listOfSortableEntries.Delete(listOfSortableEntries.getElementati(maxat));*/
	}
	Collections.sort(sortedlist);
	Collections.reverse(sortedlist);
	return sortedlist;
}
}
