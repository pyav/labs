/* 
 * This program finds the lowest common ancester in a BST
 *
 * Author: @pyav
 */

#include <stdio.h>
#include <stdlib.h>

#define SUCCESS 0
#define FAILURE 1

/* Node structure */
struct node {
	int data;
	struct node *left;
	struct node *right;
};

/* Create a new node */
struct node *new_node(int data)
{
	struct node *one_node = NULL;
	one_node = (struct node *) malloc(sizeof (struct node));
	if (one_node != NULL) {
		one_node->data = data;
		one_node->left = NULL;
		one_node->right = NULL;
	}

	return one_node;
}

/* Insert a new node */
struct node *insert_node(struct node *node, int data)
{
	if (node == NULL)
		return new_node(data);

	if (data < node->data) {
		node->left = insert_node(node->left, data);
	} else if (data > node->data){
		node->right = insert_node(node->right, data);
	}

	return node;
}

/* Print tree inorder */
void print_tree_inorder(struct node *node)
{
	if (node != NULL) {
		print_tree_inorder(node->left);
		printf("%d ", node->data);
		print_tree_inorder(node->right);
	}
}

/* Function to return lowest common ancester */
struct node* lca(struct node *node, int n1, int n2)
{
	if (node == NULL)
		return node;
	
	if (node->data > n1 && node->data > n2)
		return lca(node->left, n1, n2);
	
	if (node->data < n1 && node->data < n2)
		return lca(node->right, n1, n2);
	
	return node;
}

/* Free all nodes of the BST */
void free_all(struct node **node)
{
	if (*node == NULL)
		return;
	
	free_all(&(*node)->left);
	free_all(&(*node)->right);
	free (*node);
	*node = NULL;
}

/* Main driver code */
int main(void)
{
	/* Create the tree */
	struct node *root = NULL;
	root = insert_node(root, 20);
	insert_node(root, 8);
	insert_node(root, 22);
	insert_node(root, 4);
	insert_node(root, 12);
	insert_node(root, 10);
	insert_node(root, 14);

	/* Print the tree */
	print_tree_inorder(root);
	printf("\n");

	/* Now check for lowest common ancester */
	int n1 = 10, n2 = 14;
	struct node *t = lca(root, n1, n2);
	printf("LCA of %d and %d is %d \n", n1, n2, t->data);

	n1 = 14, n2 = 8;
	t = lca(root, n1, n2);
	printf("LCA of %d and %d is %d \n", n1, n2, t->data);

	n1 = 10, n2 = 22;
	t = lca(root, n1, n2);
	printf("LCA of %d and %d is %d \n", n1, n2, t->data);

	free_all(&root);

	return SUCCESS;
}
/* End of main driver */

