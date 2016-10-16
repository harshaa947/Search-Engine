public class heap <X extends Comparable>{
private X[] heapdata;
private int size;
public heap(int n ){
	size=n;
	heapdata = (X[]) new Object[n];
}
public boolean IsEmpty(){
	return size==0 ;}
public X getRoot(){
	if(IsEmpty())
		return null;
	else return heapdata[0];
}
public void Insert(X data){
	
	heapdata[size]=data;
	bubbleUp();
}
private void bubbleUp() {
        int index = this.size -1 ;
        
        while ((index>1)&& (heapdata[getParent(index)].compareTo(heapdata[index]) > 0)) {
           
            interchange(index, getParent(index));
            index = getParent(index);
        }        
    } 


private int getParent (int index){
	return (index-1)/2 ;
}
private int getLeft(int index){
	return 2*index+1 ;
}
private int getRight(int index){
	return 2*index +2 ;
}
private void  interchange(int a, int b){
	X temp= heapdata[a];
	heapdata[a]=heapdata[b];
	heapdata[b]=temp;
	
}
}