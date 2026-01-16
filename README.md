📦 Sistema de Gestão de Equipamentos — Microserviços

Este projeto é um sistema de gestão de equipamentos desenvolvido com arquitetura de microserviços, utilizando Spring Boot e Spring Cloud Gateway.
O objetivo é simular um cenário real de mercado, aplicando boas práticas como separação de responsabilidades, comunicação entre serviços e uso de um API Gateway como ponto único de entrada.

🏗️ Arquitetura

O sistema é composto por 4 aplicações:

api-gateway → Roteamento central das requisições

equipment-service → Gestão de equipamentos

loan-service → Controle de empréstimos

notification-service → Envio de notificações

Fluxo:

Cliente → API Gateway → Microserviço responsável

🚀 Tecnologias utilizadas

Java 21

Spring Boot 3.x

Spring Cloud Gateway

Maven

REST API

Arquitetura em Microserviços

Postman para testes

Git & GitHub

🔌 Endpoints disponíveis
🔹 API Gateway

Base URL:

http://localhost:8080

🧰 Equipment Service

Base:

/api/equipments

➕ Criar equipamento

POST /api/equipments

{
  "name": "Notebook Dell",
  "serialNumber": "SN123456",
  "status": "AVAILABLE"
}

🔍 Buscar equipamento por ID

GET /api/equipments/{id}

✅ Verificar disponibilidade

GET /api/equipments/{id}/available

Resposta:

{
  "available": true
}

🔄 Atualizar status

PUT /api/equipments/{id}/status?status=DISPONIVEL

Status possíveis:

AVAILABLE
UNAVAILABLE
LOANED

🗑️ Desativar equipamento (soft delete)

DELETE /api/equipments/{id}

📚 Loan Service

Base:

/api/loans

➕ Criar empréstimo

POST /api/loans

{
  "equipmentId": 1,
  "userName": "João Silva",
  "loanDate": "2026-01-15"
}

🔍 Buscar empréstimo por ID

GET /api/loans/{id}

📄 Listar empréstimos

GET /api/loans

🔔 Notification Service

Base:

/api/notifications

📩 Enviar notificação

POST /api/notifications

{
  "to": "joao@email.com",
  "message": "Seu empréstimo foi aprovado!"
}

🎯 Objetivo do projeto

Este projeto foi desenvolvido com foco em:

Aprender microserviços na prática

Trabalhar com API Gateway

Aplicar boas práticas de arquitetura

Simular um ambiente real de backend corporativo

Evoluir habilidades em Spring Boot e integrações REST
