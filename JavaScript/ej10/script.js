//Escribir una función flecha que reciba una palabra y la devuelva al revés.

//document.getElementById("miBoton").onclick = function(){
//    let palabra = document.getElementById("miInput").value;
//    let palabraConEspacios = palabra.split('').reverse().join('');
//    document.getElementById("resultado").innerText = palabraConEspacios;
//}

//creamos la funcion afuera de la parte DOM, la constante recibe un string, separa cada caracter, lo invierte y lo vuelve a unir.
const invertirPalabra = palabra => palabra.split('').reverse().join('');

//hacemos la parte DOM igual a siempre
document.getElementById("miBoton").onclick = function () {

    let palabra = document.getElementById("miInput").value;

    //creamos una variable para guardar el resultado de la funcion flecha.
    let palabraInvertida = invertirPalabra(palabra);

    document.getElementById("resultado").innerText = palabraInvertida;
}
