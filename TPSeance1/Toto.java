import java.util.Arrays;

/**
 * Toto
 */
public class Toto {
public static void main(String[] args) {
    
// Exemples d'utilisation des méthodes de la classe String

String str = "Hello, World!";

// charAt() - Récupère le caractère à l'index spécifié (ici, l'index 7).
char character = str.charAt(7);
System.out.println("charAt(7): " + character);

// codePointAt() - Récupère la valeur Unicode du caractère à l'index spécifié.
int unicodeValue = str.codePointAt(0); // Le caractère 'H' a la valeur Unicode 72.
System.out.println("codePointAt(0): " + unicodeValue);

// compareTo() - Compare deux chaînes lexicographiquement.
int compareResult = str.compareTo("Hello, Java!");
System.out.println("compareTo(): " + compareResult);

// concat() - Ajoute une chaîne à la fin d'une autre chaîne.
String newStr = str.concat(" How are you?");
System.out.println("concat(): " + newStr);

// contains() - Vérifie si une chaîne contient une séquence de caractères spécifiée.
boolean containsHello = str.contains("Hello");
System.out.println("contains('Hello'): " + containsHello);

// equals() - Compare deux chaînes pour l'égalité.
boolean isEqual = str.equals("Hello, World!");
System.out.println("equals(): " + isEqual);

// indexOf() - Récupère la position de la première occurrence spécifiée de caractères dans une chaîne.
int indexOfComma = str.indexOf("l");
System.out.println("indexOf(','): " + indexOfComma);

// lastIndexOf() - Récupère la position de la dernière occurrence spécifiée de caractères dans une chaîne.
int lastIndexOfO = str.lastIndexOf("o");
System.out.println("lastIndexOf('o'): " + lastIndexOfO);

// length() - Récupère la longueur de la chaîne.
int length = str.length();
System.out.println("length(): " + length);

// replace() - Remplace une valeur spécifiée dans une chaîne.
String replacedStr = str.replace("World", "Java");
System.out.println("replace(): " + replacedStr);

// split() - Divise une chaîne en un tableau de sous-chaînes en utilisant un délimiteur spécifié.
String[] splitStr = str.split(",");
System.out.println("split(','): ");
for (String s : splitStr) {
    System.out.println(s);
}

// startsWith() - Vérifie si une chaîne commence par les caractères spécifiés.
boolean startsWithHello = str.startsWith("Hello");
System.out.println("startsWith('Hello'): " + startsWithHello);

// substring() - Récupère une sous-chaîne de la chaîne.
String subStr = str.substring(0, 5); // Obtient "Hello"
System.out.println("substring(0, 5): " + subStr);

// toLowerCase() - Convertit une chaîne en minuscules.
String lowerCaseStr = str.toLowerCase();
System.out.println("toLowerCase(): " + lowerCaseStr);

// toUpperCase() - Convertit une chaîne en majuscules.
String upperCaseStr = str.toUpperCase();
System.out.println("toUpperCase(): " + upperCaseStr);

// trim() - Supprime les espaces en début et en fin de chaîne.
String paddedStr = "     Hello, toto !   ";
String trimmedStr = paddedStr.trim();
System.out.println("trim(): '" + trimmedStr + "'");
System.out.println("trim(): '" + paddedStr + "'");
// Exemples d'utilisation des autres méthodes de la classe String

String str1 = "Hello";
String str2 = "HElLO";

// compareToIgnoreCase() - Compare deux chaînes en ignorant la casse.
int compareToIgnoreCaseResult = str1.compareToIgnoreCase(str2);
System.out.println("compareToIgnoreCase(): " + compareToIgnoreCaseResult);

// endsWith() - Vérifie si une chaîne se termine par les caractères spécifiés.
boolean endsWithExclamation = str1.endsWith("!");
System.out.println("endsWith('!'): " + endsWithExclamation);

// format() - Crée une chaîne formatée avec des arguments.
String formattedString = String.format("Hi, %s! Today is %d/%02d/%04d.", "Alice", 9, 7, 2023);
System.out.println("format(): " + formattedString);

// getBytes() - Encode une chaîne en octets en utilisant un jeu de caractères spécifié.
byte[] bytes = str1.getBytes();
System.out.println("getBytes(): " + Arrays.toString(bytes));

// hashCode() - Récupère le code de hachage de la chaîne.
int hashCode = str1.hashCode();
int hashCode2 = str2.hashCode();
System.out.println("hashCode(): " + hashCode);
System.out.println("hashCode2(): " + hashCode2);

// intern() - Renvoie la représentation canonique de l'objet chaîne.
String internedStr = str1.intern();
System.out.println("intern(): " + internedStr);
// isEmpty() - Vérifie si une chaîne est vide.
boolean isEmpty = str1.isEmpty();
System.out.println("isEmpty(): " + isEmpty);

// matches() - Recherche une correspondance avec une expression régulière.
boolean matchesRegex = str1.matches("[A-Za-z]+");
System.out.println("matchesRegex('[A-Za-z]+'): " + matchesRegex);

// offsetByCodePoints() - Renvoie l'index décalé de codePointOffset points de code.
int offsetIndex = str1.offsetByCodePoints(0, 2); // Décalage de 2 points de code à partir du début.
System.out.println("offsetByCodePoints(0, 2): " + offsetIndex);

// regionMatches() - Compare deux régions de chaînes.
boolean regionMatchesResult = str1.regionMatches(true, 0, str2, 0, 5);
System.out.println("regionMatches(): " + regionMatchesResult);

// replaceFirst() - Remplace la première occurrence d'une sous-chaîne correspondant à une expression régulière.
String replacedFirstStr = str1.replaceFirst("l", "L");
System.out.println("replaceFirst('l', 'L'): " + replacedFirstStr);

// replaceAll() - Remplace toutes les occurrences correspondant à une expression régulière.
String replacedAllStr = str1.replaceAll("l", "L");
System.out.println("replaceAll('l', 'L'): " + replacedAllStr);


}
}