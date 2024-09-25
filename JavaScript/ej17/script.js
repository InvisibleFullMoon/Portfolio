//Realizar un programa que elimine los dos últimos elementos de un array. Mostrar el
//resultado

let array = [];

function generarAleatorio(){
    return Math.floor(Math.random() * 100) + 1; // Genera un número aleatorio entre 1 y 100
}

function llenarArray(){
    for (let i = 0; i < 5; i++) {
        array.push(generarAleatorio());
    }
}

function mostrarArray(array){
    return `Array: ${array.join(", ")}`;
}

llenarArray(array);

document.getElementById("resultadoAntes").innerText = mostrarArray(array);

document.getElementById("boton").onclick = function(){
    array.pop();
    array.pop();

    document.getElementById("resultadoDespues").innerText = mostrarArray(array);
}

