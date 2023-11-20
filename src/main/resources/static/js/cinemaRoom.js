addEventListener('DOMContentLoaded', ()=>{
    cargarSala();
})


const contenedorAsientos= document.querySelector('.asientos');

async function cargarSala(){
    
    try {
        const APIurl = 'api/cinemaRoom/1';
        const response = await fetch(APIurl);
        const cinemaRoom = await response.json();
        console.log(cinemaRoom)
        console.log(contenedorAsientos)
        crearAsientos(cinemaRoom)

    } catch (error) {
        console.log(error)
    }

}



function generarImagen(){

   const imagenAsiento = document.createElement('img');
   imagenAsiento.setAttribute('src', '../img/asiento-tradicional.png')
   imagenAsiento.setAttribute('width', '40px')
   imagenAsiento.setAttribute('height', '40px')
   return imagenAsiento;
}




function crearAsientos(cinemaRoom){


    let numeroFilas=cinemaRoom.rows;
    console.log(numeroFilas)
    let numeroColumnas=cinemaRoom.columns;
    console.log(numeroColumnas)

    for(let i=1; i<=numeroFilas; i++){

        const fila = document.createElement('ul')

        for(let j=1; j<=numeroColumnas; j++){

            const columna = document.createElement('li')
            const inputAsiento = document.createElement('input');
            inputAsiento.setAttribute('type', 'checkbox');
            inputAsiento.setAttribute('id',`${i}${j}`)

            const labelAsiento = document.createElement('label');
            labelAsiento.setAttribute('for',`${i}${j}`);
            labelAsiento.classList.add(`${i}${j}`)
            labelAsiento.appendChild(generarImagen());

            columna.appendChild(inputAsiento);
            columna.appendChild(labelAsiento);
            fila.appendChild(columna);
        }
        contenedorAsientos.appendChild(fila);
    }


}