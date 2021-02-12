module BookDb where
    type Person = String
    type Book = String
    type Database  = [(Person, Book)]
    exampleDatabase :: Database
    exampleDatabase = [
        ("Alicia", "El nombre de la rosa"), 
        ("Juan", "La hija del canibal"), 
        ("Pepe", "Odesa"), 
        ("Alicia", "La ciudad de las bestias")]
    
    obtain :: Database -> Person -> [Book]
    obtain db thisPerson = [book | (person, book) <- db, person == thisPerson]

    borrow :: Database -> Person -> [Book] -> Database
    borrow db borrower booksList = db ++ [(borrower, book) | book <- booksList]

    return':: Database -> (Person, Book) -> Database
    return' db (p,b) = [(q,c) | (q,c) <- db, (q,c) /= (p,b)]