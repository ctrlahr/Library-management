async function chamarAPI() {
    const username = "admin"
    const password = "admin"
    const credencials = btoa(`${username}:${password}`);
    
const response = await fetch('http://localhost:8080/author/listAll', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credencials}`
    }
});
const autores = await response.json();
console.log(autores);
}



chamarAPI();