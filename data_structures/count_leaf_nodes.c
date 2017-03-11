/*
 * Following program counts and prints total number of leaf nodes.
 *
 * Author: @pyav
 */

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

#define SUCCESS 0

/* Node structure */
struct node {
	int data;
	struct node *left;
	struct node *right;
};

/* Create a new node */
struct node *new_node(int data) 
{
	struct node *one_node = (struct node *) malloc(sizeof (struct node));
  if (NULL == one_node) {
    perror("malloc");
    exit(EXIT_FAILURE);
  }

	one_node->data = data;
	one_node->left = NULL;
	one_node->right = NULL;

	return one_node;
}

/* Count the leaf nodes */
int count_leaf_nodes(struct node *temp_node)
{
	if (temp_node == NULL)
		return 0;

  /* For leaf node, return count 1 */
	if (temp_node->left == NULL && temp_node->right == NULL)
		return 1;

  /* Count the leaf nodes recursively */
  return (count_leaf_nodes(temp_node->left) + 
      count_leaf_nodes(temp_node->right));
}

/* Main driver code */
int main(void)
{
	int total_leaf_nodes = -1;

  /* Create the tree structure */
	struct node *root = new_node(1);
	root->left = new_node(2);
	root->right = new_node(3);
	root->left->left = new_node(4);
	root->left->right = new_node(5);
	root->right->left = new_node(6);
	root->right->right = new_node(7);

	total_leaf_nodes = count_leaf_nodes(root);
	printf("\nTotal leaf nodes = %d\n\n", total_leaf_nodes);

	return SUCCESS;
}

