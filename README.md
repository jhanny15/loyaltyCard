# loyaltyCard

Una classe che simula una carta di fedeltà in formatto EAN13 con i seguenti metodi:

- checkValidity(), controlla la validità della carta, ritorna true se il codice è a 13 cifre e tiene il checkDigit corretto;
- checkDigit(), ritorna il checkDigit del codice inserito;
- getCardNo(), ritorna il codice della carta senza il checkDigit;
- getFullCardNo(), ritorna il codice della carta con il checkDigit come ultima cifra;
- isFormatCorrect(), controlla il formato del codice inserito, ritorna true se il codice contiene solo numeri e tiene 12 o 13 cifre, altrimenti ritorna false
(P.S. non controlla se il codice è valido);

# Documentazione

Ho usato una variabile di tipo String dove salvo il numero della carta, che può essere a 12 cifre o 13 cifre con il checkDigit corretto;

Per controllare se il formato del numero della carta è corretto, ho deciso di creare il metodo isFormatCorrect() per non lanciare eccezioni dentro
il costruttore, prima controlla se il codice inserito contiene solo numeri con un pattern e poi controlla se il numero se è a 12 o 13 cifre.

Nel caso che il numero della carta è a 13 cifre, ho creato checkValidity() che ritorna true se il checkDigit è corretto, utilizzando il metodo checkDigit().

Per il checkDigit(), ho deciso che ritorna il tipo String perché il numero della carta è dello stesso tipo e posso usarlo più facilmente negli altri metodi.
Dentro checkDigit() abbiamo un ciclo for con if per fare la somma dei numeri nelle posizioni pari e dispari, poi faccio il prodotto tra la somma dei pari e 3 e 
lo sommo con la somma dei dispari, poi ho fatto un if nel caso che l'unità della somma è uguale a zero.

Per getCardNo(), nel caso che il numero è a 13 cifre, ho deciso di usare il metodo substring() per eliminare l'ultima cifra,
invece per getFullCardNo(), nel caso che il numero a 12 cifre, ho usato la concatenazione del numero della carta + checkDigit();

