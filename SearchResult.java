import java.util.Comparator;
public  class SearchResult implements Comparable {
private PageEntry p;
private float relevance;
 public SearchResult(PageEntry p, float r){
	 this.p=p;
	 this.relevance=r;
 }
 public PageEntry getPageEntry(){
	 return p;
 }
  public float getRelevance(){
	  return relevance;
  }
  
  public int compareTo(Object other) {
	  SearchResult otherObject =(SearchResult) other ;
	  if(relevance>otherObject.getRelevance())
		  return 1;
	  else if(relevance==otherObject.getRelevance()) 
return 0;
else return -1;		  
  }
  public String toString(){
	//  return p.myname() + " " + relevance;
	return p.myname();
  }
}