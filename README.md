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