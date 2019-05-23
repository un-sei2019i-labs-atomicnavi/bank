// Programa C++ que lee la fecha actual y la fecha de nacimiento
// de una persona y calcula su edad
#include <iostream>
using namespace std;
int bisiesto(int);
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
   edad = calcular_edad(diaa, mesa, anioa, dian, mesn, anion);
   cout << endl << "Edad : " << edad << endl << endl;
   system("pause"); 
}              

int bisiesto(int a)  // definición de la función bisiesto
{
    if(a%4==0 and a%100 !=0 or a%400==0)
        return 1;
    else
        return 0;
}

