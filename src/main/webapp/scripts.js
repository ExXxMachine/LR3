let bookList = document.getElementById("bookList");
let nameInput = document.getElementById("name");
let authorInput = document.getElementById("author");
let pageSizeInput = document.getElementById("pageSize");
let publicationInput = document.getElementById("publication");
let priceInput = document.getElementById("price");
document.getElementsByTagName("form")[0].addEventListener("submit", addBook);

function addBook(event) {
    event.preventDefault();
    let book = {
        name: nameInput.value,
        author: authorInput.value,
        pageSize: pageSizeInput.value,
        publication: publicationInput.value,
        price: priceInput.value,
    };
    fetch("/BooksServlet", {
        method: "POST",
        body: JSON.stringify(book)
    });
    createCard(book);
}

function createCard(book) {
    let cardBook = document.createElement("div");
    cardBook.classList.add("card");
    let cardBody = document.createElement("div");
    cardBody.classList.add("card-body");
    let cardName = document.createElement("h3");
    cardName.textContent = `${book.name}`;
    let cardAuthor = document.createElement("h4");
    cardAuthor.textContent = book.author;
    let cardPageSize = document.createElement("h4");
    cardPageSize.textContent = `Объем: ${book.pageSize} стр.`;
    let cardPublication = document.createElement("h4");
    cardPublication.textContent = `Издание: ${book.publication}`;
    let cardPrice = document.createElement("h4");
    cardPrice.textContent = `Цена: ${book.price}`;
    cardName.classList.add("card_title");
    cardBody.append(cardName);
    cardBody.append(cardAuthor);
    cardBody.append(cardPageSize);
    cardBody.append(cardPublication);
    cardBody.append(cardPrice);
    cardBook.append(cardBody);
    bookList.insertBefore(cardBook, bookList.firstChild);
}

async function book_upload() {
    let response = await fetch("/BooksServlet");
    let cars = await response.json();
    for (let car of cars) {
        createCard(car);
    }
}

book_upload();