   
   
   // Dados de exemplo (simulando API)
        let books = [
            {
                id: 1,
                titulo: "1984",
                autor: "George Orwell",
                ano: 1949,
                genero: "Ficção",
                status: "lido",
                notas: "Obra-prima distópica. Muito atual!"
            },
            {
                id: 2,
                titulo: "O Senhor dos Anéis",
                autor: "J.R.R. Tolkien",
                ano: 1954,
                genero: "Fantasia",
                status: "lido",
                notas: "Épico fantástico!"
            },
            {
                id: 3,
                titulo: "Clean Code",
                autor: "Robert C. Martin",
                ano: 2008,
                genero: "Técnico",
                status: "lendo",
                notas: "Essencial para programadores"
            },
            {
                id: 4,
                titulo: "Sapiens",
                autor: "Yuval Noah Harari",
                ano: 2011,
                genero: "Não-ficção",
                status: "lido",
                notas: "História da humanidade fascinante"
            },
            {
                id: 5,
                titulo: "O Hobbit",
                autor: "J.R.R. Tolkien",
                ano: 1937,
                genero: "Fantasia",
                status: "lido",
                notas: "Aventura incrível!"
            },
            {
                id: 6,
                titulo: "Código Limpo",
                autor: "Robert C. Martin",
                ano: 2009,
                genero: "Técnico",
                status: "quero-ler",
                notas: ""
            },
            {
                id: 7,
                titulo: "Dom Casmurro",
                autor: "Machado de Assis",
                ano: 1899,
                genero: "Romance",
                status: "lido",
                notas: "Clássico brasileiro"
            },
            {
                id: 8,
                titulo: "A Revolução dos Bichos",
                autor: "George Orwell",
                ano: 1945,
                genero: "Ficção",
                status: "lido",
                notas: "Alegoria política poderosa"
            },
            {
                id: 9,
                titulo: "Harry Potter e a Pedra Filosofal",
                autor: "J.K. Rowling",
                ano: 1997,
                genero: "Fantasia",
                status: "lido",
                notas: "Início de uma saga mágica"
            },
            {
                id: 10,
                titulo: "Algoritmos",
                autor: "Thomas Cormen",
                ano: 2009,
                genero: "Técnico",
                status: "lendo",
                notas: "Referência em algoritmos"
            },
            {
                id: 11,
                titulo: "O Pequeno Príncipe",
                autor: "Antoine de Saint-Exupéry",
                ano: 1943,
                genero: "Ficção",
                status: "lido",
                notas: "Lindo e filosófico"
            },
            {
                id: 12,
                titulo: "Atomic Habits",
                autor: "James Clear",
                ano: 2018,
                genero: "Não-ficção",
                status: "quero-ler",
                notas: "Sobre formação de hábitos"
            }
        ];

        let editingId = null;

        function updateStats() {
            const total = books.length;
            const lidos = books.filter(b => b.status === 'lido').length;
            const lendo = books.filter(b => b.status === 'lendo').length;
            const queroLer = books.filter(b => b.status === 'quero-ler').length;

            document.getElementById('totalBooks').textContent = total;
            document.getElementById('booksRead').textContent = lidos;
            document.getElementById('booksReading').textContent = lendo;
            document.getElementById('booksToRead').textContent = queroLer;
        }

        function getStatusLabel(status) {
            const labels = {
                'lido': 'Lido',
                'lendo': 'Lendo',
                'quero-ler': 'Quero Ler'
            };
            return labels[status] || status;
        }

        function renderBooks(booksToRender = books) {
            const grid = document.getElementById('booksGrid');
            
            if (booksToRender.length === 0) {
                grid.innerHTML = `
                    <div class="empty-state" style="grid-column: 1 / -1;">
                        <h3>Nenhum livro encontrado</h3>
                        <p>Adicione seu primeiro livro ou ajuste os filtros</p>
                    </div>
                `;
                return;
            }

            grid.innerHTML = booksToRender.map(book => `
                <div class="book-card">
                    <div class="book-header">
                        <h3 class="book-title">${book.titulo}</h3>
                        <p class="book-author">por ${book.autor}</p>
                    </div>
                    <span class="status-badge status-${book.status}">${getStatusLabel(book.status)}</span>
                    <div class="book-details">
                        <p><strong>Ano:</strong> ${book.ano || 'N/A'}</p>
                        <p><strong>Gênero:</strong> ${book.genero}</p>
                        ${book.notas ? `<p><strong>Notas:</strong> ${book.notas}</p>` : ''}
                    </div>
                    <div class="book-actions">
                        <button class="btn btn-edit btn-small" onclick="editBook(${book.id})">✏️ Editar</button>
                        <button class="btn btn-delete btn-small" onclick="deleteBook(${book.id})">🗑️ Excluir</button>
                    </div>
                </div>
            `).join('');
        }

        function openAddModal() {
            editingId = null;
            document.getElementById('modalTitle').textContent = 'Adicionar Novo Livro';
            document.getElementById('bookForm').reset();
            document.getElementById('bookModal').classList.add('active');
        }

        function closeModal() {
            document.getElementById('bookModal').classList.remove('active');
            editingId = null;
        }

        function editBook(id) {
            const book = books.find(b => b.id === id);
            if (!book) return;

            editingId = id;
            document.getElementById('modalTitle').textContent = 'Editar Livro';
            document.getElementById('bookTitle').value = book.titulo;
            document.getElementById('bookAuthor').value = book.autor;
            document.getElementById('bookYear').value = book.ano || '';
            document.getElementById('bookGenre').value = book.genero;
            document.getElementById('bookStatus').value = book.status;
            document.getElementById('bookNotes').value = book.notas || '';
            
            document.getElementById('bookModal').classList.add('active');
        }

        function deleteBook(id) {
            if (confirm('Tem certeza que deseja excluir este livro?')) {
                books = books.filter(b => b.id !== id);
                applyFilters();
                updateStats();
            }
        }

        document.getElementById('bookForm').addEventListener('submit', (e) => {
            e.preventDefault();

            const bookData = {
                titulo: document.getElementById('bookTitle').value,
                autor: document.getElementById('bookAuthor').value,
                ano: parseInt(document.getElementById('bookYear').value) || null,
                genero: document.getElementById('bookGenre').value,
                status: document.getElementById('bookStatus').value,
                notas: document.getElementById('bookNotes').value
            };

            if (editingId) {
                // Editar livro existente
                const index = books.findIndex(b => b.id === editingId);
                books[index] = { ...books[index], ...bookData };
            } else {
                // Adicionar novo livro
                const newId = Math.max(...books.map(b => b.id), 0) + 1;
                books.push({ id: newId, ...bookData });
            }

            closeModal();
            applyFilters();
            updateStats();
        });

        function applyFilters() {
            const searchTerm = document.getElementById('searchInput').value.toLowerCase();
            const genreFilter = document.getElementById('filterGenre').value;
            const statusFilter = document.getElementById('filterStatus').value;

            let filtered = books;

            if (searchTerm) {
                filtered = filtered.filter(book => 
                    book.titulo.toLowerCase().includes(searchTerm) ||
                    book.autor.toLowerCase().includes(searchTerm)
                );
            }

            if (genreFilter) {
                filtered = filtered.filter(book => book.genero === genreFilter);
            }

            if (statusFilter) {
                filtered = filtered.filter(book => book.status === statusFilter);
            }

            renderBooks(filtered);
        }

        document.getElementById('searchInput').addEventListener('input', applyFilters);
        document.getElementById('filterGenre').addEventListener('change', applyFilters);
        document.getElementById('filterStatus').addEventListener('change', applyFilters);

        // Fechar modal ao clicar fora
        document.getElementById('bookModal').addEventListener('click', (e) => {
            if (e.target.id === 'bookModal') {
                closeModal();
            }
        });

        // Inicializar
        updateStats();
        renderBooks();