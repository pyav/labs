/*
 * This program demonstrates inorder traversal of a Binary Search Tree.
 * 
 * Author: @pyav
 */

#include <stdio.h>
#include <malloc.h>

#define SUCCESS 0
#define FAILURE 1

/* Node structure */
struct node {
	int data;
	struct node *left;
	struct node *right;
};

/* Create a new node and return it */
struct node *new_node(int data)
{
	struct node *one_node = NULL;

	one_node = (struct node *) malloc(sizeof (struct node));
	if (NULL != one_node) {
		one_node->data = data;
		one_node->left = NULL;
		one_node->right = NULL;
	}

	return one_node;
}

/* Insert a node */
struct node *insert_node(struct node *node, int data)
{
  /* Create a new node if the passed node is NULL */
	if (NULL == node)
		return new_node(data);

	if (data < node->data)
		node->left = insert_node(node->left, data);
  else if (data > node->data)
		node->right = insert_node(node->right, data);

	return node;
}

/* Traverse inorder and print the tree */
void print_tree_inorder(struct node * node)
{
	if (NULL != node) {
		print_tree_inorder(node->left);
		printf("%d ", node->data);
		print_tree_inorder(node->right);
	}
}

/* Main driver */
int main(void)
{
  /* Create the tree */
	struct node *root = NULL;
	root = insert_node(root, 50);
	insert_node(root, 10);
	insert_node(root, 55);
	insert_node(root, 70);
	insert_node(root, 40);
	insert_node(root, 30);

  /* Print the tree inorder */
	print_tree_inorder(root);
	printf ("\n");

	return SUCCESS;
}

