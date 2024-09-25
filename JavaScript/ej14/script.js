//Crear un objeto libro que contenga las siguientes propiedades: ISBN, Título, Autor,
//Número de páginas. Crear un método para cargar un libro pidiendo los datos al usuario
//y luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
//numero de páginas.

const libro = {
    ISBN: "",
    Autor: "",
    Titulo: "",
    Numero_de_paginas: "0",
};


function cargarISBN() {
    const isbnInput = document.getElementById("isbnInput").value;
    libro.ISBN = isbnInput;
}

function cargarTitulo() {
    const tituloInput = document.getElementById("tituloInput").value;
    libro.Titulo = tituloInput;
}

function cargarAutor() {
    const autorInput = document.getElementById("autorInput").value;
    libro.Autor = autorInput;
}

function cargarPaginas() {
    const paginasInput = document.getElementById("paginasInput").value;
    libro.Numero_de_paginas = paginasInput;
}

function mostrarLibro() {
    document.getElementById("resultado").innerText = `
ISBN: ${libro.ISBN}
Titulo: ${libro.Titulo}
Autor: ${libro.Autor}
Numero de paginas: ${libro.Numero_de_paginas}
`;
}

document.getElementById("isbnBoton").onclick = cargarISBN;
document.getElementById("tituloBoton").onclick = cargarTitulo;
document.getElementById("autorBoton").onclick = cargarAutor;
document.getElementById("paginasBoton").onclick = cargarPaginas;
document.getElementById("mostrarBoton").onclick = mostrarLibro;

