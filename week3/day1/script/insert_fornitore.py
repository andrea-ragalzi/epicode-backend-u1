import os
import random
from datetime import datetime

import psycopg2
from dotenv import load_dotenv

load_dotenv()

DATABASE_CONFIG = {
    "database": os.getenv("DB_NAME"),
    "host": os.getenv("DB_HOST"),
    "user": os.getenv("DB_USER"),
    "password": os.getenv("DB_PASSWORD"),
}
NUM_RECORDS = 100

denominazioni = ['Rosa', 'Tulipano', 'Margherita', 'Girasole', 'Lavanda',
                 'Iris', 'Orchidea', 'Peonia', 'Gelsomino', 'Mimosa']


regioni = ['Lombardia', 'Lazio', 'Campania', 'Sicilia', 'Piemonte',
           'Puglia', 'Emilia-Romagna', 'Toscana', 'Veneto', 'Calabria']

conn = psycopg2.connect(**DATABASE_CONFIG)

cur = conn.cursor()


def crea_fornitore():
    """
    Crea un fornitore con valori casuali pseudoreali
    """
    numero_fornitore = random.randint(1, 10000)
    denominazione = random.choice(denominazioni)
    regione_residenza = random.choice(regioni)
    return (numero_fornitore, denominazione, regione_residenza)


def inserisci_fornitore(fornitore):
    """
    Inserisce il fornitore nella tabella fornitore
    """
    query = "INSERT INTO fornitore (numero_fornitore, denominazione, regione_residenza) VALUES (%s, %s, %s)"
    cur.execute(query, fornitore)


# Inserimento dei record nella tabella
for i in range(NUM_RECORDS):
    inserisci_fornitore(crea_fornitore())

# Commit delle modifiche e chiusura della connessione
conn.commit()
cur.close()
conn.close()

# Output finale
print(
    f"Inseriti {NUM_RECORDS} record nella tabella 'fornitore' su '{DATABASE_CONFIG['database']}'")
