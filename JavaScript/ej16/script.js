//Realizar un programa que rellene dos vectores al mismo tiempo, con 5 valores aleatorios
//y los muestre por pantalla.

let array1 = [];
let array2 = [];
//let x = Math.floor(Math.random() * 6) + 1;

function generarAleatorio(){
    return Math.floor(Math.random() * 100) + 1; // Genera un número aleatorio entre 1 y 100
}

function llenarArrays(){
    for (let i = 0; i < 5; i++) {
        array1.push(generarAleatorio());
        array2.push(generarAleatorio());

    }
}

// function mostrarArray(array1, array2) {
//     for (let i = 0; i < 4; i++) {
//         array = [i];
//     }
// }

function mostrarArrays(array1, array2){

    return `Array 1: ${array1.join(", ")}\nArray 2: ${array2.join(", ")}`;

}

document.getElementById("vectorBoton").onclick = function () {
// Reiniciar los arrays
    array1 = [];
    array2 = [];

    llenarArrays();
    
    document.getElementById("resultado").innerText = mostrarArrays(array1, array2);
}
