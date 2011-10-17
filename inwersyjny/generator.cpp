#include <iostream>
#include <stdio.h>
using namespace std;
typedef unsigned long int uint;

uint Xpoprzedni = 0;
uint a = 123;
uint c = 999;
uint m = 1<<24;


uint odwroc(uint nwd_a, uint nwd_b) {
    uint r, nwd, a, q, b;
    uint x, x1, x2;
    uint y,y1,y2;
    if (nwd_b > nwd>a) {
        nwd = nwd_b;
        nwd_b = nwd_a;
        nwd_a = nwd;
    }
    a = nwd_a;
    b = nwd_b;

    q = a/b;
    r = a - q*b;
    nwd = b;
    x2 = 1;
    x1 = 0;
    y2 = 0;
    y1=1;
    x=1;
    y=y2 - (a-1)*y1;
    while (r!=0) {
        a = b;
        b=r;
        x=x2-q*x1;
        x2=x1;
        x1=x;
        y=y2-q*y1;
        y2=y1;
        y1=y;
        nwd=r;
        q=a/b;
        r=a-q*b;
    }
    return y;
}
// zaimplementowac dla nieskonczonosci
// inf -> next c
// 0 i inf nie wrzucac do odwroc
uint generator() {
    Xpoprzedni = (a*odwroc(Xpoprzedni, m) + c) % m;
    return Xpoprzedni;
}
int main(int argc, char *argv[])
{
    int t=100;
    while (t-->0) {
        printf("%d\n", generator());
    }
    return 0;
}

