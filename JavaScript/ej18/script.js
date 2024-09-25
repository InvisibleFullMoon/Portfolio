//A partir del siguiente array: var valores = [true, 5, false, "hola", "adios", 2]:
//a) Determinar cual de los dos elementos de texto es mayor
//b) Utilizando exclusivamente los dos valores booleanos del array, determinar los
//operadores necesarios para obtener un resultado true y otro resultado false
//c) Determinar el resultado de las cinco operaciones matemáticas realizadas con los
//dos elementos numéricos

let valores = [true, 5, false, "hola", "adios", 2];

function mostrarArray(array){
    document.getElementById("resultado").innerText = `Array: [${array.join(", ")}]`;
}


function determinarTextoMayor(valores){
    let texto1 = "";
    let texto2 = "";

    valores.forEach(e => {
        if(typeof e === "string"){
            if(texto1 === ""){
                texto1 = e;
            }else{
                texto2 = e;
            }
        }
    });

    // Ahora los comparamos
    if(texto1 < texto2){
        document.getElementById("resultadoTexto").innerText = `El texto mayor es: ${texto1}`;
    }else{
        document.getElementById("resultadoTexto").innerText = `El texto mayor es: ${texto2}`;
    }
}

function obtenerBooleanos(valores){
    let booleano1 = null;
    let booleano2 = null;

    valores.forEach(e => {
        if(typeof e === "boolean"){
            if(booleano1 === null){
                booleano1 = e;
            }else{
                booleano2 = e;
            }
        }
    });

    let resultadoTrue = booleano1 || booleano2;
    let resultadoFalse = booleano1 && booleano2;

    document.getElementById("resultadoBooleano").innerText = `Resultado true: ${resultadoTrue}\nResultado false: ${resultadoFalse}`;
}

function OperacionesAritmeticas(valores){
    let num1 = null;
    let num2 = null;

    valores.forEach(e => {
        if(typeof e === "number"){
            if(num1 === ""){
                num1 = e;
            }else{
                num2 = e;
            }
        }
    });

    let suma = num1 + num2;
    let resta = num1 - num2;
    let multiplicacion = num1 * num2;
    let division = num1 / num2;
    let mod = num1 % num2;

    document.getElementById("resultadoAritmetico").innerText = `Suma: ${suma}\nResta: ${resta}\nMultiplicación: ${multiplicacion}\nDivisión: ${division}\nMod: ${mod}`;

}

mostrarArray(valores);
determinarTextoMayor(valores);
obtenerBooleanos(valores);
OperacionesAritmeticas(valores);