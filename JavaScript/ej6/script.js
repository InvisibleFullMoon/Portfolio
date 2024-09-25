//Realizar un programa que, dado un número entero, visualice en pantalla si es par o impar.
//En caso de que el valor ingresado sea 0, se debe mostrar “el número no es par ni impar”.

let variable;

document.getElementById("miBoton").onclick = function(){
    variable = document.getElementById("miInput").value;

    if(variable == 0){

        window.alert("el número no es par ni impar");

    }else if(variable % 2 == 0){
        window.alert("el numero es par")
    }else{
        window.alert("el numero es impar")
    }
}
