#include <stdio.h>
#include <stdlib.h>

void QSort(int x[], int left, int right);
void Swap(int x[], int i, int j);

/* クイックソートを行う */
void QSort(int *x, int left, int right)
{
	int i, j;
	int pivot;

	i = left;                      /* ソートする配列の一番小さい要素の添字 */
	j = right;                     /* ソートする配列の一番大きい要素の添字 */

	pivot = x[(left + right) / 2]; /* 基準値を配列の中央付近にとる */

	while (1) {                    /* 無限ループ */

		while (x[i] < pivot)       /* pivot より大きい値が */
			i++;                   /* 出るまで i を増加させる */

		while (pivot < x[j])       /* pivot より小さい値が */
			j--;                   /*  出るまで j を減少させる */
		if (i >= j)                /* i >= j なら */
			break;                 /* 無限ループから抜ける */

		Swap(x, i, j);             /* x[i] と x[j]を交換 */
		i++;                       /* 次のデータ */
		j--;
	}
	if (left < i - 1)              /* 基準値の左に 2 以上要素があれば */
		QSort(x, left, i - 1);     /* 左の配列を Q ソートする */
	if (j + 1 <  right)            /* 基準値の右に 2 以上要素があれば */
		QSort(x, j + 1, right);    /* 右の配列を Q ソートする */
}

/* 配列の要素を交換する */
void Swap(int *x, int i, int j) {
	int temp;

	temp = x[i];
	x[i] = x[j];
	x[j] = temp;
}

int median (int *y, int n) {
	int *z = malloc(sizeof(int) * n), result, i = 0;
	while (i < n) {
		z[i] = y[i];
		i++;
	}
	QSort(z, 0, n - 1);
	result = z[n / 2];
	free(z);
	return result;
}

int main (void) {
	int N = -1, i, *x, *y;
	scanf("%d\n", &N);
	if (N % 2 != 0) return -1;
	i = 0;
	x = malloc(sizeof(int) * N);
	y = malloc(sizeof(int) * (N - 1));
	while (i < N) {
		scanf(" %d", &x[i]);
		i++;
	}
	i = 0;
	while (i < N - 1) {
		y[i] = x[i + 1];
		i++;
	}
	i = 0;
	while (i < N) {
		if (i > 0) {
			y[i - 1] = x[i - 1];
		}
		int med;
		med = median(y, N - 1);
		printf("%d\n", med);
		i++;
	}
	free(x);
	free(y);
	return 0;
}