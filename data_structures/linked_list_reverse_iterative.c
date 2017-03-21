/*
 * This code demonstrates iterative reversal of linked list.
 * 
 * 
 * Output
 * ------
 *
 * 4 3 2 1 
 * 1 2 3 4 
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

#define SUCCESS 0

/* Structure, singly linked list */
struct node {
  int data;
  struct node *next;
};

/* Print the linked list */
void print_linked_list(struct node *head)
{
  struct node *temp = head;

  while (NULL != temp) {
    printf("%d ", temp->data);
    temp = temp->next;
  }

  printf("\n");
}

/* Add a new node */
void add_node(struct node **head, int data)
{
  struct node *one_node = malloc(sizeof (struct node));

  if (NULL == one_node) {
    perror("malloc");
    exit(EXIT_SUCCESS);
  }

  one_node->data = data;
  one_node->next = *head;
  (*head) = one_node;
}

/* Reverse the linked list */
void reverse_linked_list(struct node **head)
{
  struct node *current = *head;
  struct node *prev = NULL;
  struct node *next = NULL;

  while (current != NULL) {
    next = current->next;
    current->next = prev;
    prev = current;
    current = next;
  }

  *head = prev;
}

/* Main driver code */
int main(void)
{
  struct node *head = NULL;

  /* Create linked list */
  add_node(&head, 1);
  add_node(&head, 2);
  add_node(&head, 3);
  add_node(&head, 4);

  /* Print, reverse and print linked list */
  print_linked_list(head);
  reverse_linked_list(&head);
  print_linked_list(head);

  return SUCCESS;
}

