# 🎬 ScreenMatch API

API REST para gerenciamento de filmes com CRUD completo.

## 🚀 API em Produção

**🌐 https://scrennmatch-api.onrender.com/api/filmes**

> ✅ API funcionando no Render com banco H2 em memória

---

## 📋 Sobre o Projeto

API REST desenvolvida em **Java 17** com **Spring Boot 3.2.0** para gerenciar catálogo de filmes.

✅ **CRUD Completo** - Listar, Buscar, Criar, Atualizar, Deletar  
✅ **Organização** - Código em camadas (Controller → Service → Repository → Model)  
✅ **Tratamento de Erros** - Mensagens claras e códigos HTTP corretos  
✅ **Deploy Render** - Aplicação online e funcionando  
✅ **GitHub** - Repositório público com commits organizados  
✅ **Documentação** - README completo com exemplos  

---

## 🛠️ Tecnologias

- ☕ Java 17
- 🍃 Spring Boot 3.2.0
- 🗄️ H2 Database (em memória)
- 🐳 Docker
- 📦 Maven
- 🚀 Render

---

## 📍 Como Usar a API

### **Base URL**
```
https://scrennmatch-api.onrender.com/api/filmes
```

### **1️⃣ Listar Todos os Filmes (GET)**

Acesse no navegador ou use:

```powershell
curl https://scrennmatch-api.onrender.com/api/filmes -UseBasicParsing
```

**Resposta 200:**
```json
[]
```

### **2️⃣ Criar um Filme (POST)**

```powershell
$json = '{"titulo":"Matrix","ano":1999,"diretor":"Wachowski","genero":"Ficcao Cientifica"}'
Invoke-RestMethod -Method POST -Uri "https://scrennmatch-api.onrender.com/api/filmes" -Body $json -ContentType "application/json; charset=utf-8"
```

**Resposta 201:**
```json
{
  "id": 1,
  "titulo": "Matrix",
  "ano": 1999,
  "diretor": "Wachowski",
  "genero": "Ficcao Cientifica"
}
```

### **3️⃣ Buscar Filme por ID (GET)**

```powershell
curl https://scrennmatch-api.onrender.com/api/filmes/1 -UseBasicParsing
```

**Resposta 200:**
```json
{
  "id": 1,
  "titulo": "Matrix",
  "ano": 1999,
  "diretor": "Wachowski",
  "genero": "Ficcao Cientifica"
}
```

### **4️⃣ Atualizar Filme (PUT)**

```powershell
$json = '{"titulo":"Matrix Reloaded","ano":2003,"diretor":"Wachowski","genero":"Acao"}'
Invoke-RestMethod -Method PUT -Uri "https://scrennmatch-api.onrender.com/api/filmes/1" -Body $json -ContentType "application/json; charset=utf-8"
```

### **5️⃣ Deletar Filme (DELETE)**

```powershell
Invoke-RestMethod -Method DELETE -Uri "https://scrennmatch-api.onrender.com/api/filmes/1"
```

**Resposta:** 204 No Content

---

## 🚀 Como Rodar Localmente

```powershell
# 1. Clone o repositório
git clone https://github.com/dappter/screenmatch.git
cd screenmatch

# 2. Execute com Maven Wrapper
.\mvnw.cmd spring-boot:run

# 3. Acesse
# http://localhost:8080/api/filmes
```
---

## 🗂️ Estrutura do Projeto

```
src/main/java/br/com/alura/screenmatch/
├── ScreenmatchApplication.java       # Main
├── controller/
│   └── FilmeController.java          # Endpoints REST
├── service/
│   └── FilmeService.java             # Lógica de negócio
├── repository/
│   └── FilmeRepository.java          # Acesso ao banco
├── model/
│   └── Filme.java                    # Entidade JPA
├── dto/
│   └── FilmeDTO.java                 # Data Transfer Object
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java   # Tratamento de erros
```

---

## 📊 Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/filmes` | Lista todos os filmes |
| GET | `/api/filmes/{id}` | Busca filme por ID |
| POST | `/api/filmes` | Cria novo filme |
| PUT | `/api/filmes/{id}` | Atualiza filme |
| DELETE | `/api/filmes/{id}` | Deleta filme |
| GET | `/api/filmes/buscar/titulo/{titulo}` | Busca por título |
| GET | `/api/filmes/buscar/genero/{genero}` | Busca por gênero |
| GET | `/api/filmes/buscar/ano/{ano}` | Busca por ano |

---

## ⚠️ Observações Importantes

- **Banco H2:** Os dados são armazenados em memória e são perdidos quando a aplicação reinicia
- **Primeira requisição:** No Render pode demorar ~30 segundos (aplicação gratuita "acorda")
- **Acentuação:** Evite caracteres especiais (ã, ç, í) nos dados para melhor compatibilidade

---

## ✅ Checklist do Projeto

- ✅ CRUD completo implementado
- ✅ Código organizado em camadas
- ✅ Tratamento de erros
- ✅ Retornos JSON com códigos HTTP corretos
- ✅ Deploy no Render funcionando
- ✅ Repositório GitHub público
- ✅ Documentação completa

---

## 🔗 Links

- **API Online:** https://scrennmatch-api.onrender.com/api/filmes
- **GitHub:** https://github.com/dappter/screenmatch

---

**Desenvolvido para:** Alura - Backend Challenge  
**Data:** Novembro 2025
