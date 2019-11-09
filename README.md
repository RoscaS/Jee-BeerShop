# JEE: BeerShop

## Db

* In `/home/sol/Code/Java/04_JEE/dockerized-tools/mysql`
    * `docker-compose up`
    
* user: root
* pw: root
* port: 3306
* db: beershop

## Todo (5 novembre 2019)

* [cours](https://github.com/sebChevre/cours-JEE-2019-2020/wiki/JEE---requ%C3%AAtes-en-bases-de-donn%C3%A9es)

1. Créer un nouveau contrôleur, qui répond au path /bieres, et qui affiche, dans une page jsp, la liste des bières: **OK**
2. Adapter la méthode findAllBieres(BiereDAO), afin qu'elle retourne une liste de Biere, et non plus de String. Adapter le contrôleur et la page en conséquence: **OK**
3. Adapter le contrôleur le fait qu'il réponse aussi au path /biere/[id], ou id représente l'identifiant d'une bière. Retourner une page affichant le détail de la bière: **OK**