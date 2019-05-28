// Programa C++ que lee la fecha actual y la fecha de nacimiento
// de una persona y calcula su edad
#include <iostream>
using namespace std;              
int fecha_valida(int , int, int);
int main()
{
   int diaa, mesa, anioa, dian, mesn, anion, edad;
   do
   {
       cout << "Introduce fecha actual: " << endl;
       cout << "dia : "; cin >> diaa;
       cout << "mes : "; cin >> mesa;
       cout << "a" << (char)164 << "o: "; cin >> anioa;
   }while(!(fecha_valida(diaa, mesa, anioa)));
   do
   {
       cout << endl << "Introduce fecha de nacimiento: " << endl;
       cout << "dia : "; cin >> dian;
       cout << "mes : "; cin >> mesn;
       cout << "a" << (char)164 << "o: ";  ; cin >> anion;
   }while(!(fecha_valida(dian, mesn, anion)));
}

int fecha_valida(int d, int m, int a) //definición de fecha_valida
{
    if(d < 1 or d > 31 or m < 1 or m > 12 or a < 1)
    {
        return 0;
    }
    switch(m)
    {
        case 4:
        case 6:
        case 9:
        case 11: if(d > 30)
                 {
                    return 0;
                 }
                 break;
        case 2: if(bisiesto(a))
                {
                    if(d > 29)
                    {
                       return 0;
                    }
                }
                else if(d > 28)
                     {
                        return 0;
                     }
                break;
    }
    return 1;
}
