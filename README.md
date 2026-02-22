# Projekt Epsilon
**Projekt Epsilon** je textová adventura z prostředí výzkumné vesmírné stanice, která se nachází v kritickém stavu. Hlavní hrdina, inženýr Viktor, se probouzí do probíhajícího režimu autodestrukce poté, co palubní AI postihla neznámá chyba. Cílem hry je prozkoumat stanici, získat potřebné vybavení a restartovat hlavní terminál v jádru stanice dříve, než dojde ke kolapsu systémů.

## Ovládání hry
Hra se ovládá zadáváním textových příkazů do konzole. Většina příkazů vyžaduje cíl (např. název místnosti nebo předmětu).

### Seznam příkazů:
* **`go <místnost>`**: Přesun do sousední lokace (např. `go corridor`).
* **`take <předmět>`**: Sebere předmět v místnosti a vloží jej do batohu (např. `take flashlight`).
* **`drop <předmět>`**: Vyjme předmět z batohu a položí ho v aktuální místnosti.
* **`use <předmět>`**: Použije předmět v místnosti (např. `use terminal`).
* **`talk <postava>`**: Zahájí interakci s postavou (např. `talk unit-04`).
* **`inspect <cíl>`**: Detailně prozkoumá místnost nebo konkrétní předmět.
* **`hint`**: Poskytne radu pro aktuální situaci, pokud nevíte, jak dál.
* **`help`**: Vypíše seznam všech dostupných příkazů.
* **`quit`**: Okamžitě ukončí rozehranou hru.

## Herní mechaniky
* **Kapacita inventáře**: Viktor je omezen na maximálně **3 předměty**. Je nutné strategicky zvažovat, co zrovna unese.
* **Podmíněný průchod**: Některé části stanice jsou nebezpečné nebo nepřístupné bez vybavení.
* **Interakce a Questy**: Hra obsahuje jednoduché úkoly, jako je oprava poškozeného robota pomocí **baterie**.
* **Vítězství**: Hráč vyhrává v momentě, kdy v místnosti "AI Core" úspěšně použije servisní kartu a zadá správný kód.

## Jak hru spustit
- Projekt využívá **Maven** pro správu závislostí a sestavení. Příkazy spouštějte v kořenovém adresáři projektu.

1. **Kompilace:**
```
mvn compile
```
2.  **Spuštění:**
```
mvn exec:java
```
## Technické informace
- **Jazyk**: Java 25+