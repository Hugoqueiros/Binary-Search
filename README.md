# Binary-Search

A partir do contexto do trabalho 5, desenvolver um programa que registe o número de ocorrências dos caracteres alfabéticos (incluindo os caracteres acentuados) num texto lido a partir de um ficheiro. Os números de ocorrências dos caracteres encontrados no texto são guardados numa fila com prioridade implementada com uma árvore binária do tipo heap (max binary heap). O programa deverá permitir obter uma lista ordenada de forma decrescente dos n caracteres que ocorrem mais vezes no texto, sendo n um número inserido pelo utilizador.

Considerando o exemplo do trabalho anterior:

> Com o tempo, os engenheiros informáticos tiram partido do trabalho uns dos outros e inventam algoritmos para novas coisas. Algoritmos combinam-se com outros algoritmos para utilizar os resultados de outros algoritmos, por sua vez produzindo resultados para ainda mais algoritmos. A cada segundo, milhares de milhões de transístores em milhares de milhões de computadores ligam-se milhares de milhões de vezes. Os algoritmos formam uma nova espécie de ecossistema - em crescimento constante, de uma riqueza apenas comparável à da própria vida.

Se o utilizador indicar que quer ver a lista dos 6 caracteres mais frequentes, o programa deverá apresentar o resultado seguinte:

```
o: 49
a: 47
s: 46
e: 43
r: 34
m: 32
```

Ter em conta ainda o seguinte:

- O texto a analisar tem de ser obrigatoriamente obtido a partir de um ficheiro de texto.
Não pode ser usada a coleção TreeMap nem nenhuma outra coleção equivalente. As palavras do texto e os respetivos números de ocorrências são guardadas numa árvore binária que terá de ser desenvolvida especificamente para este projeto.
 
