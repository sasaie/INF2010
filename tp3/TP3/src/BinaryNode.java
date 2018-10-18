import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
    	this.data = data;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
    	int compareResult = item.compareTo(data);
    	if (compareResult <= 0)	{		// Si l'objet à ajouter est plus petit ou égal (on accepte les doublons)
    		if (left == null)
    			left = new BinaryNode<T>(item);
    		else
    			left.insert(item);
    	}
    	else if (compareResult > 0)	{	// Si l'objet est plus grand

    		if (right == null)
    			right = new BinaryNode<T>(item);
    		else
    			right.insert(item);
    	}
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
    	int compareResult = item.compareTo(data);
    	
    	if (compareResult == 0)			// même objet
    		return true;
    	
    	else if (compareResult < 0)	{		// Si l'objet est plus petit
    		if (left == null)
    			return false;
    		else
    			return left.contains(item);
    	}
    	
    	else {	// Si l'objet est plus grand

    		if (right == null)
    			return false;
    		else
    			return right.contains(item);
    	}
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
    	int leftHeight, rightHeight;
    	
    	if (left == null)
    		leftHeight = -1;
    	else
    		leftHeight =  left.getHeight();
    		
    	if (right == null)
    		rightHeight = -1;
    	else
    		rightHeight = right.getHeight();
    	
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de maniÃ¨re que le plus petit item sera le premier inserÃ©
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
    	if (left != null)
    		left.fillListInOrder(result);
    	result.add(this);
    	if (right != null)
    		right.fillListInOrder(result);
    }
}
