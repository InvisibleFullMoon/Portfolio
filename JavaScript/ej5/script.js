//Realiza un programa que sólo permita introducir los caracteres ‘S’ y ‘N’. Si el usuario
//ingresa alguno de esos dos caracteres se deberá de imprimir un mensaje por pantalla
//que diga “CORRECTO”, en caso contrario, se deberá imprimir “INCORRECTO”.

let variable;

document.getElementById("enviado").onclick = function(){

    variable = document.getElementById("miTexto").value;

    if(variable == "S" || variable == "s" ||variable == "N" ||variable == "n"){
        window.alert("CORRECTO");
    }else{
        window.alert("INCORRECTO");
    }

}