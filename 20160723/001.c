#include <stdio.h>

int main (int argc, char *argv[]) {
	int a[3], i, j5 = 0, j7 = 0;
	scanf("%d %d %d[^\n]", &a[0], &a[1], &a[2]);
	for (i = 0; i < 3; i++) {
		if (a[i] == 5) j5++;
		else if (a[i] == 7) j7++;
	}
	if (j5 == 2 && j7 == 1) printf("YES\n");
	else printf("NO\n");
	return 0;
}
