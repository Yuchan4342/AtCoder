#include <stdio.h>
#include <stdlib.h>
#define MIN_N 2
#define MAX_N 100
#define MAX_M 1000
#define MAX_X 100000

int main (void) {
	int i, n, x, *m, result, min = MAX_M;
	scanf("%d %d[^\n]", &n, &x);
	if (n < MIN_N || n > MAX_N || x > MAX_X) return -1;
	m = malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", m + i);
		if (min > m[i]) min = m[i];
		x -= m[i];
	}
	if (x < 0) return -1; 
	result = n + x / min;
	printf("%d\n", result);
	return 0;
}