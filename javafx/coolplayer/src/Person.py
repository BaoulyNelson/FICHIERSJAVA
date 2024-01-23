class Personne:
    def __init__(self, code, nom, prenom):
        self.code = code
        self.nom = nom
        self.prenom = prenom

    def enregistrerPersonne():
        code =int( input("entrer ton code: "))
        nom = input("entrer ton nom: ")
        prenom = input("entrer ton prenom: ")
        print(f"tu as entre '{code}' comme code, {nom} comme nom, et {prenom} comme prenom")

    print()
    enregistrerPersonne()
