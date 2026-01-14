# week1 – Task-sovellus (Compose-demo)

## Datamalli

**Task** on dataluokka, joka kuvaa yksittäistä tehtävää:

- `id: Long` – yksilöllinen tunniste  
- `title: String` – tehtävän otsikko  
- `description: String` – tehtävän kuvaus  
- `priority: TaskPriority` – enum (LOW, MEDIUM, HIGH)  
- `dueDate: LocalDate` – eräpäivä  
- `done: Boolean` – onko tehtävä valmis vai ei  

Sovellus käynnistyy `mockTasks`-listalla, jossa on 5 esimerkkitehtävää.

---

## Funktiot

- **`addTask(list, task): List<Task>`**  
  Lisää uuden tehtävän listan loppuun ja palauttaa päivitetyn listan.

- **`toggleDone(list, id): List<Task>`**  
  Kääntää tehtävän `done`‑tilan (`true <-> false`) annetun id:n perusteella.

- **`filterByDone(list, done): List<Task>`**  
  Suodattaa listasta vain ne tehtävät, joiden `done`‑tila vastaa parametria.

- **`sortByDueDate(list): List<Task>`**  
  Järjestää tehtävät eräpäivän mukaan nousevaan järjestykseen.  
  Sovelluksessa on toteutettu myös **toggle**, joka vaihtaa nousevan ja laskevan järjestyksen välillä.

---

## HomeScreen

`HomeScreen` on Jetpack Compose ‑näkymä, joka:

- näyttää otsikon "Task-lista (week1)"
- sisältää napit:
  - **Järjestä päivämäärän mukaan** (↑ / ↓)
  - **Näytä valmiit**
  - **Näytä kaikki**
  - **Lisää uusi tehtävä**
- näyttää tehtävälistan `TaskRow`‑komponentin avulla
- jokaisella rivillä on **Done/Undo**‑nappi, joka vaihtaa tehtävän tilan

Lista on Compose‑tilassa:

- `allTasks` = koko tehtävälista  
- `tasks` = suodatettu/näytettävä lista  

Tämä varmistaa, että suodatus ja järjestäminen eivät nollaa tehtävien tiloja.

---

## Käyttö

- **Lisää uusi tehtävä** → luo uuden Task‑olion ja lisää sen listaan  
- **Done/Undo** → vaihtaa yksittäisen tehtävän tilan  
- **Näytä valmiit** → näyttää vain `done = true` tehtävät  
- **Näytä kaikki** → palauttaa koko listan näkyviin  
- **Järjestä päivämäärän mukaan** → vaihtaa nousevan ja laskevan järjestyksen välillä  

---

