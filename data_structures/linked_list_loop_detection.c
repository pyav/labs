/*
 * This code detects loop in a linked list.
 *
 * Output
 * ------
 *
 * Loop present!
 * 
 * 
 * Author
 * ------
 *
 * pyav
 */

#include <stdio.h>
#include <malloc.h>
#include <stdbool.h>
#include <stdlib.h>

#define SUCCESS true
#define FAILURE false

/* Node Structure */
struct node {
	int data;
	struct node *next;
};

/* Insert node */
bool push(struct node **head_ref, int data)
{
	struct node *one_node = (struct node *) malloc(sizeof (struct node));

	if (NULL == one_node) {
		perror("malloc");
		exit(EXIT_FAILURE);
	}

	one_node->data = data;
	one_node->next = (*head_ref);
	(*head_ref) = one_node;

	return SUCCESS;
}

/* Detect loop */
bool detect_loop(struct node *head_ref)
{
	struct node *slow = NULL;
	struct node *fast = NULL;

	if (NULL == head_ref)
		return FAILURE;

	slow = head_ref->next;

	if (NULL == slow)
		return FAILURE;

	fast = head_ref->next->next;

	while (slow && fast) {
		if (slow == fast)
			return SUCCESS;

		slow = slow->next;
		fast = fast->next;

		if (NULL == fast)
			return FAILURE;

		fast = fast->next;
	}
	
	return FAILURE;
}

/* Main driver code */
int main(void)
{
	struct node *head = NULL;

	/* Push elements in the linked list */
	push(&head, 1);
	push(&head, 2);
	push(&head, 3);
	push(&head, 4);

	/* Create loop */
	head->next->next->next = head;

	/* Detect loop */
	if (SUCCESS == detect_loop(head))
		printf("\nLoop present!\n");
	else
		printf("\nLoop absent!\n");

	return SUCCESS;
}

