//Construir un programa que simule un menú de opciones para realizar las cuatro
//operaciones aritméticas básicas (suma, resta, multiplicación y división) con dos valores
//numéricos enteros. El usuario, además, debe especificar la operación con el primer
//carácter de la operación que desea realizar: ‘S' o ‘s’ para la suma, ‘R’ o ‘r’ para la resta, ‘M’
//o ‘m’ para la multiplicación y ‘D’ o ‘d’ para la división.

let variable;
let variableDos;
let variableTres;
let calculo;

document.getElementById("boton").onclick = function(){

variable = document.getElementById("numeroUno").value;

}

document.getElementById("botonDos").onclick = function(){

    variableDos = document.getElementById("numeroDos").value;
    
}

document.getElementById("miBoton").onclick = function(){

    variableTres = document.getElementById("miInput").value;

    if(variableTres == "s" || variableTres == "S"){

       calculo = variable + variableDos;
       window.alert(variable + " + " + variableDos + " = " + calculo)

    }else if(variableTres == "r" || variableTres == "R"){

        calculo = variable - variableDos;
       window.alert(variable + " - " + variableDos + " = " + calculo)

    }else if(variableTres == "m" || variableTres == "M"){

        calculo = variable * variableDos;
       window.alert(variable + " * " + variableDos + " = " + calculo)

    }else if(variableTres == "d" || variableTres == "D")

        calculo = variable / variableDos;
       window.alert(variable + " / " + variableDos + " = " + calculo)

    }