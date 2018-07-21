#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXHW 100000
#define N 1000000007

long int pattern(int H, int W, const int cW, int A, int B);
int isAble(int H, int W, const int cW, int A, int B);
int main (int argc, char *argv[]) {
	int H, W, A, B;
	scanf("%d %d %d %d[^\n]", &H, &W, &A, &B);
	if (H < 1 || H >= MAXHW || W < 1 || W >= MAXHW) return -1;
	if (A < 1 || A >= H || B < 1 || B >= W) return -1;
	printf("%ld\n", pattern(H, W, W, A, B) % N);
	return 0;
}

long int pattern(int H, int W, const int cW, int A, int B) {
	long int ret = 0;
	if (H == 1 && W == 1) return 1;
	if (isAble(H, W - 1, cW, A, B)) ret += pattern(H, W - 1, cW, A, B);
	if (isAble(H - 1, W, cW, A, B)) ret += pattern(H - 1, W, cW, A, B);
	return ret;
}

int isAble(int H, int W, const int cW, int A, int B) {
	if (H < 1 || W < 1) return 0;
	if (H <= A && W > cW - B) return 0;
	return 1;
}