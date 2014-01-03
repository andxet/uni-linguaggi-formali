Laboratorio di Linguaggi Formali e Traduttori Corso di Studi in Informatica a.a. 2012/2013
Matteo Baldoni e Luca Padovani Dipartimento di Informatica -- Università degli Studi di Torino c.so Svizzera, 185 -- I-10149 Torino (Italy)
Versione del 24 giugno 2013

Sommario Queste pagine descrivono il laboratorio per il corso di Linguaggi Formali e Traduttori per l'anno accademico 2012/2013.

Modalità di svolgimento e consegna del laboratorio
È consigliato sostenere l'esame nella prima sessione d'esame dopo il corso.

Forum di discussione e supporto on-line al corso
Sulla piattaforma I-learn saranno disponibili forum di discussione dedicati per gli argomenti affrontati durante il corso e per scambiare opinioni tra i vari gruppi di lavoro e con il docente. La piattaforma sarà utilizzata anche per inviare avvisi nonché per la consegna del codice in vista dell'esame (si veda la successiva sezione). L'iscrizione al forum principale è effettuata automaticamente, è possibile disiscriversi ma è consigliabile farlo solo a seguito del superamento dell'esame per poter sempre ricevere in modo tempestivo le comunicazioni effettuate dal docente. Per ognuno dei forum disponibili è disponibile un canale RSS che riporta gli ultimi dieci post effettuati.

Materiale da portare all'esame di laboratorio
Il laboratorio è organizzato in 4 parti da svolgere in maniera incrementale. All'esame si deve avere con sè un archivio compresso in formato ZIP o TAR (altri formati non saranno accettati). Su sistemi Linux/Unix/Mac si possono usare i comandi zip -r nome _archivio nome _direttorio tar cvfz nome _archivio nome _direttorio L'archivio compresso deve contenere quattro cartelle chiamate parteI, parteII, parteIII e parteIV contenenti il codice sorgente e compilato relativo alle corrispondenti sezioni I. All'esame si dovrà avere con se il listato stampato del codice sorgente. La presente specifica raccoglie elementi di soluzioni dei problemi da portare all'esame elaborati a suo tempo con gli studenti presenti in laboratorio. Questi elementi di soluzione sono riportati soprattutto per sostenere lo svolgimento degli esercizi da parte di chi non ha potuto seguire. A tal fine le varie parti di codice fornite in questa specifica del laboratorio sono un riferimento da capire (ovviamente). In sede di esame lo studente discuterà proprie scelte confrontandole con le parti di codice qui riportate. 1

Modalità dell'esame di laboratorio
L'esame è orale e individuale anche se il laboratorio è svolto in collaborazione con altri studenti. Per sostenere l'esame a un appello è obbligatorio prenotarsi sulla piattaforma I-learn. L'esame ha l'obiettivo di verificare il corretto svolgimento della prova di laboratorio, la comprensione della sua struttura e del suo funzionamento, nonché la comprensione delle parti di "teoria" correlata al laboratorio stesso. Per poter discutere il laboratorio è necessario aver prima superato la prova scritta relativa al modulo di teoria. L'ultima sessione utile per sostenere la prova orale di laboratorio sarà la sessione di febbraiomarzo 2014.

Calcolo del voto finale
Il voto per lo scritto e per il laboratorio sarà espresso in trentesimi. Il voto finale sarà formato dalla media pesata del voto della prova scritta e del laboratorio, secondo il loro contributo in CFU, e cioè voto finale = (voto dello scritto × 2 + voto del laboratorio)/3 La lode è attribuita nel caso si sia mostrata particolare brillantezza durante la parte di teoria e il laboratorio.

Validità del presente testo di laboratorio
Il presente testo di labortorio è valido sino alla sessione di febbraio-marzo 2014.

I
I.1

Valutatore di espressioni semplici
Analizzatore lessicale

Consideriamo un linguaggio (sorgente) per specificare espressioni aritmetiche molto semplici, composte soltanto da numeri non negativi, identificatori, operatori binari di somma e sottrazione + e -, simboli di parentesi ( e ). Esempi: a) 34 + 26 - 5 b) (34 + 26) - 5 d) (34 + x) - 5 Si scriva in Java un analizzatore lessicale che legga da tastiera queste espressioni e per ciascuna espressione stampi una sequenza di coppie token, "lessema" . Per esempio, per le prime due espressioni elencate sopra si devono ottenere le sequenze: · NUM, "34" · LPAR, "(" PLUS, "+" NUM, "34" NUM, "26" PLUS, "+" MINUS, "-" NUM, "26" NUM, "5" MINUS, "-" NUM, "5"

