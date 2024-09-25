var radio = prompt("Ingrese el valor del radio de una circunferencia:");

var pi = Math.PI;
var area = (pi * Math.pow(radio,2));
var perimetro = (2*pi*radio);

document.write("Area de la circunferencia: " +area+ "<br>");
document.write("Perimetro de la circunferencia: " +perimetro);
