// async function chamarAPI() {
//     const username = "admin"
//     const password = "admin"
//     const credentials = btoa(`${username}:${password}`);
    
// // const response = await fetch('http://localhost:8080/author/listAll', {
// //     method: 'GET',
// //     headers: {
// //         'Content-Type': 'application/json',
// //         'Authorization': `Basic ${credencials}`
// //     }
// // });
// // const autores = await response.json();
// // console.log(autores);
// // }

// // fetch('http://localhost:8080/author/listAll', {
// //     method: 'GET',
// //     headers: {
// //         'Authorization': `Basic ${credentials}`,
// //     }
// // })


// }

// chamarAPI();


async function callAPI() {
    const username = "admin";
    const password = "admin";
    const credentials = btoa(`${username}:${password}`);
    
    try {
        const response = await fetch('http://localhost:8080/author/listAll', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Basic ${credentials}`
            },
            mode: 'cors',
            credentials: 'include'
        });
        
        const authors = await response.json();
        console.log(authors);
        return authors;
        
    } catch (error) {
        console.error('Error:', error);
    }
}

callAPI();