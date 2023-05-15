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
NUM_RECORDS = 500

conn = psycopg2.connect(**DATABASE_CONFIG)

cur = conn.cursor()


def crea_fattura():
    """
    Crea una fattura con valori casuali pseudoreali
    """
    random.seed()
    tipologia = random.choice(['Fattura', 'Nota di credito'])
    importo = round(random.uniform(10.0, 1000.0), 2)
    iva = random.choice([0, 4, 10, 22])
    data_fattura = datetime.now()
    fk_cliente = random.randint(1, 3000)
    
    while True:
        fk_fornitore = random.randint(1, 100)
        cur.execute("SELECT COUNT(*) FROM fornitore WHERE numero_fornitore = %s", (fk_fornitore,))
        count = cur.fetchone()[0]
        if count > 0:
            break
    return (tipologia, importo, iva, data_fattura, fk_cliente, fk_fornitore)



def inserisci_fattura(fattura):
    """
    Inserisce la fattura nella tabella fattura
    """
    query = "INSERT INTO fattura (tipologia, importo, iva, data_fattura, cliente, fornitore) VALUES (%s, %s, %s, %s, %s, %s)"
    cur.execute(query, fattura)


for i in range(NUM_RECORDS):
    inserisci_fattura(crea_fattura())

conn.commit()
cur.close()
conn.close()

# Output finale
print(
    f"Inseriti {NUM_RECORDS} record nella tabella 'fattura'")
