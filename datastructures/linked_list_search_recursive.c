/*
 * This code demonstrates the recursive search on a linked list.
 * 
 *
 * Output
 * ------
 *
 * 4 3 2 1 
 * 3: Yes
 * 1: Yes
 * 2: Yes
 * 14: No
 * 4: Yes
 * 11: No
 * 12: No
 *
 *
 * Author
 * ------
 *
 * pyav
 */

#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <stdbool.h>

#define SUCCESS 0

/* Structure node */
struct node {
  int data;
  struct node *next;
};

/* Add node */
void add_node(struct node **node, int data)
{
  struct node *temp = (struct node *) malloc(sizeof (struct node));

  if (temp == NULL) {
    perror("malloc");
    exit(EXIT_FAILURE);
  }

  temp->data = data;
  temp->next = *node;
  (*node) = temp;
}

/* Print nodes */
void print_nodes(struct node *node)
{
  struct node *temp = node;

  while (NULL != temp) {
    printf("%d ", temp->data);
    temp = temp->next;
  }
}

/* Find a node having data recursively */
bool find_node(struct node *node, int data)
{
  if (node == NULL)
    return false;
  else if (node->data == data)
    return true;
  else
    if (true == find_node(node->next, data))
      return true;
    else
      return false;
}

/* Main driver code */
int main(void)
{
  struct node *head = NULL;

  /* Create the list */
  add_node(&head, 1);
  add_node(&head, 2);
  add_node(&head, 3);
  add_node(&head, 4);

  /* Print all the node data */
  print_nodes(head);

  /* Test cases to check and print whether a particular number is present */
  find_node(head, 3)? printf("\n3: Yes\n"): printf("\n3: No\n");
  find_node(head, 1)? printf("1: Yes\n"): printf("1: No\n");
  find_node(head, 2)? printf("2: Yes\n"): printf("2: No\n");
  find_node(head, 14)? printf("14: Yes\n"): printf("14: No\n");
  find_node(head, 4)? printf("4: Yes\n"): printf("4: No\n");
  find_node(head, 11)? printf("11: Yes\n"): printf("11: No\n");
  find_node(head, 12)? printf("12: Yes\n"): printf("12: No\n");

  return SUCCESS;
}

