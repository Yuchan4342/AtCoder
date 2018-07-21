#include <stdio.h>
#include <stdlib.h>
#define MIN_N 1
#define MAX_N 100000
#define MIN_C 2
#define MAX_C 100000000000000

int main (void) {
	int n, *v, i;
	long int c, *x, max = 0, cal;
	scanf("%d %ld[^\n]", &n, &c);
	if (n < MIN_N || n > MAX_N || c < MIN_C || c > MAX_C) return -1;
	x = malloc(sizeof(long int) * n);
	v = malloc(sizeof(int) * n);
	i = 0;
	while (i < n) {
		scanf("%ld %d[^\n]", x + i, v + i);
		i++;
	}
	i = 0, cal = 0;
	while (i < n) {
		if (i == 0) cal = v[i] - x[i];
		else cal += v[i] - (x[i] - x[i - 1]);
		if (cal > max) max = cal;
		i++;
	}
	cal = 0, i = n - 1;
	while (i >= 0) {
		if (i == n - 1) cal = v[i] - (c - x[i]);
		else cal += v[i] - (x[i + 1] - x[i]);
		if (cal > max) max = cal;
		i--;
	}
	printf("%ld\n", max);
	return 0;
}