async function callAPI() {
    const username = "admin";
    const password = "admin";
    const credentials = btoa(`${username}:${password}`);
    
    try {
        const response = await fetch('book/listAll', {
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