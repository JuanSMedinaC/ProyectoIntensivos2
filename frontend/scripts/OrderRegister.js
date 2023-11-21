// Obtén la referencia a la tabla
const productTableBody = document.querySelector('tbody');

// Realiza una solicitud fetch para obtener todos los productos
fetch('http://localhost:8080/api/sql/products/all')
    .then(response => response.json())
    .then(products => {
        // Itera sobre los productos y agrega una fila para cada uno en la tabla
        products.forEach(product => {
            const newRow = document.createElement('tr');
            newRow.innerHTML = `
                <th scope="row">${product.productId}</th>
                <td>${product.description}</td>
                <td>${product.quantityAvaliable}</td>
                <td>${product.cost}</td>
                <td>${product.sellingPrice}</td>
                <td><button class="btn btn-primary" onclick="(() => realizarOrden(${product.productId}, '${product.cost}'))()">Realizar Orden</button></td>

            `;
            productTableBody.appendChild(newRow);
        });
    })
    .catch(error => console.error('Error al obtener los productos:', error));

    function realizarOrden(productId,cost) {
        // Aquí puedes implementar la lógica para realizar una orden del producto con el ID productId

        // Obtén el valor del descuento almacenado en el localStorage
        const descuento = localStorage.getItem('Descuento');

        // Verifica si hay un descuento y realiza acciones según el valor
        if (descuento === "SI") {
            // Código a ejecutar si hay un descuento
        var respuestaUsuario = window.confirm('Se aplica el descuento por lo que el precio final es $ '+(cost-(cost*0.10)));
            //console.log("Se aplica el descuento");
        } else if (descuento === "NO") {
            // Código a ejecutar si no hay descuento
        var respuestaUsuario = window.confirm('No se aplica el descuento por lo que el precio final es $ '+cost);
        //var respuestaUsuario = window.confirm('Se aplica el descuento por lo que el precio final es $ '+(cost-(cost*0.10)));
            //console.log("No se aplica el descuento");
        }

        console.log(`Orden realizada para el producto con ID ${productId}`);

    }