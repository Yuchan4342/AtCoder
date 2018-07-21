#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define Q 10

int isPayable(int N, const int islike[Q]);
int main (int argc, char *argv[]) {
	int N, K, i, islike[Q], dislike;
	scanf("%d %d[^\n]", &N, &K);
	if (N < 1 || N >= 10000 || K < 1 || K >= Q) return -1;
	for (i = 0; i < Q; i++) islike[i] = 1;
	for (i = 0; i < K; i++) {
		scanf("%d", &dislike);
		if (dislike >= 0 && dislike < Q) islike[dislike] = 0;
	}
	scanf("[^\n]");
	while (isPayable(N, islike) == 0) N++;
	printf("%d\n", N);
	return 0;
}

int isPayable(int N, const int islike[Q]) {
	if (islike[N % Q] == 0) return 0;
	if (N >= Q) {
		N /= Q;
		return isPayable(N, islike);
	}
	return 1;
}