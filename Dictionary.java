
public class Dictionary {
	Node root = null;
	boolean DEBUG = true;
	int compareIndex;

	static class Node {

		String key, data;
		Node left, right, parent;

		public Node(String word, String definition) {
			this.key = word;
			this.data = definition;
			left = right = null;
		}
	}

	public void addNode(Node newNode) {

		Node parent = root;
		Node current = null;

		boolean notDone = true;
		boolean compareNotDone = true;
		compareIndex = 1;
		if (parent == null) {
			root = newNode;

			if (DEBUG)
				System.out.println("" + newNode.key + " - added root");
		} else {

			while (notDone) {
				compareNotDone = true;
				compareIndex = 1;

				while (compareNotDone) {
					if (newNode.key.substring(0, compareIndex).compareTo(parent.key.substring(0, compareIndex)) > 0) {
						if (parent.right == null) {
							parent.right = newNode;
							if (DEBUG)
								System.out.println("" + newNode.key + " - added node right");
							compareNotDone = false;
							notDone = false;
						} else {
							current = parent.right;
							if (DEBUG)
								System.out.println("" + newNode.key + " - went right");
							compareNotDone = false;
						}
					} else if (newNode.key.substring(0, compareIndex)
							.compareTo(parent.key.substring(0, compareIndex)) < 0) {
						if (parent.left == null) {
							parent.left = newNode;
							if (DEBUG)
								System.out.println("" + newNode.key + " - added node left");
							compareNotDone = false;
							notDone = false;
						} else {
							current = parent.left;
							if (DEBUG)
								System.out.println("" + newNode.key + " - went left");
							compareNotDone = false;
						}
					} else if (newNode.key.substring(0, compareIndex)
							.compareTo(parent.key.substring(0, compareIndex)) == 0) {
						compareIndex++;
					}
				}

				parent = current;

			}

		}
	}

	public Node findNode(String key) {

		Node current = root;
		
		boolean notDone = true;
		boolean compareNotDone = true;
		int compareIndex = 1;
		if (root == null) {
			if (DEBUG) System.out.println("Array is empty");
			return null;

		} else {

			while (notDone) {
				if (current == null) {
					if (DEBUG) System.out.println("" + key + " - Not found");
					notDone = false;
					System.exit(1);
				} else if (key.equals(current.key)) {
					if (DEBUG)
						System.out.println("" + key + " - Found it!");
					return current;
				} else {
					compareNotDone = true;
					compareIndex = 1;
					while (compareNotDone) {
						if (key.substring(0, compareIndex).compareTo(current.key.substring(0, compareIndex)) > 0) {
							current = current.right;
							compareNotDone = false;
						} else if (key.substring(0, compareIndex)
								.compareTo(current.key.substring(0, compareIndex)) < 0) {
							current = current.left;
							compareNotDone = false;
						} else if (key.substring(0, compareIndex)
								.compareTo(current.key.substring(0, compareIndex)) == 0) {

							if (compareIndex >= key.length()) {
								compareNotDone = false;
								
							} else {
								compareIndex++;
							}
						}
					}

				}
			}

			return null;
		}
	}

	public void printNode(String key) {
		Node printNode = this.findNode(key);
		if (printNode != null)
			System.out.println("Your key was: " + printNode.key + "\nAnd the data was: " + printNode.data);
	}

	public int compareTo(Node newNode, Node parent) {

		if (newNode.key.substring(0, compareIndex).compareTo(parent.key.substring(0, compareIndex)) == 0) {

			return 0;
		}
		if (newNode.key.substring(0, compareIndex).compareTo(parent.key.substring(0, compareIndex)) > 0) {

			return 1;
		}
		if (newNode.key.substring(0, compareIndex).compareTo(parent.key.substring(0, compareIndex)) < 0) {

			return -1;
		}
		return 100;
	}

	public static void main(String[] args) {

		Dictionary dictionary = new Dictionary();
		dictionary.addNode(new Node("Orange", "Orange is a color"));

		dictionary.addNode(new Node("Black", "Black is a color"));

		dictionary.addNode(new Node("Green", "Green is a color"));

		dictionary.addNode(new Node("Blue", "Blue is a color"));

		dictionary.addNode(new Node("White", "White is a color"));

		dictionary.addNode(new Node("Gray", "Gray is a color"));

		dictionary.printNode("White");

		dictionary.printNode("Brown");

	}

}
