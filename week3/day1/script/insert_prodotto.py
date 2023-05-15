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
NUM_RECORDS = 10000

conn = psycopg2.connect(**DATABASE_CONFIG)

cur = conn.cursor()


def crea_prodotto():
    """
    Crea un prodotto con valori casuali pseudoreali
    """
    descrizione = f"Prodotto {i+1}"
    in_produzione = random.choice([True, False])
    in_commercio = random.choice([True, False])
    data_attivazione = datetime.now()
    data_disattivazione = data_attivazione.replace(
        year=data_attivazione.year + 1)
    return (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione)


def inserisci_prodotto(prodotto):
    """
    Inserisce il prodotto nella tabella prodotto
    """
    query = "INSERT INTO prodotto (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES (%s, %s, %s, %s, %s)"
    cur.execute(query, prodotto)


for i in range(NUM_RECORDS):
    inserisci_prodotto(crea_prodotto())


conn.commit()
cur.close()
conn.close()

# Output finale
print(
    f"Inseriti {NUM_RECORDS} record nella tabella 'prodotto'")
