Notes
-----

Backend:

DemoApplication.java

- clasa DemoApplication implementeaza CommandLineRunner pentru a putea rula ca in specificatii din linia de comanda
- in run : verificam numarul de argumente: 
	- 0 argumente: pentru a lasa aplicatia sa asculte pe portul 8080 (folositor pentru 
			lucrul cu frontend-ul)
	- verificam numarul de argumente - daca acesta corespunde specificatiilor -> apleam 
					   metodele corespunzatoare
					 - daca nu, printam un mesaj de eroare

Note.java

- clasa pentru a crea obiecte de tip notite (titlu + continut)

NotesRepository.java

- clasa ce contine metodele care se ocupa de lucrul cu fisiere: o metoda care intoarce toate 
titlurile sub forma de lista, o metoda care intoarce notita cu un anumit nume, o metoda care
adauga o notita daca titlul acesteia nu exista deja
- am folosit cai absolute asa ca rularea pe alte calculatoare implica schimbarea acestora
(fisierele fiind insa salvate intr-un director din cadrul proiectului)


NotesController.java

- folosit pentru a construi API-ul pentru comunicarea cu frontend-ul
- avem 2 metode get si una post, acestea apeleaza metodele din NotesRepository

Frontend:
 
- avem view-ul principal, care contine doar meniul cu 3 butoane:
		- vizualizarea titlurilor notitelor
		- cautarea dupa un titlu (acesta e ales dintr-un drop-down, ce ia toate 
		titlurile existente in directorul cu notite) -> se afiseaza continutul
		numelui ales
		- adaugarea unei noi notite prin oferirea unui nume si continut

- aplicatia ruleaza pe porturile 3000 (frontend-ul) si 8080 (backend-ul)

In fisierul demo frontend + backend exista un demo video pentru frontend si o poza cu 
outputul comenzilor din linia de comanda



