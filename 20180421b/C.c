#include <stdio.h>
#include <stdlib.h>
#define MIN_P 1
#define MAX_P 5000
#define MIN_X 1
#define MAX_X 100000

int main (void) {
	int a, b, c, x, y, min_price, nx, ny;
	scanf("%d %d %d %d %d[^\n]", &a, &b, &c, &x, &y);
	if (a < MIN_P || a > MAX_P || b < MIN_P || b > MAX_P || c < MIN_P || c > MAX_P || x < MIN_X || x > MAX_X || y < MIN_X || y > MAX_X) return -1;
	if (x >= y) {
		min_price = (a + b <= 2 * c) ? (a + b) * y : 2 * c * y;
		nx = x - y;
		min_price = a * nx + min_price;
		min_price = (min_price <= 2 * x * c) ? min_price : 2 * x * c;
	} else {
		min_price = (a + b <= 2 * c) ? (a + b) * x : 2 * c * x;
		ny = y - x;
		min_price = b * ny + min_price;
		min_price = (min_price <= 2 * y * c) ? min_price : 2 * y * c;
	}
	printf("%d\n", min_price);
	return 0;
}