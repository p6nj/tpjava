---
title:  Dossier de tests
author: Breval Ferrari
---
# Dossier de tests
## Sommaire<!-- omit in toc -->
- [Dossier de tests](#dossier-de-tests)
  - [1. Introduction](#1-introduction)
  - [2. Description de la procédure de test](#2-description-de-la-procédure-de-test)
  - [3. Description des informations à enregistrer pour le test](#3-description-des-informations-à-enregistrer-pour-le-test)
    - [1. Campagne de test](#1-campagne-de-test)
    - [2. Tests](#2-tests)
    - [3. Résultats](#3-résultats)
  - [4. Conclusions](#4-conclusions)
  
## 1. Introduction
Ce dossier de test est destiné à tester les différentes classes du TP. Comme actuellement seuls les packages `vue`, `modele` et plus tard `controlleur` sont utilisés, il s'agira de tester les méthodes de la version des classes `Date` du package `modele`.

## 2. Description de la procédure de test
Les tests seront tous conçus dans ce dossier puis développés, versionnés et enfin exécutés un par un afin de régler au plus tôt les erreurs de conception des tests de manière récursive. L'exécution sera ensuite ordonnée par un schéma de dépendances et cette ordre sera appliqué dans la classe de test à l'aide des décorateurs intégrés à JUnit.

## 3. Description des informations à enregistrer pour le test
Le résultat des tests sont directement visibles dans l'onglet du volet latéral de Visual Studio Code fourni par l'extension Tests Explorer après exécution au même endroit.

### 1. Campagne de test
| Contexte                             |                                                                                                                                                      |
| :----------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------- |
| Configuration logicielle :           | Visual Studio 1.77, Java Extension Pack 0.9, Test Explorer, JUnit intégré par Maven (Java Extension Pack), OpenJDK 11, git 2.34.1, Pop!_OS 22.04 LTS |
| Configuration matérielle :           | AMD® Ryzen 5 4500u with radeon graphics × 6, 8 GiB RAM && 12th Gen Intel® Core™ i3-1215U × 8, 16 GiB RAM                                             |
| Date de début :  31/03/2023          | Date de finalisation : indéterminée                                                                                                                  |
| Tests à appliquer :                  | DC,                                                                                                                                                  |
| Responsable de la campagne de test : | Breval Ferrari                                                                                                                                       |

### 2. Tests
| `Date.compareTo`       |                                                                                 |
| :--------------------- | :------------------------------------------------------------------------------ |
| Identification : DC    | Version : 0.1                                                                   |
| Description :          | Implémentation de la fonction `compareTo` incluse dans les librairies standard. |
| Resesources requises : | Package `/src/date`, Java JDK + JRE                                             |
| Responsable :          | Breval Ferrari                                                                  |

| Classe | Jour  | Mois  | Année | Résultats Attendus |
| :----- | :---: | :---: | :---: | :----------------: |
| P1     |   >   |   >   |   >   |         >          |
| P2     |   <   |   >   |   >   |         >          |
| P3     |   <   |   <   |   >   |         >          |
| P4     |   <   |   <   |   <   |         <          |
| P5     |   >   |   <   |   <   |         <          |
| P6     |   >   |   >   |   <   |         <          |
| P7     |   =   |   >   |   >   |         >          |
| P8     |   =   |   <   |   >   |         >          |
| P9     |   =   |   =   |   >   |         >          |
| P10    |   =   |   =   |   <   |         <          |
| P11    |   =   |   =   |   =   |         =          |
| P12    |   <   |   =   |   =   |         <          |
| P13    |   >   |   =   |   =   |         >          |
| P14    |   =   |   <   |   =   |         <          |
| P15    |   =   |   >   |   =   |         >          |
| P16    |   >   |   =   |   >   |         >          |
| P17    |   <   |   =   |   >   |         >          |
| P18    |   <   |   =   |   <   |         <          |
| P19    |   >   |   >   |   =   |         >          |
| P20    |   <   |   >   |   =   |         >          |
| P21    |   <   |   <   |   =   |         <          |

### 3. Résultats
| Test 1                       |                |
| :--------------------------- | :------------- |
| Référence du test appliqué : | DC             |
| Responsable :                | Breval Ferrari |
| Date d'application :         | NA             |
| Résultat :                   | Non fait       |
| Occurences des résultats :   | Systématique   |

## 4. Conclusions
Rien à dire