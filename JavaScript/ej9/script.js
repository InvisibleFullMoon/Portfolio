//Realizar un programa que pida una frase y el programa deberá mostrar la frase con un
//espacio entre cada letra. La frase se mostrara así: H o l a. Nota: recordar el
//funcionamiento de la función Substring().



document.getElementById("miBoton").onclick = function(){

    let palabra = document.getElementById("miInput").value;

    //palabra = String.slice(' '); asi no
    let palabraConEspacios = palabra.split('').join(' ');

    //document.getElementById("resultado").innerText = `
    // ${ palabra }                          esto esta mal
    //`

    document.getElementById("resultado").innerText = palabraConEspacios;


}