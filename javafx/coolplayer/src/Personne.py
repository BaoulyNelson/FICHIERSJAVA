import random

# Définition de la classe Person
class Person:
    def __init__(self,code, name, age):

        self.name = name
        self.age = age

    def __str__(self):
        return f"Person(name={self.name}, age={self.age})"

# Code principal
if __name__ == "__main__":
    # Saisie au clavier pour le nom et l'âge
    name = input("Entrez le nom : ")
    age = int(input("Entrez l'âge : "))

    # Création d'une instance de la classe Person avec les valeurs saisies
    personne1 = Person(name, age)

    # Utilisation de la méthode __str__ pour obtenir une représentation sous forme de chaîne
    representation_chaine = str(personne1)

    # Impression de la représentation sous forme de chaîne
    print(representation_chaine)
