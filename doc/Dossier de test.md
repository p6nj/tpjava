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
  - [4. Campagne de test](#4-campagne-de-test)
    - [1. Tests](#1-tests)
    - [2. Résultats](#2-résultats)
  - [5. Conclusion](#5-conclusion)
  
## 1. Introduction
Ce dossier de test est destiné à tester les différentes classes du TP. Comme actuellement seuls les packages `vue`, `modele` et plus tard `controlleur` sont utilisés, il s'agira de tester les méthodes de la version des classes `Date` du package `modele`. Notez que l'énoncé nous demande de tester la méthode `dernierJourDuMois()` mais que le nom de cette fonction dans le projet actuel est `nbJoursDansMois()` ; cela n'affecte pas le comportement de la fonction et donc le test associé.

## 2. Description de la procédure de test
Les tests seront tous conçus dans ce dossier puis développés, exécutés et enfin versionnés un par un (ou en groupe lors de dépendances d'un test sur un autre) afin de régler au plus tôt les erreurs de conception des tests de manière récursive. L'exécution sera ensuite ordonnée par un schéma de dépendances et cette ordre sera appliqué dans la classe de test à l'aide des décorateurs intégrés à JUnit.

## 3. Description des informations à enregistrer pour le test
Le résultat des tests sont directement visibles dans l'onglet du volet latéral de Visual Studio Code fourni par l'extension Tests Explorer après exécution au même endroit.

## 4. Campagne de test
| Contexte                             |                                                                                                                                                      |
| :----------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------- |
| Configuration logicielle :           | Visual Studio 1.77, Java Extension Pack 0.9, Test Explorer, JUnit intégré par Maven (Java Extension Pack), OpenJDK 11, git 2.34.1, Pop!_OS 22.04 LTS |
| Configuration matérielle :           | AMD® Ryzen 5 4500u with radeon graphics × 6, 8 GiB RAM && 12th Gen Intel® Core™ i3-1215U × 8, 16 GiB RAM                                             |
| Date de début :  31/03/2023          | Date de finalisation : indéterminée                                                                                                                  |
| Tests à appliquer :                  | CT                                                                                                                                                   |
| Responsable de la campagne de test : | Breval Ferrari                                                                                                                                       |

### 1. Tests<!-- date +"%d/%m/%Y" -->
| `anneeEstBissextile()` |                                                                                                            |
| :--------------------- | :--------------------------------------------------------------------------------------------------------- |
| Identification : AB    | Version : 0.1                                                                                              |
| Description :          | Renvoie un boolean indiquant la bissextilité de l'année. Quatre années de chaque catégorie seront testées. |
| Resesources requises : | Classe `Date` du package `modele` situé dans `/src/main/java/modele`, Java JDK + JRE                       |
| Responsable :          | Breval Ferrari                                                                                             |

| Classe |   Année    | Résultats Attendus |
| :----- | :--------: | :----------------: |
| P1     | Bissextile |         V          |
| P1     | Classique  |         F          |

| Classe | Année | Résultats Attendus |
| :----- | :---: | :----------------: |
| P1.1   | 2016  |         V          |
| P1.2   | 2020  |         V          |
| P1.3   | 2024  |         V          |
| P1.4   | 2028  |         V          |
| P2.1   | 2017  |         F          |
| P2.2   | 2018  |         F          |
| P2.3   | 2019  |         F          |
| P2.4   | 2023  |         F          |


| `nbJoursDansMois()`    |                                                                                            |
| :--------------------- | :----------------------------------------------------------------------------------------- |
| Identification : JM    | Version : 0.1                                                                              |
| Description :          | Cette fonction retourne le nombre de jours dans le mois de l'instance de la classe `Date`. |
| Resesources requises : | Classe `Date` du package `modele` situé dans `/src/main/java/modele`, Java JDK + JRE       |
| Responsable :          | Breval Ferrari                                                                             |

| Classe |                      Mois                      |   Année    | Résultats Attendus |
| :----- | :--------------------------------------------: | :--------: | :----------------: |
| P1     | Janvier/Mars/Mai/Juillet/Août/Octobre/Décembre | Classique  |         31         |
| P2     | Janvier/Mars/Mai/Juillet/Août/Octobre/Décembre | Bissextile |         31         |
| P3     |         Avril/Juin/Septembre/Novembre          | Classique  |         30         |
| P4     |         Avril/Juin/Septembre/Novembre          | Bissextile |         30         |
| P5     |                    Février                     | Classique  |         28         |
| P6     |                    Février                     | Bissextile |         29         |

| Classe | Mois  | Année | Résultats Attendus |
| :----- | :---: | :---: | :----------------: |
| P1.1   |  01   | 2021  |         31         |
| P1.2   |  03   | 2021  |         31         |
| P1.3   |  05   | 2021  |         31         |
| P1.4   |  07   | 2021  |         31         |
| P1.5   |  08   | 2021  |         31         |
| P1.6   |  10   | 2021  |         31         |
| P1.7   |  12   | 2021  |         31         |
| P2.1   |  01   | 2020  |         31         |
| P2.2   |  03   | 2020  |         31         |
| P2.3   |  05   | 2020  |         31         |
| P2.4   |  07   | 2020  |         31         |
| P2.5   |  08   | 2020  |         31         |
| P2.6   |  10   | 2020  |         31         |
| P2.7   |  12   | 2020  |         31         |
| P3.1   |  04   | 2021  |         30         |
| P3.2   |  06   | 2021  |         30         |
| P3.3   |  09   | 2021  |         30         |
| P3.4   |  11   | 2021  |         30         |
| P4.1   |  04   | 2020  |         30         |
| P4.2   |  06   | 2020  |         30         |
| P4.3   |  09   | 2020  |         30         |
| P4.4   |  11   | 2020  |         30         |
| P5     |  02   | 2021  |         28         |
| P6     |  02   | 2020  |         29         |


| `Date()`               |                                                                                                                                                                                                                                                                      |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Identification : DA    | Version : 0.1                                                                                                                                                                                                                                                        |
| Description :          | Constructeur de la classe `Date` sans paramètre qui retourne la date courante. Il conviendra pour ce test d'utiliser une autre méthode de récupération de date ; comme les tests sont exécutés sur une distribution Linux, la commande `date` de l'OS sera utilisée. |
| Resesources requises : | Classe `Date` du package `modele` situé dans `/src/main/java/modele`, Java JDK + JRE                                                                                                                                                                                 |
| Responsable :          | Breval Ferrari                                                                                                                                                                                                                                                       |

| Classe | Résultats Attendus |
| :----- | :----------------: |
| P1     |   Date actuelle    |


| `compareTo()`          |                                                                                      |
| :--------------------- | :----------------------------------------------------------------------------------- |
| Identification : CT    | Version : 0.1                                                                        |
| Description :          | Implémentation de la fonction `compareTo` incluse dans les librairies standard.      |
| Resesources requises : | Classe `Date` du package `modele` situé dans `/src/main/java/modele`, Java JDK + JRE |
| Responsable :          | Breval Ferrari                                                                       |

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

### 2. Résultats
| Test 1                       |                |
| :--------------------------- | :------------- |
| Référence du test appliqué : | AB             |
| Responsable :                | Breval Ferrari |
| Date d'application :         | 08/04/2023     |
| Résultat :                   | OK             |
| Occurences des résultats :   | Systématique   |

| Test 2                       |                |
| :--------------------------- | :------------- |
| Référence du test appliqué : | JM             |
| Responsable :                | Breval Ferrari |
| Date d'application :         | 08/04/2023     |
| Résultat :                   | OK             |
| Occurences des résultats :   | Systématique   |

| Test 3                       |                |
| :--------------------------- | :------------- |
| Référence du test appliqué : | DA             |
| Responsable :                | Breval Ferrari |
| Date d'application :         | 08/04/2023     |
| Résultat :                   | OK             |
| Occurences des résultats :   | Systématique   |

## 5. Conclusion
/