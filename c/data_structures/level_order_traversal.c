/*
 * Code to demonstrate level order traversal.
 *
 * Author: @pyav
 */
	
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

#define SUCCESS 0
#define FAILURE 1
#define MAX_SIZE 5

/* Array index count to append new children */
int count = -1;

/* Track position of the node whose children to be added next */
int track_pos = -1;

/* The node structure */
struct node {
	int data;
	struct node *left;
	struct node *right;
};
struct node *data_array[MAX_SIZE];

/* Create new node and assign value */
struct node *new_node(int data)
{
	struct node *one_node = NULL;

	one_node = (struct node *) malloc(sizeof (struct node));
	if (one_node != NULL) {
		one_node->data = data;
		one_node->left = NULL;
		one_node->right = NULL;
	} else {
		perror("malloc");
	}

	return one_node;
}

/* Append nodes to the array, call the function recursively */
void add_level_order(struct node *root) 
{
	if (NULL == root)
		return;

	data_array[++count] = root->left;
	data_array[++count] = root->right;
	track_pos = track_pos + 1;
	add_level_order(data_array[track_pos]);
}

/* Main driver code */
int main(void)
{
	int i = 0;
	struct node *root = NULL;
	
  /* Create the tree */
	root = new_node(1);
	root->left = new_node(2);
	root->right= new_node(3);
	root->left->left = new_node(4);
	root->left->right = new_node(5);

	data_array[++count] = root;
	track_pos = track_pos + 1;

  /* Recursive function call */
	add_level_order(data_array[track_pos]);

  /* Print the array */
  printf("\nData from nodes in level order: ");
	for (i = 0; i < MAX_SIZE; i++)
		printf("%d ", data_array[i]->data);

	printf("\n\n");

	return SUCCESS;
}

