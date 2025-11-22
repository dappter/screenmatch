# 🎬 ScreenMatch API

API REST para gerenciamento de filmes com CRUD completo, integrada com Supabase (PostgreSQL).

## 🚀 Link da API Publicada no Render

**🌐 https://screenmatch-api.onrender.com/api/filmes**

> ⚠️ Atualize com o link real após deploy

---

## 📋 Sobre o Projeto

API REST desenvolvida em **Java 17** com **Spring Boot 3.2.0** para gerenciar catálogo de filmes. Atende todos os requisitos:

✅ **CRUD Completo** - Listar, Buscar, Criar, Atualizar, Deletar  
✅ **Organização** - Código em camadas (Controller → Service → Repository → Model)  
✅ **Validações** - Tratamento de erros com mensagens claras  
✅ **JSON/HTTP** - Retornos corretos (200, 201, 204, 404, 500)  
✅ **Supabase** - PostgreSQL integrado  
✅ **Deploy Render** - Pronto para produção  
✅ **GitHub** - Repositório com commits organizados  
✅ **Documentação** - README completo  

---

## 🛠️ Tecnologias

- ☕ Java 17
- 🍃 Spring Boot 3.2.0
- 🗄️ PostgreSQL (Supabase)
- 📦 Maven
- 🚀 Render

---

## 🚀 Como Rodar Localmente

```powershell
# 1. Clone
git clone https://github.com/dappter/screenmatch.git
cd screenmatch

# 2. Execute (Windows com H2 em memória)
$env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
$env:SPRING_PROFILES_ACTIVE = "local"
.\mvnw.cmd spring-boot:run

# 3. Acesse
# http://localhost:8080/api/filmes
```

---

## 📍 Endpoints

**Base:** `http://localhost:8080/api/filmes`

### 1️⃣ **GET** `/api/filmes` - Listar Todos
```json
[
  {
    "id": 1,
    "titulo": "Matrix",
    "ano": 1999,
    "diretor": "Wachowski",
    "genero": "Ficção Científica"
  }
]
```

### 2️⃣ **GET** `/api/filmes/{id}` - Buscar por ID
```json
{
  "id": 1,
  "titulo": "Matrix",
  "ano": 1999,
  "diretor": "Wachowski",
  "genero": "Ficção Científica"
}
```

### 3️⃣ **POST** `/api/filmes` - Criar
```powershell
$json = '{"titulo":"Inception","ano":2010,"diretor":"Nolan","genero":"Ficção"}'
Invoke-RestMethod -Method POST -Uri "http://localhost:8080/api/filmes" `
  -Body $json -ContentType "application/json"
```

**Resposta 201:**
```json
{
  "id": 2,
  "titulo": "Inception",
  "ano": 2010,
  "diretor": "Nolan",
  "genero": "Ficção"
}
```

### 4️⃣ **PUT** `/api/filmes/{id}` - Atualizar
```powershell
$json = '{"titulo":"Matrix Reloaded","ano":2003,"diretor":"Wachowski","genero":"Ação"}'
Invoke-RestMethod -Method PUT -Uri "http://localhost:8080/api/filmes/1" `
  -Body $json -ContentType "application/json"
```

### 5️⃣ **DELETE** `/api/filmes/{id}` - Deletar
```powershell
curl -Method DELETE "http://localhost:8080/api/filmes/1" -UseBasicParsing
```
**Resposta:** 204 No Content

### 6️⃣ **GET** `/api/filmes/buscar/titulo/{titulo}`
### 7️⃣ **GET** `/api/filmes/buscar/genero/{genero}`  
### 8️⃣ **GET** `/api/filmes/buscar/ano/{ano}`

---

## 📝 Exemplos de Uso

```powershell
# Listar
curl http://localhost:8080/api/filmes -UseBasicParsing

# Criar
$json = '{"titulo":"Matrix","ano":1999}'
Invoke-RestMethod -Method POST -Uri "http://localhost:8080/api/filmes" `
  -Body $json -ContentType "application/json"

# Buscar por ID
curl http://localhost:8080/api/filmes/1 -UseBasicParsing

# Atualizar
$json = '{"titulo":"Matrix 2","ano":2003}'
Invoke-RestMethod -Method PUT -Uri "http://localhost:8080/api/filmes/1" `
  -Body $json -ContentType "application/json"

# Deletar
curl -Method DELETE "http://localhost:8080/api/filmes/1" -UseBasicParsing

# Buscar por título
curl http://localhost:8080/api/filmes/buscar/titulo/matrix -UseBasicParsing
```

---

## 🗂️ Estrutura

```
src/main/java/br/com/alura/screenmatch/
├── ScreenmatchApplication.java       # Main
├── controller/
│   └── FilmeController.java          # Endpoints REST
├── service/
│   └── FilmeService.java             # Lógica
├── repository/
│   └── FilmeRepository.java          # BD
├── model/
│   └── Filme.java                    # Entidade
├── dto/
│   └── FilmeDTO.java                 # Transfer Object
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java   # Erros
```

---

## 🚀 Deploy no Render

1. Conecte repositório GitHub
2. Configure variáveis:
```env
DATABASE_URL=jdbc:postgresql://seu-projeto.supabase.co:5432/postgres
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=sua_senha_aqui
```

3. Build: `./mvnw clean package -DskipTests`
4. Start: `java -jar target/screenmatch-1.0.0.jar`

---

## ✅ Status

| Endpoint | Status |
|----------|--------|
| GET /api/filmes | ✅ Funcionando |
| GET /api/filmes/{id} | ✅ Funcionando |
| POST /api/filmes | ✅ Funcionando |
| PUT /api/filmes/{id} | ✅ Funcionando |
| DELETE /api/filmes/{id} | ✅ Funcionando |
| Buscas | ✅ Funcionando |

---

**Desenvolvido para:** Alura - Backend Challenge  
**Data:** Novembro 2025
