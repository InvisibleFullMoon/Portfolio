// Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo A
// de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
// programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por pantalla.
// Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros 10 números
// ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos elementos con el valor
// 0.5. Mostrar los dos arreglos resultantes: el ordenado de 50 elementos y el combinado
// de 20.

ArregloA = [];
ArregloB = [];
ArregloAUX= [];

function generarAleatorio(){
    return Math.floor(Math.random() * 100); // Genera un número aleatorio entre 0 y 100
}

function llenarArray(array){
    for (let i = 0; i < 50; i++) {
        array.push(generarAleatorio());
    }
}

function mostrarArray(array){
    return `Arreglo: [${array.join(", ")}]`;
}

llenarArray(ArregloA);

document.getElementById("resultado").innerText = mostrarArray(ArregloA);

ArregloAUX = ArregloA;

ArregloAUX.sort((a,b)=> a -b);

document.getElementById("resultadoOrdenado").innerText = mostrarArray(ArregloAUX);

for(let i = 0; i < 10; i++){
    ArregloB.push(ArregloA[i]);
}

for(let i = 10; i < 20; i++ ){
    ArregloB.push(0.5);
}

document.getElementById("resultadoB").innerText = mostrarArray(ArregloB);
