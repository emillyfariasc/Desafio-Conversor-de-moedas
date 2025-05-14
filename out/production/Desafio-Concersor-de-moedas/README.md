# Desafio Conversor de moedas

Challenge Alura  (Desafio de conversor de moedas)

Configuração do Ambiente Java;

Criação do Projeto;

Consumo da API;

Análise da Resposta JSON;

Filtro de Moedas;

Exibição de Resultados aos Usuários;

## Menu

### Qual valor?

Quanto você possui atualmente?

`valor_inicial = funcao_de_entrada_de_dados()` <!-- Converter pra código em Java -->

### Qual moeda possui?

Qual cédula você possui?

Escolha abaixo a cédula para dar ínicio a conversão da moeda:
(obs: A escolha deve ser da moeda que você possui atualmente, para depois realizar a escolha da moeda convertida)

| Código | País            | Nome da Moeda          |
| ------ | --------------- | ---------------------- |
| BRL    | Brasil          | Real                   |
| AOA    | Angola          | Kwanza                 |
| USD    | Estados Unidos  | Dólar Americano        |
| EUR    | Alemanha        | Euro                   |
| ERN    | Eritreia        | Nakfa                  |
| MNT    | Mongólia        | Tugrik                 |
| KPW    | Coreia do Norte | Won Norte-Coreano      |
| BTN    | Butão           | Ngultrum               |
| RON    | Romênia         | Leu Romeno             |
| ILS    | Israel          | Novo Shekel Israelense |

`Moeda_de_origem = obter_resposta_do_usuário()` <!-- Converter pra código em Java -->

### Pra qual moeda converter?

Escolha um código abaixo o tipo de moeda para converter o seu valor:

| Código | País            | Nome da Moeda          |
| ------ | --------------- | ---------------------- |
| BRL    | Brasil          | Real                   |
| AOA    | Angola          | Kwanza                 |
| USD    | Estados Unidos  | Dólar Americano        |
| EUR    | Alemanha        | Euro                   |
| ERN    | Eritreia        | Nakfa                  |
| MNT    | Mongólia        | Tugrik                 |
| KPW    | Coreia do Norte | Won Norte-Coreano      |
| BTN    | Butão           | Ngultrum               |
| RON    | Romênia         | Leu Romeno             |
| ILS    | Israel          | Novo Shekel Israelense |

`Moeda_de_destino = obter_resposta_do_usuário()` <!-- Converter pra código em Java -->

## Armazenar informações

Agora temos 3 variáveis: `valor_inicial`, `moeda_de_origem` e `moeda_de_destino`.

Um exemplo:

- `valor_inicial = 1000`
- `moeda_de_origem = "RON"`
- `moeda_de_destino = "ILS"`

## Chamar API

`CHAVEAPI = Obter_chave_de_API()`

`url = "https://v6.exchangerate-api.com/v6/" + CHAVEAPI + "/latest/" + moeda_de_origem`

`resposta_serializada_da_requisicao = fazer_uma_requisicao(url)` <!-- Converter pra código em Java, usaremos HttpClient: Como?  --> 

## Pegar informações necessárias da resposta

`resposta_desserializada = desserializar_resposta(resposta_serializada_da_requisicao)` <!-- Converter pra código em Java, usaremos HttpResponse: Como?  -->

`imprimir(resposta_desserializada)`

<!--
{
   "result":"success",
   "documentation":"https://www.exchangerate-api.com/docs",
   "terms_of_use":"https://www.exchangerate-api.com/terms",
   "time_last_update_unix":1746835202,
   "time_last_update_utc":"Sat, 10 May 2025 00:00:02 +0000",
   "time_next_update_unix":1746921602,
   "time_next_update_utc":"Sun, 11 May 2025 00:00:02 +0000",
   "base_code":"USD",
   "conversion_rates":{
      "BRL":1.00,
      "AOA":2.22,
      "USD":3.33,
      "EUR":4.44
      "ERN":5.55,
      "MNT":6.66,
      "KPW":7.77,
      "BTN":8.88,
      "RON":9.99,
      "ILS":10.10,
    }
}
-->

`imprimir(resposta_desserializada["result"])`

<!--
"success"
-->

`imprimir(resposta_desserializada["conversion_rates"])`

<!--
{
  "BRL":1,
  "AOA":2.22,
  "USD":3.33,
  "EUR":4.44
  "ERN":5.55,
  "MNT":6.66,
  "KPW":7.77,
  "BTN":8.88,
  "RON":9.99,
  "ILS":10.10,
}
-->

`taxas_de_conversao = resposta_desserializada["conversion_rates"]` <!-- Converter pra código em Java Usando Postman e classes fornecidas pelo Gson, como JsonParser e JsonObject. -->

`taxa_de_conversão_destino = taxas_de_conversao[moeda_de_destino]`

## Calcular resultado

Valor inicial(número decimal), moeda que o usuário tem(String), cédula que ele quer converter(String), CHAVEAPI(String), URL(String), reposta serializada(String), resposta desserializada(Dicionário), taxas de conversão(dicionário), taxa de conversão_moeda de destino(número decimal);

Para o filtro de moedas, será necessário usar o atributo "Currency Code" do JSON. ss

"VALOR CONVERTIDO" é igual ao resultado do valor inicial * taxa_de_conversão_moeda de destino;

## Mensagem final 

O resultado da conversão de (moeda de origem) convertido pra (moeda de destino) é igual a (valor convertido) ; 
