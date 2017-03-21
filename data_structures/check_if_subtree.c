/*
 * Code to check if a binary tree is a subtree of another.
 *
 * Output
 * ------
 *
 * Tree S is subree of tree T
 *
 *
 * Referances
 * ----------
 *
 *  (1) http://www.geeksforgeeks.org
 *
 *
 *  Author
 *  ------
 *
 *  pyav
 */

#include <stdio.h>
#include <malloc.h>
#include <stdbool.h>
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

/* Check if identical */
bool areIdentical(struct node *T, struct node *S)
{
	if (T == NULL && S == NULL)
		return true;

	if (T == NULL || S == NULL)
		return false;

	return (T->data == S->data) && 
		areIdentical(T->left, S->left) &&
		areIdentical(T->right, S->right); 
}

/* Check if subtree */
bool isSubtree(struct node *T, struct node *S)
{
	if (S == NULL)	
		return true;
	
	if (T == NULL)
		return false;

	if (areIdentical(T, S))
		return true;

	return isSubtree(T->left, S) ||
		isSubtree(T->right, S);
}

/* Main driver code */
int main(void)
{
	struct node *T = new_node(26);
	T->right = new_node(3);
	T->right->right = new_node(3);
	T->left = new_node(10);
	T->left->left = new_node(4);
	T->left->left->right = new_node(30);
	T->left->right = new_node(6);

  /* Second tree */
	struct node *S = new_node(10);
	S->right = new_node(6);
	S->left = new_node(4);
	S->left->right = new_node(30);
	
  /* Check subtree */
	if (isSubtree(T, S))
		printf("Tree S is subree of tree T\n");
	else 
		printf("Tree S is not a subtree of tree T\n");

	return SUCCESS;
}

