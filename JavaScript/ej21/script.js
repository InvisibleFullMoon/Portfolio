// Escribir un programa para obtener un array de las propiedades de un objeto Persona.
// Las propiedades son nombre, edad, sexo ('H' hombre, 'M' mujer, 'O' otro), peso y altura.

const persona = {
    nombre: "Emanuel",
    edad: 25,
    sexo: "H",
    peso: 85,
    altura: 170,
};

document.getElementById("resultado").innerText =`
Nombre: ${persona.nombre}
Edad: ${persona.edad}
Sexo: ${persona.sexo}
Peso: ${persona.peso} kg
Altura: ${persona.altura} cm
`;

function mostrarArray(array){
    return `Arreglo: [${array.map(pair => `${pair[0]}: ${pair[1]}`).join(", ")}]`;
}

function guardarObjeto(persona){
    return Object.entries(persona);
}

const propiedadesArray = guardarObjeto(persona)
document.getElementById("resultadoDespues").innerText = mostrarArray(propiedadesArray);

