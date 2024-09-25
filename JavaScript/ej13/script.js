//Crear un objeto persona, con las propiedades nombre, edad, sexo ('H' hombre, 'M' mujer,
//   'O' otro), peso y altura. A continuación, muestre las propiedades del objeto JavaScript.

const persona1 = {
    nombre: "Emanuel",
    edad: 25,
    sexo: "H",
    peso: 80,
    altura: 180,
};

document.getElementById("resultado").innerText =`
Nombre: ${persona1.nombre}
Edad: ${persona1.edad}
Sexo: ${persona1.sexo}
Peso: ${persona1.peso} kg
Altura: ${persona1.altura} cm
`;

