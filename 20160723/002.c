#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Compare(const char *s1, const char *s2);
int main (int argc, char *argv[]) {
	int N, L, i, j, minj;
	scanf("%d %d[^\n]", &N, &L);
	if (N < 1 || N > 100 || L < 1 || L > 100) return -1;
	char **S, *min, *result;
	S = malloc(N * sizeof(char*));
	min = malloc((L + 1) * sizeof(char));
	result = malloc(N * (L + 1) * sizeof(char));
	for (i = 0; i < N; i++) {
		S[i] = malloc((L + 1) * sizeof(char));
		if (scanf("%s[^\n]", S[i]) != 1) return -1;
	}
	strcpy(result, "");
	for (i = 0; i < N; i++) {
		minj = -1;
		strcpy(min, "");
		for (j = 0; j < N; j++) {
			if (S[j] != NULL) {
				if (Compare(min, S[j]) > 0 || !strcmp(min, "")) {
					strcpy(min, S[j]);
					minj = j;
				}
			}
		}
		strcat(result, min);
		S[minj] = NULL;
	}
	printf("%s\n", result);
	return 0;
}

int Compare(const char *s1, const char *s2) {
	while (*s1 == *s2) {
		if (*s1 == '\0')
			return (0);
		s1++;
		s2++;
	}
	return (*s1 - *s2);
}