//Escribir un programa que lea números enteros hasta teclear 0 (cero). Al finalizar el
//programa se debe mostrar el máximo número ingresado, el mínimo, y el promedio de
//todos ellos.

let numeros = [];
let maximo = null;
let minimo = null;
let suma = 0;


document.getElementById("agregarNumero").onclick = function () {
    
    let numero = parseFloat(document.getElementById("numeroInput").value);

    if (isNaN(numero)) {
        window.alert("Por favor, ingrese un número válido.");
        return;
    }

    if (numero === 0) {
        if (numeros.length === 0) {
            window.alert("No se ingresaron numeros.")
            return;
        }
        let promedio = suma / numeros.length;
        document.getElementById("resultado").innerText = `
        Máximo: ${ maximo }
        Mínimo: ${ minimo }
        Promedio: ${ promedio.toFixed(2) }
        `;
        return;
    }

    numeros.push(numero);
    suma += numero;

    if (maximo === null || numero > maximo) {
        maximo = numero;
    }
    if (minimo === null || numero < minimo) {
        minimo = numero;
    }


    document.getElementById("numeroInput").value = '';
    document.getElementById("numeroInput").focus();


}