RPAR, ")"

Nota: l'analizzatore lessicale non è preposto al riconoscimento della struttura delle espressioni. Pertanto, esso accetterà anche espressioni aritmetiche errate quali ad esempio: · 5+) · (34 + 26(-(2 + 15 - (27

2

L'analizzatore lessicale dovrà ignorare tutti i caratteri riconosciuti come "spazi" (incluse le tabulazioni e i ritorni a capo), ma dovrà segnalare la presenza di caratteri illeciti, quali ad esempio $ o @. Suggerimento: definire una classe Tag con un insieme opportuno di costanti intere per rappresentare il nome dei token come NUM, PLUS, ecc.; definire una classe Token (ed eventualmente classi derivate) per rappresentare i token. Una possibile struttura del programma (ispirato al testo [1, Appendice A.3]) è la seguente: Listing 1: Analizzatore lessicale di espressioni semplici
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49

package lexer ; import java . io .*; public class CalculatorLexer { public static int line = 1; private char peek = ' '; private void readch () { try { peek = ( char ) System . in . read (); } catch ( IOException exc ) { peek = ( char ) -1; // ERROR = EOF } } public Token scan () { while ( peek == ' ' || peek == '\ t ' || peek == '\ n ' ) { if ( peek == '\ n ') line ++; readch (); } switch ( peek ) { case '( ': peek = ' '; return new Token ( Tag . LPAR , " ( " ); // ... gestire gli altri caratteri ... // default : if ( Character . isDigit ( peek )) { String s = " " ; do { s += peek ; readch (); } while ( Character . isDigit ( peek )); return new Token ( Tag . NUM , s ); } else // ... gestire identificatori e caratteri illeciti ... // } } public static void main ( String [] args ) { CalculatorLexer lex = new CalculatorLexer (); Token tok ; do { tok = lex . scan (); System . out . println ( " Scan : " + tok );

3

50 51 52

} while ( tok . tag != Tag . EOF ); } }

I.2

Analizzatore sintattico

Si scriva un analizzatore sintattico a discesa ricorsiva che parsifichi le espressioni semplici discusse precedentemente. In particolare, l'analizzatore deve riconoscere le espressioni generate dalla seguente grammatica: start expr exprp ::= ::= expr term exprp exprp exprp

::= + term | - term |  ::= fact

term termp

termp termp termp

::= * fact | / fact | 

fact

::= ( expr ) | ID | NUM

Il programma deve fare uso dell'analizzatore lessicale sviluppato in precedenza. Una possibile struttura del programma (ispirato al testo [1, Appendice A.8]) è la seguente: Listing 2: Analizzatore sintattico di espressioni semplici
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27

