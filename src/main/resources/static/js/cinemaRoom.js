addEventListener('DOMContentLoaded', () => {
    cargarSala();
});

const contenedorAsientos = document.querySelector('.asientos');
const abecedario = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

let precioTotal = 0;
let asientosSeleccionados = [];

async function cargarSala() {
    try {
        const APIurl = 'api/cinemaRoom/1';
        const response = await fetch(APIurl);
        const cinemaRoom = await response.json();
        console.log(cinemaRoom);
        console.log(contenedorAsientos);
        crearAsientos(cinemaRoom);

    } catch (error) {
        console.log(error);
    }
}

function generarImagen() {
    const imagenAsiento = document.createElement('img');
    imagenAsiento.setAttribute('src', '../img/asiento-tradicional.png');
    imagenAsiento.setAttribute('width', '40px');
    imagenAsiento.setAttribute('height', '40px');
    return imagenAsiento;
}

function manejarClickAsiento(i, j, cinemaRoom) {
    return () => {
        const asientoActual = `${abecedario[i - 1]}${j}`;
        const precioAsiento = cinemaRoom.seatPrice;

        // Verificar si el asiento ya ha sido seleccionado
        const indiceAsiento = asientosSeleccionados.indexOf(asientoActual);
        if (indiceAsiento !== -1) {
            // El asiento ya está seleccionado, por lo tanto, se deselecciona
            asientosSeleccionados.splice(indiceAsiento, 1);
            // Restar el precio del asiento deseleccionado al precio total
            precioTotal -= precioAsiento;

            console.log(`Asiento ${asientoActual} deseleccionado. Precio: ${precioAsiento}. Precio Total: ${precioTotal}`);
        } else {
            // El asiento no ha sido seleccionado, por lo tanto, lo seleccionamos
            asientosSeleccionados.push(asientoActual);
            // Sumar el precio del asiento seleccionado al precio total
            precioTotal += precioAsiento;

            console.log(`Asiento ${asientoActual} seleccionado. Precio: ${precioAsiento}. Precio Total: ${precioTotal}`);
        }
    };
}
function crearAsientos(cinemaRoom) {
    let numeroFilas = cinemaRoom.rows;
    let numeroColumnas = cinemaRoom.columns;

    for (let i = 1; i <= numeroFilas; i++) {
        const fila = document.createElement('ul');

        for (let j = 1; j <= numeroColumnas; j++) {
            const columna = document.createElement('li');
            const inputAsiento = document.createElement('input');
            inputAsiento.setAttribute('type', 'checkbox');
            inputAsiento.setAttribute('id', `${abecedario[i - 1]}${j}`);
            inputAsiento.addEventListener('click', manejarClickAsiento(i, j, cinemaRoom));

            const labelAsiento = document.createElement('label');
            labelAsiento.setAttribute('for', `${abecedario[i - 1]}${j}`);
            labelAsiento.classList.add(`${abecedario[i - 1]}${j}`);
            labelAsiento.appendChild(generarImagen());

            columna.appendChild(inputAsiento);
            columna.appendChild(labelAsiento);
            fila.appendChild(columna);
        }
        contenedorAsientos.appendChild(fila);
    }
}
