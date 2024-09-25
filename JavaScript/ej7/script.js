//Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación
//solicite números al usuario hasta que la suma de los números introducidos supere el
//límite inicial.

let contador = 0;
let limite;

document.getElementById("botonUno").onclick = function(){

    limite = parseFloat(document.getElementById("inputUno").value);
}

document.getElementById("botonDos").onclick = function(){
    
    let variable = parseFloat(document.getElementById("inputDos").value);
    
    contador += variable;

    if(contador>limite){
        window.alert("la suma de los números introducidos ha superado el límite. Suma actual: " + contador);
    }else{
        window.alert("suma actual: "+contador)
    }
}