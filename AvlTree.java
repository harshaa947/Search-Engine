 public class AvlTree<X>{
	 public class AvlNode<X>{
		public AvlNode<X> left;
		public AvlNode<X> right;
		public AvlNode<X> parent;
		public X key;
		public int order;
		public AvlNode(){
			left = right = parent = null;
			order = 0;
			
			
		}
		public AvlNode(X k,int b) {
			left = right = parent = null;
			order = b;
			
			key = k;
		}
		public String toString() {
			return "" + key;
		}
		public void setequal(AvlNode<X> temp){
			this.left=temp.left;
			this.parent=temp.parent;
			this.right=temp.right;
			this.key=temp.key;
			this.order=temp.order;
		}

	}
	
private AvlNode<X> root;
public int size=0;
public AvlTree(){
	root=null;
}
public int size (){
	return size;
}
public AvlTree(AvlNode<X> root){
	this.root=root;
}
public void Insert(X key, int order)
{/*if(find(order)!=null)
return;*/
//System.out.println(size);	
size++;
	AvlNode temp=new AvlNode(key,order);
	
	Insertbst(temp);
	//System.out.println("key is " + key);
	//preorder();
	
	AvlNode<X> p,c,gc;
	p=temp.parent;
	c=temp;
	gc=null;
	if(p==null)
		return;
	gc=c;
	c=p;
	p=p.parent;
	if(p==null)
		return;
	while(true){
		if(!getbalance(p))
			break;
		
		
		gc=c;
		c=p;
		p=p.parent;
		if(p==null)
		  return;
	}
	if(gc==null)
		return;
	if(c==p.left && gc==c.left)
	{
		if(root==p)
			root=c;
		
		
		rightrotate(p,c);
		
		return;
	}
	if(c==p.left && gc==c.right)
	{
         if(root==p)
			root=gc;
		leftrotate(c,gc);
		rightrotate(p,gc);
		
	
		return;
	}
	if(c==p.right && gc==c.right)
	{  //System.out.println("me called");
         if(root==p)
		 {root=c;
	// System.out.println("root changed");
	 }
		leftrotate(p,c);
		
		return;
	}
	
	if(root==p)
			root=gc;
	    rightrotate(c,gc);
		leftrotate(p,gc);
		
		return;
	
	
}

public void Insertbst(AvlNode<X> temp){
	if(root==null)
	{
		root=temp;
		
		return;
	}
	AvlNode<X> cnode,pnode;
	cnode=root;
	pnode=null;
	while(true){
		pnode=cnode;
		if(temp.order<=cnode.order)
		{
			cnode=cnode.left;
			if(cnode==null)
			{
				pnode.left=temp;
				temp.parent=pnode;
				
				return;
			}
		}
		else
		{
			cnode=cnode.right;
			
			if(cnode==null)
			{
				pnode.right=temp;
				temp.parent=pnode;
				
				return;
			}
		}
	}
}
public boolean getbalance(AvlNode<X> temp){
	int bal =Math.abs(height(temp.left)-height(temp.right));
	if(bal<2)
		return true;
	return false;
}
public int height (AvlNode<X> temp){
	if(temp==null)
		return -1;
	if(temp.left==null && temp.right==null)
		return 0;
	if(temp.left==null)
		return 1+ height(temp.right);
	if(temp.right==null)
		return 1+height(temp.left);
	return 1+Math.max(height(temp.left),height(temp.right));
}
public void rightrotate(AvlNode<X> y,AvlNode<X> x){
	if(y.parent!=null)
	{if(y.parent.left==y)
		y.parent.left=x;
	else
	y.parent.right=x;}
	y.left=x.right;
	x.right=y;
	x.parent=y.parent;
	y.parent=x;
	if(y.left!=null)
	y.left.parent=y;
}
public void leftrotate(AvlNode<X> x,AvlNode<X> y){
	if(x.parent!=null)
	{if(x.parent.left==x)
		x.parent.left=y;
	else
	x.parent.right=y;}
	x.right=y.left;
	if(x.right!=null)
	x.right.parent=x;
	y.parent=x.parent;
	x.parent=y;
	
	y.left=x;
}
public void preorder(){
	System.out.println(root.key);
	
	preorder(root.left);
	preorder(root.right);
	//inorder(root);
	//postorder(root);
}
public void preorder(AvlNode<X> temp){
	if(temp==null)
		return;
	System.out.println(temp.key);

	preorder(temp.left);
	preorder(temp.right);
}
public void inorder(AvlNode<X> temp){
	if(temp==null)
		return;
	
	inorder(temp.left);
	System.out.println(temp.key+" key ");
	inorder(temp.right);
}
public void postorder(AvlNode<X> temp){
	if(temp==null)
		return;
	
	postorder(temp.left);
	
	postorder(temp.right);
	System.out.println(temp.key);
}
public X find(int keyorder){
	if(root==null)
		return null;
	if(root.order==keyorder)
		return root.key;
	AvlNode<X> cnode =root;
	while(true)
	{
		if(keyorder<=cnode.order)
		{
			cnode=cnode.left;
			if(cnode==null)
				return null;
			if(cnode.order==keyorder)
				return cnode.key;
			
		}
		else{
			cnode=cnode.right;
			if(cnode==null)
				return null;
			if(cnode.order==keyorder)
				return cnode.key;
		}
	}
}
public X getElementati(int i){
	MyLinkedList<X> temp= this.inorderarray();
	return temp.getElementati(i);
}
public MyLinkedList<X> inorderarray (){
	
	MyLinkedList<X> temp=  new MyLinkedList();
	if(root!=null)
		addarray(root,temp);
	return temp;
}
public void addarray (AvlNode<X> node , MyLinkedList<X> array)
{
	if(node==null)
		return;
	
	addarray(node.left,array);
	array.addLast(node.key);
	addarray(node.right,array);
}
/*
public static void main ( String args [])
	{
		AvlTree<Integer> test = new AvlTree();
		test.Insert(10,10);
		test.Insert(20,20);
		test.Insert(30,30);
		test.Insert(40,40);
		test.Insert(50,50);
		test.Insert(25,25);
		test.Insert(5,5);
		test.Insert(6,6);
		test.Insert(7,7);
		System.out.println(test.root.parent+" "+ test.root);
		//test.Insert(8,8);
		
		//test.preorder();
		//System.out.println("key 30 "+ test.find(25));
		test.inorder(test.root);
		test.preorder(test.root);
		//MyLinkedList<Integer> myarray = test.inorderarray();
		
		//for(int i=1;i<=myarray.size;i++)
		//	System.out.println(myarray.getElementati(i));
		//test.inorder(test.root);
	}*/
 }