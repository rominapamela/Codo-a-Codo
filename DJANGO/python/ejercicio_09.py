"""
Hacer un algoritmo con una función de búsqueda por DNI que devuelva 
los datos del alumno. El algoritmo debe permitir el ingreso de los
siguientes datos del alumno: DNI, Apellido y Nombre de los alumnos.
(utilizar arreglo y función)
"""
from os import system


def agregar_alumnos(alumnos=[]):
    dni=(str(input('ingresar dni      :')))
    nombre=(input('ingresar nombre   :'))
    alumnos.append([dni,nombre])
    input()
    return alumnos

def buscar_x_dni(alumnos=[]):
    dni=str(input('ingresar dni: '))
    for i in range(len(alumnos)):
        if alumnos[i][0]==dni:
            return 'NOMBRE['+alumnos[i][1]+']'
    return 'alumno no encontrado'

def mostrar_alumnos(alumnos=[]):
    if len(alumnos)==0:
        print('no hay registros de alumnos')
    else:
         for i in range(len(alumnos)):
            print(f'DNI=[{alumnos[i][0]}] | NOMBRE=[{alumnos[i][1]}]')
    input()

if __name__=='__main__':
    alumnos=[]
    salida=False
    while salida is False:
        system('cls')
        print('\n1. mostrar alumnos\n2. agregar alumno\n3. buscar alumno por dni\n4. salir')
        opc=int(input())
        if opc==1:
            mostrar_alumnos(alumnos)
        if opc==2:
            alumnos=agregar_alumnos(alumnos)
        if opc==3:
            print(buscar_x_dni(alumnos))
            input()
        if opc==4:
            salida=True
