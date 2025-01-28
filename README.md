# **ProductApp API**

Uma API para gerenciamento de produtos, construída com ***Java 17, Spring Boot, Docker, MySQL e Swagger.***

# **Visão Geral**

- A ProductApp API permite:

- Cadastrar novos produtos

- Listar todos os produtos

- Buscar produtos por nome

- Recuperar um produto pelo ID

[!NOTE]
A documentação da API pode ser acessada via Swagger UI.

# **Tecnologias Utilizadas**

- Java 17 🏗️

- Spring Boot 🚀

- MySQL 🗄️

- Docker 🐳

- Swagger 📜

# **Configuração Inicial**

## Pré-requisitos

- Java 17 JDK

- Docker e Docker Compose

- MySQL (ou utilize a versão Dockerizada)

- Maven (para compilar o projeto)

# **Instalação**

## Clone o repositório
```
git clone https://github.com/FeKom/ProductApp.git
cd ProductApp
```

## Compile o projeto

```
mvn clean install
```

## Execute com Docker 

```
docker-compose up --build
```

A API estará disponível em: http://localhost:4000

[!WARNING]
Se os containers já estiverem em execução, essa ação pode sobrescrevê-los.

# **Endpoints da API**

## Cadastrar um Produto 

### POST `/product`

### Request Body:
```
{
"title": "Product Name",
"price": 19.99,
"review": 5
}
```

### Exemplo cURL:

```
curl -X 'POST' \
'http://localhost:4000/product' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"title": "Product Name",
"price": 19.99,
"review": 5
}'
```

# **Listar Todos os Produtos**📜

### GET `/product`

### Exemplo cURL:
```
curl -X 'GET' \
'http://localhost:4000/product' \
-H 'accept: */*'
```

# **Buscar Produto por ID** 🔎

### GET `/product/{id}`

 Substitua `{id}` pelo ID do produto.

### Exemplo cURL:
```
curl -X 'GET' \
'http://localhost:4000/product/1' \
-H 'accept: */*'
```
# **Buscar Produto por Nome** 🔍

### GET `/product/search/{name}`

Substitua `{name}` pelo nome do produto.

### Exemplo cURL:
```
curl -X 'GET' \
'http://localhost:4000/product/search/Product%20Name' \
-H 'accept: */*'
```
# **Documentação Swagger**

- Swagger UI: http://localhost:4000/swagger-ui.html

- OpenAPI JSON: http://localhost:4000/v3/api-docs

# **Configuração do Banco de Dados**

A aplicação utiliza **MySQL** como banco de dados. O arquivo `docker-compose.yml` configura um container MySQL com as seguintes credenciais padrão:

- **Banco de Dados:**  `productdb`

- **Usuário:** `root`

- **Senha:** `password`

[!CAUTION]
Antes de implantar em produção, altere essas credenciais no arquivo `application.yml.`