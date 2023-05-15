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
NUM_RECORDS = 1000

nomi = ['Mario', 'Luigi', 'Paolo', 'Marco', 'Giovanni',
        'Laura', 'Chiara', 'Anna', 'Giulia', 'Federica']
cognomi = ['Rossi', 'Bianchi', 'Neri', 'Verdi', 'Gialli',
           'Azzurri', 'Viola', 'Marrone', 'Rosa', 'Arancione']

regioni = ['Lombardia', 'Lazio', 'Campania', 'Sicilia', 'Piemonte',
           'Puglia', 'Emilia-Romagna', 'Toscana', 'Veneto', 'Calabria']

conn = psycopg2.connect(**DATABASE_CONFIG)

cur = conn.cursor()


def crea_cliente():
    """
    Crea un cliente con valori casuali pseudoreali
    """
    nome = random.choice(nomi)
    cognome = random.choice(cognomi)
    data_nascita = datetime(random.randint(1950, 2000), random.randint(
        1, 12), random.randint(1, 28)).strftime('%Y-%m-%d')
    regione_residenza = random.choice(regioni)
    return (nome, cognome, data_nascita, regione_residenza)


def inserisci_cliente(cliente):
    """
    Inserisce il cliente nella tabella cliente
    """
    query = "INSERT INTO cliente (nome, cognome, data_nascita, regione_residenza) VALUES (%s, %s, %s, %s)"
    cur.execute(query, cliente)


# Inserimento dei record nella tabella
for i in range(NUM_RECORDS):
    inserisci_cliente(crea_cliente())

conn.commit()
cur.close()
conn.close()

print(
    f"Inseriti {NUM_RECORDS} record nella tabella 'cliente' su '{DATABASE_CONFIG['database']}'")
