class Vehiculo:
    '''
    Definir una clase padre llamada vehiculo y 2 clases hijas:
    Auto y bicicleta, las cuales heredan de la lase Padre Vehiculo. la clase
    padre debe tener los siguientes atributos y metodos:
    Vehiculo (clase padre)
    -Atributos(color, ruedas)
    -Metodos(__init__(color, ruedas) y __str__())
    Auto (clase hija del vehiculo)
    -Atributos (velocidad KM/hr))
    -Metodos (__init__(color,  ruedas, velocidad) y __str__())
    Bicicleta (Clase hija del Vehiculo)
     -Atributos (tipo montaña/urbana/etc.)
    -Metodos (__init__(color,  ruedas, tipo) y __str__()
    Crear un objeto de cada clase
    '''

    def __init__(self, color, ruedas,):
        self.color = color
        self.ruedas = ruedas

    def __str__(self):
        return 'color: '+self.color+' Ruedas: ' + str(self.ruedas)

class Auto(Vehiculo):
    def __init__(self, color, ruedas, velocidad):
        super().__init__(color, ruedas)
        self.velocidad = velocidad

    def __str__(self):
        return super().__str__() + ', Velocidad(km/hr): ' + str(self.velocidad)


class Bicicleta(Vehiculo):
    def __init__(self, color, ruedas, tipo):
        super().__init__(color, ruedas)
        self.tipo = tipo

    def __str__(self):
        return super().__str__() + ', Tipo:  ' + self.tipo


# Primer objeto de la clase Vehiculo
Vehiculo = Vehiculo('Blanco', 4)
print(Vehiculo)

# Segundo objeto, pero ahora de la clase Auto
auto = Auto('Amarillo', 4, 120)
print(auto)

# Tercer objeto, el ultimo de la calse Bicicleta
bici = Bicicleta('Azul', 2, 'Urbana')
print(bici)
