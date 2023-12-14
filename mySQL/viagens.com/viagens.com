CREATE DATABASE  IF NOT EXISTS `viagens.com` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `viagens.com`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: viagens.com
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `destino`
--

DROP TABLE IF EXISTS `destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destino` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `localizacao` varchar(255) DEFAULT NULL,
  `nome_destino` varchar(255) DEFAULT NULL,
  `orcamento_id` bigint DEFAULT NULL,
  `promocao_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ylrcu4cr9t0ich7siul0tspd` (`orcamento_id`),
  KEY `FKln2bopsk3m9rk56tr0ccpurf7` (`promocao_id`),
  CONSTRAINT `FK5ylrcu4cr9t0ich7siul0tspd` FOREIGN KEY (`orcamento_id`) REFERENCES `orcamento` (`id`),
  CONSTRAINT `FKln2bopsk3m9rk56tr0ccpurf7` FOREIGN KEY (`promocao_id`) REFERENCES `promocao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino`
--

LOCK TABLES `destino` WRITE;
/*!40000 ALTER TABLE `destino` DISABLE KEYS */;
INSERT INTO `destino` VALUES (1,'Conhecida por sua cultura afro-brasileira, praias lindas, comidas tipícas, música, dança e o famoso Carnaval.','Brasil','Salvador',NULL,3),(2,'Um importante centro financeiro e cultural, com diversas opções de restaurantes, vida noturna e eventos culturais.','Brasil','São Paulo',NULL,NULL),(3,'Famoso pelas praias icônicas como Copacabana e Ipanema, pelo Cristo Redentor e pelo Carnaval.','Brasil','Rio de janeiro',NULL,2),(4,'A região possui piscinas de águas claras e mornas formadas entre corais, além de estuários, mangues, areia branca e coqueirais.','Brasil','Porto de Galinhas',NULL,1),(5,'O Parque Nacional da Chapada dos Veadeiros fica no estado de Goiás, no centro do Brasil. É conhecido pelos deslumbrantes desfiladeiros e formações de cristais de quartzo.','Brasil','Chapada dos Veadeiros',NULL,NULL),(6,'Fortaleza é a capital do estado do Ceará, no Nordeste brasileiro. A cidade é conhecida por suas praias, com falésias vermelhas, palmeiras, dunas e lagoas.','Brasil','Fortaleza',NULL,3),(7,'Foz do Iguaçu, cidade no estado brasileiro do Paraná, é a principal base para visitar as famosas Cataratas do Iguaçu, uma das maiores cachoeiras do mundo.','Brasil','Foz do Iguaçu',NULL,2),(8,'A natureza é a principal atração do lugar, as pessoas vêm especialmente para o kitesurf e para visitar o maravilhoso Parque Nacional dos Lençóis Maranhenses, com sua paisagem lunar e dunas.','Brasil','Lençóis Maranhenses',NULL,3),(9,'Lisboa é a capital de Portugal, situada na costa. Do imponente Castelo de São Jorge, a vista abrange as construções em tons pastel da cidade antiga, o estuário do Tejo e a Ponte 25 de Abril. Perto dali.','Portugal','Lisboa',NULL,3),(10,'Porto, a segunda maior cidade de Portugal, é um destino encantador que mescla história, cultura e beleza cênica de maneira única. Localizada na costa noroeste do país.','Portugal','Porto',NULL,2),(11,'Roma, a capital da Itália, é uma cidade cosmopolita, enorme, com quase 3.000 anos de arte, arquitetura e cultura influentes no mundo todo e à mostra.','Itália','Roma',NULL,1),(12,'Conjunto de lindas ilhas unidas através de pontes charmosas. Apaixonante, cheia de pequenos e grandes canais.','Itália','Veneza',NULL,2),(13,'Madri, a capital da Espanha, situada no centro do país, é uma cidade de avenidas elegantes e parques grandes e bem cuidados, como o Buen Retiro.','Espanha','Madri',NULL,NULL),(14,'Cidade muito vibrante, moderna, elegante, cheia de opções culturais e hotéis incríveis.','Inglaterra','Londres',NULL,NULL),(15,'San Carlos de Bariloche é uma cidade na região da Patagônia argentina. Limitada pelo lago glacial Nahuel Huapi, junto à Cordilheira dos Andes.','Uruguai','Bariloche',NULL,3),(16,'Punta del Este é uma cidade turística situada numa península estreita no sudeste do Uruguai. A popular praia Brava é conhecida pelo surf intenso, bem como pela “Mano”.','Uruguai','Punta del Este',NULL,NULL);
/*!40000 ALTER TABLE `destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento`
--

DROP TABLE IF EXISTS `orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orcamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome_cliente` varchar(255) DEFAULT NULL,
  `quantidade_pessoas` int NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `destino_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhtuu5twihdrpoedf6xn69xq4b` (`destino_id`),
  CONSTRAINT `FKhtuu5twihdrpoedf6xn69xq4b` FOREIGN KEY (`destino_id`) REFERENCES `destino` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento`
--

LOCK TABLES `orcamento` WRITE;
/*!40000 ALTER TABLE `orcamento` DISABLE KEYS */;
INSERT INTO `orcamento` VALUES (1,'samuelsaantos2@hotmail.com','Samuel Santos',2,'(71) 9995-7654',1),(2,'lucasfernando@hotmail.com','Lucas Fernado',1,'(81) 6579-7754',11),(3,'luisfelipe@hotmail.com','Luís Felipe Santos',1,'(91) 4444-7754',14),(4,'canetaazul@hotmail.com','Manuel Gomes',1,'(61) 3464-7854',15),(5,'neycai_junior@hotmail.com','Neymar Junior',5,'(61) 9764-6034',13);
/*!40000 ALTER TABLE `orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao`
--

DROP TABLE IF EXISTS `promocao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `nome_promocao` varchar(255) DEFAULT NULL,
  `validade` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao`
--

LOCK TABLES `promocao` WRITE;
/*!40000 ALTER TABLE `promocao` DISABLE KEYS */;
INSERT INTO `promocao` VALUES (1,'20%/OFF','promoção Relâmpago','2024-01-01 03:00:00.000000'),(2,'30%/OFF','promoção do mês','2023-12-31 03:00:00.000000'),(3,'50%/OFF','Natal','2023-12-25 03:00:00.000000');
/*!40000 ALTER TABLE `promocao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-14 16:18:01
