/*
 * This program prints the kth smallest number in a BST
 *
 * Author: @pyav
 */

#include <stdio.h>
#include <stdlib.h>

#define SUCCESS 0
#define FAILURE 1

/* The node structure */
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

/* Insert a node */
struct node *insert_node(struct node *node, int data)
{
  if (node == NULL)
    return new_node(data);

  if (data < node->data)
    node->left = insert_node(node->left, data);
  else if (data > node->data)
    node->right = insert_node(node->right, data);

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

static int count = 0;

/* Find the kth smallest element */
void find_kth_smallest_elem(struct node *node, int k)
{
  if (node == NULL)
    return;

  find_kth_smallest_elem(node->left, k);
  count++;

  if (k == count) {
    printf("\n%dth smallest value in the BST is: %d\n", k, node->data);
    exit(EXIT_SUCCESS);
  }

  find_kth_smallest_elem(node->right, k);
}

/* Cleanup */
void free_all(struct node **node)
{
  if (*node == NULL)
    return;

  free_all(&(*node)->left);
  free_all(&(*node)->right);
  free(*node);
  *node = NULL;
}

/* Main driver program */
int main(void)
{
  int k = -1;
  struct node *root = NULL;

  /* Create the tree */
  root = insert_node (root, 50);
  insert_node (root, 10);
  insert_node (root, 55);
  insert_node (root, 70);
  insert_node (root, 40);
  insert_node (root, 30);

  print_tree_inorder(root);

  printf("\nEnter the value of k: ");
  scanf("%d", &k);

  /* Find the kth smallest element */
  find_kth_smallest_elem(root, k);

  /* Cleanup */
  free_all(&root);

  return SUCCESS;
}