package parser ; import java . io .*; import lexer .*; public class CalculatorParser { private CalculatorLexer lex ; private Token look ; public CalculatorParser ( CalculatorLexer l ) { lex = l ; move (); } void move () { look = lex . scan (); System . err . println ( " token = " + look ); } void error ( String s ) { throw new Error ( " near line " + lex . line + " : " + s ); } void match ( int t ) { if ( look . tag == t ) { if ( look . tag != Tag . EOF ) move (); } else error ( " syntax error " );

4

28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73

} public void start () { expr (); match ( Tag . EOF ); } private void expr () { term (); exprp (); } private void exprp () { switch ( look . tag ) { case Tag . PLUS : match ( Tag . PLUS ); term (); exprp (); break ; case Tag . MINUS : // ... gestire gli altri casi ... // } } private void term () { // ... riempire ... // } private void termp () { switch ( look . tag ) { case Tag . TIMES : match ( Tag . TIMES ); fact (); termp (); break ; // ... gestire gli altri casi ... // } private void fact () { switch ( look . tag ) { // ... gestire tutti i casi ... // } } }

Il main per eseguire il tutto ha una forma tipo la seguente: Listing 3: Main per l'analizzatore sintattico di espressioni semplici
1 2 3 4 5 6 7 8 9

package main ; import java . io .*; import lexer .*; import parser .*; public class Main { public static void main ( String [] args ) { CalculatorLexer lex = new CalculatorLexer ();

5

10 11 12 13

CalculatorParser parser = new CalculatorParser ( lex ); parser . start (); } }

I.3

Implementazione del valutatore

Modificare il precedente analizzatore sintattico in modo da valutare le espressioni dove, per semplicità, si è eliminata la produzione di ID: start expr exprp ::= ::= expr term { exprp.i = term .val } exprp { expr .val = exprp.val }

::= + term { exprp1 .i = exprp.i + term .val } exprp1 { exprp.val = exprp1 .val } | - term { exprp1 .i = exprp.i - term .val } exprp1 { exprp.val = exprp1 .val } |  { exprp.val = exprp.i } ::= fact { termp.i = fact .val } termp { term .val = termp.val }

term termp

::= * fact { termp1 .i = termp.i  fact .val } termp1 { termp.val = termp1 .val } | / fact { termp1 .i = termp.i/fact .val } termp1 { termp.val = termp1 .val } |  { termp.val = termp.i } ::= ( expr ) { fact .val = expr .val } | NUM { fact .val = Integer.parseInt(NUM.text ) }

fact

Una possibile struttura del programma (ispirato al testo [1, Appendice A.8]) è la seguente: Listing 4: Valutazione di espressioni semplici
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26

package parser ; import java . io .*; import lexer .*; public class CalculatorParser { private CalculatorLexer lex ; private Token look ; public CalculatorParser ( CalculatorLexer l ) { lex = l ; move (); } void move () { look = lex . scan (); System . err . println ( " token = " + look ); } void error ( String s ) { throw new Error ( " near line " + lex . line + " : " + s ); } void match ( int t ) { if ( look . tag == t ) { if ( look . tag != Tag . EOF ) move ();

6

27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84

} else error ( " syntax error " ); } public int start () { int expr_val ; expr_val = expr (); match ( Tag . EOF ); return expr_val ; } private int expr () { int term_val , exprp_val ; term_val = term (); exprp_val = exprp ( term_val ); return exprp_val ; } private int exprp ( int exprp_i ) { int term_val , exprp_val ; switch ( look . tag ) { case Tag . PLUS : match ( Tag . PLUS ); term_val = term (); exprp_val = exprp ( exprp_i + term_val ); break ; case Tag . MINUS : // ... completare ... // } private int term () { // ... completare ... // } private int termp ( int termp_i ) { int fact_val , termp_val ; switch ( look . tag ) { case Tag . TIMES : match ( Tag . TIMES ); fact_val = fact (); termp_val = termp ( termp_i * fact_val ); break ; // ... completare ... // } } private int fact () { int fact_val ; switch ( look . tag ) { case Tag . NUM :

7

85 86 87 88 89

fact_val = Integer . parseInt ( look . text ); // ... completare ... // } } }

Il main per eseguire il tutto ha una forma come la seguente: Listing 5: Main per la valutazione di espressioni semplici
1 2 3 4 5 6 7 8 9 10 11 12 13

package main ; import java . io .*; import lexer .*; import parser .*; public class Main { public static void main ( String [] args ) { CalculatorLexer lex = new CalculatorLexer (); CalculatorParser parser = new CalculatorParser ( lex ); System . out . println ( parser . start ()); } }

II

Valutatore di espressioni semplici in ANTLR

Il tool ANTLR è un generatore di parser di tipo LL(*) le cui regole sono espresse in formato EBNF. Si faccia riferimento al supporto online al corso per i link al download e alla documentazione. In particolare, gli esempi che seguono fanno riferimento ad ANTLR versione 3.5 e ANTLRWorks 1.4.2.

II.1

Analizzatore lessicale e sintattico in ANTLR

Realizzare un parsificatore a discesa ricorsiva per la grammatica seguente utilizzando lo strumento ANTLR: start expr exprp ::= ::= expr term exprp exprp exprp

::= + term | - term |  ::= fact

term termp

termp termp termp

::= * fact | / fact | 

fact

::= ( expr ) | ID | NUM

8

II.2

Analizzatore sintattico EBNF

Realizzare un parsificatore a discesa ricorsiva per la grammatica seguente utilizzando lo strumento ANTLR: start ::= expr expr term fact ::= ::= term (+ term | - term ) fact (* fact | / fact )

::= ( expr ) | ID | NUM

II.3

Implementazione del valutatore in ANTLR

Attribuire le grammatiche delle Sezioni II.1 e II.2 in modo da valutare le espressioni riconosciute (si attribuisca al token ID il valore di default 0) e realizzare un parsificatore a discesa ricorsiva che effettui contemporaneamente la valutazione utilizzando lo strumento ANTLR.

III

Compilatore di un semplice linguaggio imperativo

L'obiettivo di quest'ultima parte di laboratorio è di quello di realizzare un compilatore per un semplice linguaggio impeativo tra i due linguaggi descritti qui nel seguito e chiamati parla e math. parla e math includono le espressioni aritmetiche, le espressioni logiche, la dichiarazione di variabili, l'istruzione di assegnamento e di controllo di flusso "while" e "if".

9

III.1

Sintassi del linguaggio math
( statement ) ( declaration | assignment | ifwhilestatement )

La sintassi del linguaggio math è descritta dalla seguente grammatica EBNF. start statement declaration assignment print printorid ifwhilestatement ifstatement whilestatement expr andExpr relExpr ::= ::=

::= { ( int | bool ) ( , ( int | bool ) )  } => { ID ( , ID )  } ::= { expr ( , expr )  } => { printorid ( , printorid )  } ::= print expr ; ::= ID | print ::= ? { expr } => ( ifstatement | whilestatement ) ::= { ( statement )  } ( : { ( statement )  } )? ::= * { ( statement )  } ::= ::= ::= andExpr (|| andExpr ) relExpr (&& relExpr ) addExpr ( = addExpr | != addExpr | <= addExpr | >= addExpr | < addExpr | > addExpr )? mulExpr (+ mulExpr | - mulExpr ) unExpr (* unExpr | / unExpr )

addExpr mulExpr unExpr primary

::= ::=

::= + unExpr | - unExpr | ! unExpr | primary ::= ( expr ) | ID | NUM | true | false

Di seguito sono riportati alcuni esempi di programmi math e i corrispondenti programmi in linguaggio Java. Listing 6: Algoritmo di Euclide per il calcolo del MCD
1 2 3 4 5 6 7 8 9 10

{ int , int , int } = > {z , w , temp } {12 , 8} = > {z , w } ?{ not ( z = w )} = > *{ ?{ z < w } = > { {z , w } = > { temp , z } { temp } = > { w } } {z - w} => {z} } { z } = > { print }

Listing 7: Calcolo della sequenza di Fibonacci
1

{ int , int , int , int , int } = > { i , k , m , n , res }

10

2 3 4 5 6 7 8 9 10 11 12

{10} = > { k } ?{ k =0} = > { {0} = > { res } }:{ {1 , 0 , 1} = > {i , m , n } ?{ i <= k -1} = > *{ {n , n +m , i +1} = > {m , n , i } } { n } = > { res } } { res } = > { print }

Listing 8: Test di primalità di un numero
1 2 3 4 5 6 7

{ int , int , int , bool } = > {o , p , q , primo } {1237 , 2 , true } = > {o , p , primo } ?{ p < o /2 && primo } = > *{ { o - ( o / p ) * p , p + 1} = > {q , p } { q != 0} = > { primo } } { primo } = > { print }

Listing 9: Algoritmo di Euclide per il calcolo del MCD
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

public class MCD { public static void main ( String [] args ) { int z , w , temp ; z = 12; w = 8; while ( z != w ) { if ( z < w ) { temp = z ; z = w; w = temp ; } z = z - w; } System . out . println ( z ); } }

Listing 10: Calcolo della sequenza di Fibonacci
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18

public class MCD { public static void main ( String [] args ) { int i , k , m , n , res ; k = 10; if ( k == 0) res = 0; else { i = 1; m = 0; n = 1; while ( i <= k -1) { n = n + m; m = n - m; i = i + 1; } res = n ; } System . out . println ( res ); } }

11

Listing 11: Test di primalità di un numero
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16

public class Primo { public static void main ( String [] args ) { int o , p , q ; boolean primo ; o = 1237; p = 2; primo = true ; while ( p < o /2 && primo ) { q = o - (o / p) * p; // System . out . println ( q ); primo = q != 0; p = p + 1; } System . out . println ( primo ); } }

12

III.2

Sintassi del linguaggio parla
start statement please integer boolean ::= ::= ::= ::= ::= ::= ( statement ) ( declaration | assignment | ifstatement | whilestatement | print ) , per favore , intera | intere booleana | booleane Assumi che ( la variabile | le variabili ) ID ( , ID ) ( sia | siano ) ( integer | boolean ) . Metti ( il valore | i valori ) di expr ( , expr ) in ID ( , ID )  . Se expr è vera please fai : ( statement ) ( Altrimenti please fai : ( statement ) )? Grazie . Finché expr è vera please fai : ( statement )  Grazie .

La sintassi del linguaggio parla è descritta dalla seguente grammatica EBNF.

declaration

assignment

::=

ifstatement

::=

whilestatement print expr andExpr relExpr

::= ::= ::= ::= ::=

Stampa please il valore di expr . andExpr (oppure andExpr ) relExpr (e relExpr ) addExpr ( è |è |è |è uguale a addExpr | è diverso da addExpr minore o uguale di addExpr maggiore o uguale di addExpr minore di addExpr | è maggiore di addExpr )?

addExpr mulExpr unExpr primary

::= ::= ::= ::=

mulExpr (+ mulExpr | - mulExpr ) unExpr (* unExpr | / unExpr ) + unExpr | - unExpr | non è vero che unExpr | primary ( expr ) | ID | NUM | vero | falso

Di seguito sono riportati gli mostrati precedentemente come programmi parla. Listing 12: Algoritmo di Euclide per il calcolo del MCD
1 2 3 4 5 6 7 8 9

Assumi che le variabili z , w , temp siano intere . Metti i valori di 12 , 8 in z , w .é Finch " non è vero che ( z è uguale a w ) " è vera , per favore , fai : Se " z è minore di w " è vera , per favore , fai : Metti i valori di z , w in temp , z . Metti il valore di temp in w . Grazie . Metti il valore di z - w in z . Grazie .

13

10

Stampa , per favore , il valore di z .

Listing 13: Calcolo della sequenza di Fibonacci
1 2 3 4 5 6 7 8 9 10 11 12 13

Assumi che le variabili ii , k , m , n , res siano intere . Metti il valore di 10 in k . Se " k è uguale a 0 " è vera , per favore , fai : Metti il valore di 0 in res . Altrimenti , per favore , fai : Metti i valori di 1 , 0 , 1 in ii , m , n .é Finch " ii è minore o uguale di k - 1 " è vera , per favore , fai : Metti i valori di n , n + m in m , n . Metti il valore di ii + 1 in ii . Grazie . Metti il valore di n in res . Grazie . Stampa , per favore , il valore di res .

Listing 14: Test di primalità di un numero
1 2 3 4 5 6 7 8

Assumi che le variabili oo , p , q siano intere . Assumi che la variabile primo sia booleana . Metti i valori di 1237 , 2 , vero in oo , p , primo .é Finch " p è minore di oo /2 e primo " è vera , per favore , fai : Metti i valori di oo - ( oo / p ) * p , p + 1 in q , p . Metti il valore di q è diverso da 0 in primo . Grazie . Stampa , per favore , il valore di primo .

Scrivere una grammatica ANTLR per riconoscere programmi scritti nel linguaggio math o nel linguaggio parla e verificarne il buon funzionamento con i programmi qui sopra ed altri a piacere.

III.3

Type checker

Prima di tradurre un programma scritto nel linguaggio math o parla, il compilatore deve verificarne la correttezza di tipo secondo i seguenti criteri: · Gli operatori aritmetici possono essere applicati esclusivamente ad operandi di tipo intero. Ad esempio, l'espressione 5 + true (5 + vero), che usa l'operatore aritmetico + applicato a un operando booleano, è sintatticamente ma non semanticamente corretta e dunque non può essere tradotta. · Gli operatori logici possono essere applicati esclusivamente ad operandi di tipo booleano. · Gli operatori d'ordine < (è minore di), > (è maggiore di), <= (è minore o uguale di) e >= (è maggiore o uguale di) possono essere applicati esclusivamente ad operandi numerici, mentre gli operatori = (è uguale a) e != (è diverso da) sono overloaded, ovvero possono essere applicati indifferentemente ad operandi di tipo numerico o booleano, purché entrambi gli operandi siano dello stesso tipo. · I comandi di assegnamento sono corretti se la lista di tipo dell'espressione a sinistra dell'operatore => (in) è uguale alla lista di tipi degli identificatori a destra dell'operatore => (in). · I comandi condizionali e iterativi contengono un'espressione che deve essere di tipo booleano. Inoltre, ci sono altri due errori non legati ai tipi che il compilatore deve gestire: · Ogni identificatore deve essere dichiarato prima del suo utilizzo.

14

· Un identificatore non può essere dichiarato più di una volta. Per effettuare il controllo di tipo, si introduce una enumerazione per distinguere i due tipi di dato dei programmi parla e math: Listing 15: Rappresentazione dei tipi
1

public enum Type { INT , BOOL }

È necessario aggiungere attributi sintetizzati per tenere traccia del tipo delle espressioni. Ad esempio, per le produzioni di primary possiamo avere un codice ANTLR come il seguente (es. con math): Listing 16: Verifica di correttezza di espressioni primarie
primary returns [ Type type ] : INT { $type = Type . INT ; } | ' true ' { $type = Type . BOOL ; } | ... ;

mentre per expr possiamo avere (es. con math): Listing 17: Verifica di correttezza di espressioni
expr returns [ Type type ] : t1 = andExpr { $type = t1 ; } ( ' || ' t2 = andExpr { if (( $type != Type . BOOL ) || ( t2 != Type . BOOL )) throw new I l le g a l Ar g u m en t E x ce p t i on ( " Operando non booleano per ||. " ); } )* | ... ;

Per tenere traccia degli identificatori, occorre predisporre una tabella dei simboli. Segue una possibile implementazione: Listing 18: Implementazione della tabella dei simboli
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19

import java . util .*; public class SymbolTable { private Map < String , Type > typeMap = new HashMap < String , Type >(); public void insert ( String s , Type t ) { if (! typeMap . containsKey ( s )) typeMap . put (s , t ); else throw new I l le g a l Ar g u m en t E x ce p t i on ( " Variabile duplicata " + s ); } public Type lookupType ( String s ) { if ( typeMap . containsKey ( s )) return typeMap . get ( s ); else throw new I l le g a l Ar g u m en t E x ce p t i on ( " Variabile sconosciuta " + s ); } }

Per fare in modo che la classe generata da ANTLR contenga una istanza della tabella dei simboli è necessario informare ANTLR attraverso la direttiva @members:

15

Listing 19: Generazione del parser con la tabella dei simboli
grammar math ; @members { SymbolTable st = new SymbolTable (); ... } ...

Tutto ciò che è racchiusto tra le parentesi graffe viene copiato così com'è nella classe di parsing generata da ANTLR. È utile sfruttare questo meccanismo per dichiarare metodi ausiliari, per esempio per implementare frammenti di codice che effettuano la verifica di correttezza di tipo e che vengono applicati invariati in numerosi punti del compilatore. La tabella dei simboli verrà utilizzata così (es. per math): Listing 20: Uso della tabella dei simboli
declaration : '{ ' t = type '} ' '= > ' '{ ' id = ID '} ' { st . insert ( $id . text , t ); } ; ... assignment : '{ ' texpr = expr '} ' '= > ' '{ ' id = ID '} ' { if ( st . lookupType ( $idD . text ) != texpr ) throw new I l le g a l Ar g u m en t E x ce p t i o n ( " errore di tipo " ); } ...

NOTA: le dichiarazioni del linguaggio math consentono di specificare più identificatori e tipi separati da virgole, pertanto la produzione qui sopra relativa al non-terminale declaration va opportunamente modificato.

III.4

Generazione del bytecode

L'obiettivo di quest'ultima parte di laboratorio è di quello di realizzare un traduttore per i programmi (ben tipati) scritti nel linguaggio math o parla che produca bytecode [4] eseguibile dalla Java Virtual Machine (JVM). Generare bytecode eseguibile direttamente dalla JVM non è una operazione semplice a causa della complessità del formato dei file .class (che tra l'altro è un formato binario) [3]. Il bytecode verrà quindi generato avvalendoci di un linguaggio mnemonico che fa riferimento alle istruzioni della JVM (linguaggio assembler [2]) e che successivamente viene tradotto nel formato proprio del bytecode dal programma assembler. Il linguaggio mnemonico utilizzato fa riferimento proprio all'insieme delle istruzioni della JVM [5] e l'assembler effettua una traduzione 1-1 delle istruzioni mnemoniche nella corrispondente istruzione (opcode ) della JVM. Il programma assembler che utilizzeremo si chiama Jasmin (distribuzione e manuale sono disponibili all'indirizzo http://jasmin.sourceforge.net/). La costruzione del file .class a partire dal sorgente scritto nei linguaggi math e parla avviene secondo lo schema seguente: compilatore math o parla jasmin .class

.pas

.j

16

Il file sorgente viene tradotto dal compilatore (oggetto della realizzazione) nel linguaggio assembler per la JVM. Questo file (che deve avere l'estensione .j) è poi trasformato in un file .class dal programma assembler Jasmin (si utilizzi il comando java -jar jasmin.jar Output.j).

III.5

Esempi di compilazione

Seguono alcuni semplici programmi math affiancati dal bytecode JVM corrispondente. Per altri esempi più compessi di bytecode generato si veda il supporto on-line al proprio corso.

Listing 21: A.math {10 + 20  30} => { p r i n t }

Listing 22: Output.j b i p u s h 10 b i p u s h 20 b i p u s h 30 imul iadd iprint

Listing 23: B.math {10 < 20  30} => { p r i n t }

Listing 24: B.j b i p u s h 10 b i p u s h 20 b i p u s h 30 imul i f _ i c m p g e L1 iconst_1 g o t o L2 L1 : iconst_0 L2 : bprint

Listing 25: C.mate { i n t , i n t , i n t } => {x , y , z } { 1 0 , 2 0 , 30} => {x , y , z } {x + y  z } => { p r i n t }

Listing 26: Output.j b i p u s h 10 b i p u s h 20 b i p u s h 30 istore_0 istore_1 istore_2 iload_2 iload_1 iload_0 imul iadd iprint

III.6

Classi di supporto

Per la realizzazione del compilatore è utile creare le seguenti classi. La classe Instruction verrà usata per rappresentare singole istruzioni del linguaggio mnemonico. La classe OpCode è una semplice enumerazione dei nomi mnemonici (si veda [5] per un elenco 17

dei nomi, ma si riporti solo quelli ritenuti utili per la traduzione delle espressioni aritmetiche/booleane). Il metodo toJasmin restituisce l'istruzione nel formato adeguato per l'assembler Jasmin. Listing 27: Scheletro della classe Instruction
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16

public class Instruction { private OpCode opCode ; private int operand ; public Instruction ( OpCode opCode ) { // completare } public Instruction ( OpCode opCode , int operand ) { // completare } public String toJasmin () { // completare } }

La classe CodeGenerator ha lo scopo di memorizzare in una struttura apposita (si scelga quella preferita tra quelle offerte nel package java.util) la lista delle istruzioni (come oggetti di tipo Instruction) generate durante la parsificazione. I metodi emit sono usati per aggiungere istruzioni o etichette di salto nel codice. Le costanti header e footer definiscono il preambolo e l'epilogo del codice generato dal traduttore per restituire, mediante il metodo toJasmin, un file la cui struttura risponde ai requisiti dell'assembler Jasmin. Listing 28: Scheletro della classe CodeGenerator
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28

public class CodeGenerator { public void emit ( OpCode opCode ) { // completare } public void emit ( OpCode opCode , int operand ) { // completare } public void emitLabel ( int operand ) { // completare } public int newLabel () { // completare } public String toJasmin () { // completare } private static final String header = " . class public Output \ n " + " . super java / lang / Object \ n " + "\n" + " . method public < init >() V \ n " + " aload_0 \ n " + " invokenonvirtual java / lang / Object / < init >() V \ n "

18

29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68

+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + +

" return \ n " " . end method \ n " "\n" " . method public static printBool ( I ) V \ n " " . limit stack 3\ n " " getstatic java / lang / System / out Ljava / io / PrintStream ;\ n " " iload_0 \ n " " bipush 1\ n " " if_icmpeq Ltrue \ n " " ldc \" false \"\ n " " goto Lnext \ n " " Ltrue :\ n " " ldc \" true \"\ n " " Lnext :\ n " " invokevirtual java / io / PrintStream / println ( Ljava / lang / String ;) V \ n " " return \ n " " . end method \ n " "\n" " . method public static printInt ( I ) V \ n " " . limit stack 2\ n " " getstatic java / lang / System / out Ljava / io / PrintStream ;\ n " " iload_0 \ n " " invokestatic java / lang / Integer / toString ( I ) Ljava / lang / String ;\ n " " invokevirtual java / io / PrintStream / println ( Ljava / lang / String ;) V \ n " " return \ n " " . end method \ n " "\n" " . method public static run () V \ n " " . limit stack 1024\ n " " . limit locals 256\ n " ;

private static final String footer = " return \ n " + " . end method \ n " + "\n" + " . method public static main ([ Ljava / lang / String ;) V \ n " + " invokestatic Output / run () V \ n " + " return \ n " + " . end method \ n " ; }

Di seguito sono mostrati frammenti della specifica ANTLR arricchita con il codice che genera il bytecode corrispondente a espressioni del linguaggio math. Notare l'accesso all'oggetto code di tipo CodeGenerator che deve essere dichiarato come membro del parser, similmente a quanto accade per la tabella dei simboli. Listing 29: Traduzione di espressioni
primary returns [ Type type ] : INT { $type = Type . INT ; if ( val == 0) code . emit ( Opcode . iconst_0 ); else if ( val == 1) code . emit ( Opcode . iconst_1 ); else if ( val == 2) code . emit ( Opcode . iconst_2 ); else if ( val == 3) code . emit ( Opcode . iconst_3 ); else if ( val == 4) code . emit ( Opcode . iconst_4 );

19

else if ( val == 5) code . emit ( Opcode . iconst_5 ); else if ( val < 128) code . emit ( Opcode . bipush , val ); else if ( val < 32768) code . emit ( Opcode . sipush , val ); else code . emit ( Opcode . lcd , val ); } | ' true ' { } | ... ; addExpr returns [ Type type ] : e1 = mulExpr { $type = $e1 . type ; } ( '+ ' e2 = mulExpr { // type checking code . emit ( OpCode . iadd ); } | ... ; relExpr returns [ Type type ] : t1 = addExpr { $type = t1 ; } ( '= ' t2 = addExpr { // type checking int lfalse = code . getLabel (); int lnext = code . getLabel (); code . emit ( Opcode . if_icmpne , lfalse ); code . emit ( Opcode . iconst_1 ); code . emit ( Opcode . goto_ , lnext ); code . emitLabel ( lfalse ); code . emit ( Opcode . iconst_0 ); code . emitLabel ( lnext ); $type = Type . BOOL ; | ' != ' ... | ... )? ; code . emit ( Opcode . iconst_1 ); $type = Type . BOOL ;

Notare che le espressioni logiche possono essere tradotte in modo analogo alle espressioni aritmetiche, codificando il valore false con 0 ed il valore true con 1. La classe SymbolTable deve essere opportunamente modificata per consentire l'associazione delle variabili al loro tipo e indirizzo (in termini di offset dalla base del record di attivazione). Listing 30: Scheletro della classe SymbolTable
1 2 3 4 5 6 7 8 9 10 11 12 13

public class SymbolTable { public void insert ( String s , Type t , int address ) { // completare } public Type lookupType ( String s ) { // completare } public int lookupAddress ( String s ) { // completare } }

20

III.7

Valutazione corto-circuitata di espressioni logiche

Alcune espressioni logiche hanno un valore determinato pur non essendo noto il valore di tutte le loro sottoespressioni. Per esempio, l'espressione false && E è falsa a prescindere dal valore di E , dal momento che false è assorbente per la congiunzione logica. In modo duale, l'espressione true || E è vera a prescindere dal valore di E . Seguendo queste considerazioni, è possibile tradurre una espressione logica in modo tale che la sua valutazione si arresti non appena ne è noto il valore. Questo particolare schema di traduzione prende talvolta il nome di "valutazione corto-circuitata". A titolo di esempio, il programma qui sotto contiene un'espressione la cui valutazione completa darebbe luogo a un errore di divisione per zero. Grazie alla valutazione corto-circuitata, tuttavia, esso può essere compilato nella sequenza di istruzioni mostrata a lato, che consente la terminazione con successo del programma:

b i p u s h 10 { 10 = 20 && 30 / 0 > 15 } => { p r i n t b } i p u s h 20 if_icmpne L3 iconst_1 g o t o L4 L3 : iconst_0 L4 : i f e q L2 b i p u s h 30 iconst_0 idiv b i p u s h 15 i f _ i c m p l e L5 iconst_1 g o t o L6 L5 : iconst_0 L6 : i f e q L2 iconst_1 g o t o L7 L2 : iconst_0 L7 : bprint In particolare, terminata la valutazione della sottoespressione 10 = 20 (corrispondente alle istruzioni fino all'etichetta L4), il bytecode controlla se la sottoespressione è falsa e, in tal caso, salta all'etichetta L2 scavalcando interamente la valutazione della sottoespressione 30 / 0 > 15 (corrispondente alle istruzioni da L4 a L6). Modificare il compilatore in modo da effettuare la valutazione corto-circuitata degli operatori && e ||.

21

Riferimenti bibliografici
[1] Aho, Alfred V., Lam, Monica S., Sethi, Ravi, and Ullman, Jeffrey D. Compilers: Principles, Techniques, and Tools. Addison Wesley Longman, 2007. [2] Assembly language. http://en.wikipedia.org/wiki/Assembly_language Wikipedia, 2012. [3] Java class file. http://en.wikipedia.org/wiki/Java_class_file Wikipedia, 2012. [4] Java bytecode. http://en.wikipedia.org/wiki/Java_bytecode Wikipedia, 2012. [5] Java bytecode instruction listings. http://en.wikipedia.org/wiki/Java_bytecode_instruction_ listings Wikipedia, 2012.

22

