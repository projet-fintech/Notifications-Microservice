
---

### **Notification Microservice (README)**



![image](https://github.com/user-attachments/assets/734e0425-d2c5-48eb-9f88-20ec8fd30572)


```markdown
# Notification Microservice

## Description
Ce microservice gère l'envoi des notifications par email. Il est utilisé par d'autres microservices pour informer les utilisateurs d'événements importants, comme la création d'un compte ou l'approbation d'une demande.

## Fonctionnalités
- Envoi d'emails de confirmation.
- Intégration avec les microservices via Rest.

## Dépendances
- Spring Boot Mail
- Kafka
- Eureka Client

## Configuration
- Configurez les paramètres SMTP dans `application.yml` :
  - `mail.host`
  - `mail.port`
  - `mail.username`
  - `mail.password`

