// Programa C++ que lee la fecha actual y la fecha de nacimiento
// de una persona y calcula su edad
#include <iostream>
using namespace std;
int calcular_edad(int, int, int, int, int, int);
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

int calcular_edad(int da, int ma, int aa, int dn, int mn, int an)
{
    int edad = aa - an;
    if(ma < mn)
       edad--;
    else if(ma == mn and da < dn)
            edad--;
    return edad;
   
}                    
