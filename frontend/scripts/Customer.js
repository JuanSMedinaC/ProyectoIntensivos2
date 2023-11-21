var BtnGuardar = document.getElementById('guardarClienteBtn'); // Corregir: Obtén el elemento, no su valor

BtnGuardar.addEventListener("click", addCustomer);
localStorage.setItem('Descuento', "NO");

function addCustomer() {
    submitForm();
}

function submitForm() {
    // Obtener los valores de los campos de entrada
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var address = document.getElementById('address').value;
    var dob = document.getElementById('dob').value;
    var email = document.getElementById('email').value;
    var homePhone = document.getElementById('homePhone').value;
    var cellPhone = document.getElementById('cellPhone').value;

    // Crear un objeto con los datos del cliente
    var customerBasicData = {
        firstName: firstName,
        lastName: lastName,
        address: address,
        dateOfBirth: dob,
        email: email,
        homePhone: homePhone,
        cellPhone: cellPhone
    };
    
    console.log(JSON.stringify(customerBasicData));

    var jsonString = JSON.stringify(customerBasicData);

    // Almacenar en el localStorage
    localStorage.setItem('customerBasicData', jsonString);
    // Realizar una solicitud POST (puedes utilizar fetch o XMLHttpRequest)
    fetch('http://localhost:8080/api/sql/customers', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(customerBasicData)
})
.then(response => {
    console.log('Respuesta del servidor (código):', response.status);
    if (response.status === 200) {

        var respuestaUsuario = window.confirm('¿Desea ingresar informacion adicional?');

        if (respuestaUsuario) {
            window.location.href = 'CustomerAditionalRegister.html';
            localStorage.setItem('Descuento', "SI");
        } else {
            window.location.href = 'OrderRegister.html';
            localStorage.setItem('Descuento', "NO");
        }

        localStorage.setItem('status', response.status);
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


}
