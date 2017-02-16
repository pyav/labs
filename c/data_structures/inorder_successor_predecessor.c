/*
 * This program first creates a BST, then searches for inorder
 * predecessor and inorder successor of a given key. 
 *
 * It also frees memory of the BST through free_all()
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

/* Return a new node */
struct node *new_node(int data)
{
  struct node *one_node = (struct node *) malloc(sizeof (struct node));
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
  if (node == NULL) {
    node = new_node(data);
    return node;
  }

  if (data < node->data) {
    node->left = insert_node(node->left, data);
  } else {
    node->right = insert_node(node->right, data);
  }

  return node;
}

/* Print tree inorder */
void print_inorder(struct node *node)
{
  if (node != NULL) {
    print_inorder(node->left);
    printf("%d ", node->data);
    print_inorder(node->right);
  }
}

/* Function to find predecessor and successor */
void find_pre_suc(struct node *node, 
    struct node **pre, 
    struct node **suc, 
    int key)
{
  if (node == NULL)
    return;

  if (node->data == key) {
    /* Find predecessor now */
    if (node->left != NULL) {
      struct node *tmp = node->left;
      while (tmp->right != NULL)
        tmp = tmp->right;

      (*pre)->data = tmp->data;
    }

    /* Find successor now */
    if (node->right != NULL) {
      struct node *tmp = node->right;
      while (tmp->left != NULL)
        tmp = tmp->left;

      (*suc)->data = tmp->data;
    }

    return;
  }

  /* Look for the node in the left subtree if the key is smaller */
  if (key < node->data) {
    (*suc)->data = node->data;
    find_pre_suc(node->left, pre, suc, key);
  } 
  /* Look for the node in the right subtree if the key is bigger */
  else {
    (*pre)->data = node->data;
    find_pre_suc(node->right, pre, suc, key);
  }
}

/* Free the BST */
void free_all(struct node **node)
{
  if (*node == NULL)
    return;

  free_all(&(*node)->left);
  free_all(&(*node)->right);
  free(*node);
  *node = NULL;
}

/* Main driver code */
int main(void) 
{
  int key = -1;
  struct node *pre = (struct node *) calloc(1, sizeof (struct node));
  struct node *suc = (struct node *) calloc(1, sizeof (struct node));

  /*
   * Make the BST with the following data:
   * 50, 30, 20, 40, 70, 60, 80
   */
  struct node *root = insert_node(NULL, 50);
  insert_node(root, 30);
  insert_node(root, 20);
  insert_node(root, 40);
  insert_node(root, 70);
  insert_node(root, 60);
  insert_node(root, 80);

  /* Print tree inorder */
  print_inorder(root);

  printf("\nThe BST is created, enter the key for inorder "
      "successor and inorder predecessor: ");
  scanf("%d", &key);

  /* Find inorder predecessor and successor */
  find_pre_suc(root, &pre, &suc, key);

  printf("The predecessor is: %d\n", pre->data);
  printf("The successor is: %d\n", suc->data);

  free(pre);
  free(suc);
  free_all(&root);

  return SUCCESS;
}
/* End of main driver code */

