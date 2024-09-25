//Escribir una función que reciba un String y devuelva la palabra más larga.
//String Ejemplo: “Guia de JavaScript”
//Resultado esperado : “JavaScript”

//let largo = null; no es necesaria como varible global

// function separarTexto(texto){
//     let textoSeparado = texto.split(" ");
//     let largo = null;

//     textoSeparado.forEach(e => {

//         if (largo == null || e.length > largo.length){
//             largo = e;
//         }
//     });
//     return largo;
// }

function separarTexto(texto) {
    let textoSeparado = texto.split(" ");
    let palabraMasLarga = "";

    textoSeparado.forEach(e => {
        console.log(`Comparando: ${e} (longitud: ${e.length}) con ${palabraMasLarga} (longitud: ${palabraMasLarga.length})`);
        if (e.length > palabraMasLarga.length) {
            palabraMasLarga = e;
        }
    });

    return palabraMasLarga;
}

document.getElementById("miBoton").onclick = function() {
    let frase = document.getElementById("miInput").value;
    let palabraMasLarga = separarTexto(frase);
    document.getElementById("resultado").innerText = palabraMasLarga;
};