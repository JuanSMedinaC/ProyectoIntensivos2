

var BtnGuardar = document.getElementById('guardarInfoAdicionalClienteBtn'); // Corregir: Obtén el elemento, no su valor

BtnGuardar.addEventListener("click", addCustomerAditional);

function addCustomerAditional() {
    var customerBasicData = localStorage.getItem('customerBasicData');
    console.log(customerBasicData)
    getIdCustomer(customerBasicData);
}

//getIdCustomer(customerBasicData);

async function getIdCustomer(customerBasicData) {

    
    var jsonObject = JSON.parse(customerBasicData);
    
    let customer = {
        firstName: jsonObject.firstName,
        lastName: jsonObject.lastName,
        address: jsonObject.address,
        dateOfBirth: jsonObject.dateOfBirth,
        email: jsonObject.email,
        homePhone: jsonObject.homePhone,
        cellPhone: jsonObject.cellPhone,
        
    };

    let response = await fetch('http://localhost:8080/api/sql/customers/getCustomerId', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(customer)
    });
    
    if(response.status ===200){
        let json = await response.json();
        console.log(json);

        customerId=json;

        // Obtener los valores del primer niño
        var childName = document.getElementById('childName').value;
        var childBirthDate = document.getElementById('childBirthDate').value;
        var childGender = document.getElementById('childGender').value;
        var childStudies = document.getElementById('childStudies').checked;
        var childVideoGames = document.getElementById('childVideoGames').value;

        // Obtener los valores del lugar de nacimiento
        var birthCity = document.getElementById('birthCity').value;
        var birthState = document.getElementById('birthState').value;
        var birthCountry = document.getElementById('birthCountry').value;

        // Obtener los valores de la locación
        var city = document.getElementById('city').value;
        var region = document.getElementById('region').value;
        var country = document.getElementById('country').value;
        var postalCode = document.getElementById('postalCode').value;

        // Obtener los valores de hobbies, deportes, estado civil y categorías de productos favoritas
        var hobbies = document.getElementById('hobbies').value;
        var sports = document.getElementById('sports').value;
        var currentMaritalStatus = document.getElementById('currentMaritalStatus').value;
        var maritalStatusHistory = document.getElementById('maritalStatusHistory').value;
        var productCategories = document.getElementById('productCategories').value;

        var customerInfo = {
            customerId: customerId,
            children: [
                {
                    name: childName,
                    birthDate: childBirthDate,
                    gender: childGender,
                    studies: childStudies,
                    videoGames: [childVideoGames]
                }
                // Puedes agregar más objetos para representar más niños si es necesario
            ],
            birthPlace: {
                city: birthCity,
                state: birthState,
                country: birthCountry
            },
            location: {
                city: city,
                region: region,
                country: country,
                postalCode: postalCode
            },
            hobbies: [hobbies],
            sports: [sports],
            maritalStatus: {
                current: currentMaritalStatus,
                history: [{status: maritalStatusHistory, date: "2010-01-01"}]
            },
            productCategories: [productCategories]
        };
        
        // Puedes utilizar el objeto customerInfo como necesites en tu script
        console.log(JSON.stringify(customerInfo, null, 2));
        
        fetch('http://localhost:8080/api/mongodb/customers/additional-info', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customerInfo)
        }).then(response => {
        console.log('Respuesta del servidor (código):', response.status);
        if (response.status === 200) {
            console.log("200")
            window.location.href = 'OrderRegister.html';
        }
        return response.json();
        })
        .then(data => {
            console.log('Respuesta del servidor:', data);
            // Aquí puedes manejar la respuesta del servidor, por ejemplo, mostrar un mensaje de éxito.
        })
        .catch(error => {
            console.error('Error al enviar la solicitud:', error);
            // Aquí puedes manejar errores, por ejemplo, mostrar un mensaje de error.
        });
        //getOrdersByCustomerId(customerId);

    } else {
        alert(await response.text());
    }
}

async function getOrdersByCustomerId(customerId) {
    let ordersResponse = await fetch(`http://localhost:8080/api/sql/customers/${customerId}/orders`, {
        method: 'GET',
        headers: {
            // Puedes agregar otros encabezados si es necesario
        }
    });

    if (ordersResponse.status === 200) {
        let ordersJson = await ordersResponse.json();
        console.log('Órdenes del cliente:', ordersJson);

        // Puedes manejar las órdenes del cliente aquí
    } else {
        alert(await ordersResponse.text());
    }
}