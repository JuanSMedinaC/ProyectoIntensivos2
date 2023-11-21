class OrderCard {

    constructor(order) {
        this.order = order;
    }
    render() {
        let container = document.createElement('div');
        container.classList.add('card');
        container.classList.add('border-primary');
        container.classList.add('mb-3');
        container.style.maxWidth = '24rem';

        // Crear el encabezado de la tarjeta
        let cardHeader = document.createElement('div');
        cardHeader.classList.add('card-header');
        cardHeader.innerHTML = ("Id de orden: "+this.order.orderId);

        // Crear el cuerpo de la tarjeta
        let cardBody = document.createElement('div');
        cardBody.classList.add('card-body');
        cardBody.classList.add('text-primary');

        // Crear el título de la tarjeta
        let cardTitle = document.createElement('h5');
        cardTitle.classList.add('card-title');
        cardTitle.innerHTML = ("Fecha de orden: "+this.order.orderDate)
        // Agregar elementos al cuerpo de la tarjeta
        cardBody.appendChild(cardTitle);
        // Crear el párrafo de la tarjeta
        this.order.orderDetails.forEach(ordDetail => {
            let cardText = document.createElement('p');
            cardText.classList.add('card-text');
            cardText.innerHTML = ("Producto: "+ordDetail.product.description + ". Cantidad: "+ordDetail.quantity + "."+"Precio: "+ordDetail.price + ".");
            cardBody.appendChild(cardText);
        });


        // Agregar elementos al contenedor principal
        container.appendChild(cardHeader);
        container.appendChild(cardBody);


        container.style.marginLeft = '300px';
        container.style.backgroundColor = '#CDCDCD';
        container.style.marginTop = '15px';

        // Devolver el contenedor principal
        return container;
    }

}