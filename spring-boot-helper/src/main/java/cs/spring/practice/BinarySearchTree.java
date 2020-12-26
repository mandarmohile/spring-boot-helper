package cs.spring.practice;

public class BinarySearchTree 
{
	private Node rootNode;

	public static void main(String[] args)
	{

	}

	public void add(int i)
	{
		if (rootNode == null) 
		{
			rootNode = new Node();
			rootNode.setValue(i);
			return;
		}

		addToTheTree(rootNode, i);
	}

	private void addToTheTree(Node pNode, int pValue)
	{
		
		if(pValue > pNode.getValue()) 
		{
			if(pNode.getLeft() == null)
			{
				Node lLeftNode = new Node();
				lLeftNode.setValue(pValue);
				pNode.setLeft(lLeftNode);
			}
			else
			{
				addToTheTree(pNode.getLeft(), pValue);
			}
		}
		else if(pValue < pNode.getValue())
		{
			if(pNode.getRight() == null)
			{
				Node lRightNode = new Node();
				lRightNode.setValue(pValue);
				pNode.setRight(lRightNode);
			}
			else
			{
				addToTheTree(pNode.getRight(), pValue);
			}
		}
	}

}
