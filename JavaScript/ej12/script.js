//Escribir una función flecha de JavaScript que reciba un argumento y retorne el tipo de
//dato.

const leerInput = userInput => {
    if (!isNaN(userInput) && userInput.trim() !== "") {
        return "number";
    } else if (userInput.toLowerCase() === "true" || userInput.toLowerCase() === "false") {
        return "boolean";
    } else {
        return "string";
    }
}

document.getElementById("miBoton").onclick = function () {

    let palabra = document.getElementById("miInput").value;

    let aux = leerInput(palabra);

    document.getElementById("resultado").innerText = aux;
}