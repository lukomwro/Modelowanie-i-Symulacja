#include <stdio.h>
#include <stdlib.h>
#include <time.h>
typedef unsigned long long uint ;

#define R 24
#define S 10

uint Xtab[R];
uint c = 0;
uint m = (uint) 1 << R;
uint SWB(uint n);
int main()
{
    srand(time(NULL));
    for (int i = 0; i < R; i++)
        Xtab[i] = (uint) rand() % m;
	for(int i = 0; i < 1000; i++) {
        printf("%u,", SWB(i%R));
	}
	printf("%u", SWB(0));
    return 0;
}

/*
*	http://www.algorytm.org/liczby-pseudolosowe/generator-swbg-generator-odejmowanie-z-pozyczka.html
*
*/
uint SWB(uint n)
{   
	if (Xtab[(R + n - S) % R] >= Xtab[n] + c) {
		Xtab[n] = Xtab[(R + n - S) % R] - Xtab[n] - c;
		c = 0;
	}else {
		Xtab[n] = m - ((Xtab[n] + c) - Xtab[(R + n - S) % R]);
		c = 1;
	}
	return Xtab[n];
}