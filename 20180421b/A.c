// AtCoder Beginner Contest 095
#include <stdio.h>
#define LENGTH 3

int main (void) {
	char c[LENGTH + 1];
	int i = 0, price = 700;
	scanf("%s[^\n]", c);
	while (i < LENGTH) {
		if (c[i] == 'o') price += 100;
		i++;
	}
	printf("%d\n", price);
	return 0;
}