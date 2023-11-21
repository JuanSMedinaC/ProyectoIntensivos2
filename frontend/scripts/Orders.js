const orderCardContainer = document.getElementById('orderCardContainer');

getOrders();

async function getOrders(){
    let response = await fetch('http://localhost:8080/api/sql/orders',{
        method: 'GET',
        headers: {
        }
    });
    if(response.status ===200){
        let json = await response.json();
        console.log(json);

        json.forEach(order => {
        var card = new OrderCard(order);
        console.log( card.render() );
        console.log(orderCardContainer);
        orderCardContainer.appendChild(card.render());    
        });
    } else {
        alert(await response.text());
    }

    
}
