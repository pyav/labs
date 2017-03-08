/*
 * This program creates a balanced BST from a sorted array.
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

/* Convert the array into a BST */
struct node *convert_BST(int left, int right, int a[])
{
  if ((left > right) || (right < 0))
    return NULL;

  int mid = (left + right) / 2;

  struct node *node = (struct node *) malloc(sizeof (struct node));

  if (NULL != node) {
    node->data = a[mid];
    node->left = convert_BST(left, mid - 1, a);
    node->right = convert_BST(mid + 1, right, a);
  }

  return node;
}

/* Print the BST in sorted order i.e. inorder way */
void print_BST(struct node *node)
{
  if (node == NULL)
    return;

  print_BST(node->left);
  printf("%d", node->data);
  print_BST(node->right);
}

/* Main driver program */
int main(void)
{
  int a[] = {1, 2, 3, 4, 5, 6, 7};
  int left = 0;

  /* Get the number of elements */
  int right = (sizeof (a) / sizeof (a[0])) - 1;

  struct node *root = convert_BST(left, right, a);
  print_BST(root);

  printf("\n");

  return SUCCESS;
}
/* End of main driver program */

