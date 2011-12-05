#include <stdlib.h>
#include <time.h>
using namespace std;
#define ILOSC_TESTOW 50


int main() {
    int ZLI[10];
    for (int i=0; i<10; i++) {
        ZLI[i] = 0;
    }
    for (int i=0; i<ILOSC_TESTOW; i++) {
        int x = rand() % 10; //random nasz
        ZLI[x]++;
    }

    int sumZ = 0;
    for (int i=0; i<10; i++) {
        ZLI[i] *= ZLI[i];
        sumZ += ZLI[i];
    }
    double V = 1.0/(double)ILOSC_TESTOW * (double)sumZ * 10.0 - 50;
    printf("%lf\n", V);
    return 0;
}
