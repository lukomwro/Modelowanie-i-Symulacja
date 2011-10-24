#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define R 24
#define S 10

typedef unsigned long int uuint;

uuint Xtab[R];
uuint c = 0;
uuint m = (uuint) 1 << R;
uuint SWB(uuint n);
int main()
{
    srand(time(NULL));
    for (int i = 0; i < R; i++)
        Xtab[i] = (uuint) rand() % m;
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
uuint SWB(uuint n)
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
