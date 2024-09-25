//Escribe un programa JavaScript para calcular el área y el perímetro de un objeto Círculo
//con la propiedad radio. Nota: Cree dos métodos para calcular el área y el perímetro. El
//radio del círculo lo proporcionará el usuario.

const pi = Math.PI;

const circulo = {
    area: 0,
    perimetro: 0,
    radio: 0,
};
 

function calcularPerimetro(radio){
     circulo.perimetro= (2*pi*radio);
}

function calcularArea(radio){
    circulo.area = (pi * Math.pow(radio,2));
}

function mostrarCirculo() {
    document.getElementById("resultado").innerText = `
Radio: ${circulo.radio}
Area: ${circulo.area}
Perimetro: ${circulo.perimetro}
`;
}

document.getElementById("radioBoton").onclick = function(){

    circulo.radio = parseFloat(document.getElementById("radioInput").value);

    calcularPerimetro(circulo.radio);
    calcularArea(circulo.radio);

    mostrarCirculo();

}