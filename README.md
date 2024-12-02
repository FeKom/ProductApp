# Products - docker + spring boot + mysql

## Rodando

Banco de dados:

```sh
docker-compose up -d
```

Aplicação:

```sh
mvn spring-boot:run
```

## Troubleshooting

### Volumes

Analisando volumes: 

> docker volume ls

Removendo volumes:

Referencia: https://stackoverflow.com/questions/63617333/why-is-docker-compose-creating-mysql-container-with-wrong-name

```sh 
docker volume rm {{volume_id}} -f
```

Executando Controller da Aplicação  

## CURL GET ALL METHOD

```sh
curl -X 'GET' \
  'http://localhost:4000/product' \
  -H 'accept: */*'
```

## CURL POST METHOD

```sh
curl -X 'POST' \
  'http://localhost:4000/product' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "***",
  "price": ***.**,
  "review": *
}'
```

## CURL GET BY ID METHOD

```sh
curl -X 'GET' \
  'http://localhost:4000/product/{`ID DO PRODUTO`}' \
  -H 'accept: */*'
```


## CURL SEARCH BY NAME METHOD
```sh
curl -X 'GET' \
  'http://localhost:4000/product/search/{`NOME DO PRODUTO QUE QUEIRA PROCURAR`}' \
  -H 'accept: */*'
```