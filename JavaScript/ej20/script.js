// Realizar un programa que obtenga la siguiente matriz [[3], [6], [9], [12], [15]] y devuelve y
// muestre el siguiente array [6, 9, 12, 15, 18].

let matriz = [[3],[6],[9],[12],[15]];

function mostrarMatriz(array){
    return `Matriz: [${array.map(subArray => `[${subArray.join(", ")}]`).join(", ")}]`;
}

function mostrarArray(array){
    return `Arreglo: [${array.join(", ")}]`;
}

function transferir(matriz){
    //let array = [].concat.apply([], matriz);
    let array = matriz.map(subArray => subArray[0]);

    array.pop()
    array.push(18)

    return array;
}

document.getElementById("resultado").innerText = mostrarMatriz(matriz);

document.getElementById("resultadoFinal").innerText = mostrarArray(transferir(matriz));
