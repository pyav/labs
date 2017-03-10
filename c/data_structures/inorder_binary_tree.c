#include <stdio.h>
#include <malloc.h>

#define SUCCESS 0
#define FAILURE 1

struct node {
	int data;
	struct node *left;
	struct node *right;
};

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

struct node *insert_node(struct node *node, int data)
{
	if (node == NULL) {
		return new_node(data);
	}

	if (data < node->data) {
		node->left = insert_node(node->left, data);
	} else if (data > node->data){
		node->right = insert_node(node->right, data);
	}

	return node;
}

void print_tree_inorder(struct node * node)
{
	if (node != NULL) {
		print_tree_inorder(node->left);
		printf("%d ", node->data);
		print_tree_inorder(node->right);
	}
}

int main(void)
{
	struct node *root = NULL;
	root = insert_node(root, 50);
	insert_node(root, 10);
	insert_node(root, 55);
	insert_node(root, 70);
	insert_node(root, 40);
	insert_node(root, 30);

	print_tree_inorder(root);
	printf ("\n");

	return SUCCESS;
}

