# MultiVersions

**MultiVersions** est un exemple de plugin Spigot illustrant la prise en charge de plusieurs versions de serveur (1.16 et 1.17). Le projet est basé sur l'API Spigot et fournit un exemple minimal d'enregistrement d'événements spécifiques à chaque version.

## Fonctionnement

Au chargement, le plugin détecte la version du serveur puis enregistre la classe d'événements adaptée :
- `SamplePluginEvents_1_16_R1` pour les serveurs 1.16.x
- `SamplePluginEvents_1_17_R1` pour les serveurs 1.17.x

Chaque implémentation écoute `PlayerInteractEvent` et affiche un message lorsque le joueur clique avec un bâton.

## Fichiers de configuration

### plugin.yml

| Option        | Type   | Description                                                             |
|---------------|--------|-------------------------------------------------------------------------|
| `name`        | string | Nom du plugin.                                                          |
| `author`      | string | Auteur du plugin.                                                       |
| `version`     | string | Version courante du plugin.                                            |
| `main`        | string | Classe principale appelée au démarrage (`SamplePlugin`).                |
| `api-version` | string | Version minimale de l'API Spigot nécessaire (`1.16`).                   |

_Fichier situé dans `src/main/resources/plugin.yml`._

## Compilation / Installation

Le projet utilise **Maven**. Pour compiler et obtenir le JAR :

```bash
mvn clean package
```

Le fichier final se trouve dans `target/SamplePlugin-1.0.jar`.
Pour installer le plugin, placez ce JAR dans le dossier `plugins/` de votre serveur Spigot.

## Fichiers importants

- `SamplePlugin.java` — classe principale initialisant la détection de version et l'enregistrement des événements.
- `SamplePluginEvents.java` — interface commune aux gestionnaires d'événements.
- `SamplePluginEvents_1_16_R1.java` — implémentation pour la version 1.16.x.
- `SamplePluginEvents_1_17_R1.java` — implémentation pour la version 1.17.x.

Les sources se trouvent dans `src/main/java/fr/darkbow_/sampleplugin/`.

## Utilisation rapide

1. Compilez le projet puis copiez `SamplePlugin-1.0.jar` dans `plugins/`.
2. Lancez (ou redémarrez) votre serveur Spigot.
3. Connectez-vous et utilisez un bâton : un message sera diffusé selon la version du serveur.

