SELECT COUNT(*), SUM(importo) FROM fattura
GROUP BY EXTRACT(YEAR FROM data_fattura)