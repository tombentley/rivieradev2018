/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static java.util.Arrays.asList;

public class Utils {

    public static final List<Product> PRODUCTS = asList(new Product(randomProductId(), "Apples", new BigDecimal("0.45")),
            new Product(randomProductId(), "Bananas", new BigDecimal("0.40")),
            new Product(randomProductId(), "Cat food", new BigDecimal("4.99")),
            new Product(randomProductId(), "Dog food", new BigDecimal("11.99")),
            new Product(randomProductId(), "Eggs, 6 boxed", new BigDecimal("1.20")),
            new Product(randomProductId(), "Floor cleaner", new BigDecimal("0.40")),
            new Product(randomProductId(), "Grapefruit", new BigDecimal("0.49")),
            new Product(randomProductId(), "Ham", new BigDecimal("0.99")),
            new Product(randomProductId(), "I", new BigDecimal("0.40")),
            new Product(randomProductId(), "Fish", new BigDecimal("0.40")),
            new Product(randomProductId(), "K", new BigDecimal("0.40")),
            new Product(randomProductId(), "L", new BigDecimal("0.40")),
            new Product(randomProductId(), "M", new BigDecimal("0.40")),
            new Product(randomProductId(), "N", new BigDecimal("0.40")),
            new Product(randomProductId(), "Orange Juice", new BigDecimal("1.29")),
            new Product(randomProductId(), "Pears", new BigDecimal("0.45")),
            new Product(randomProductId(), "Q", new BigDecimal("0.40")),
            new Product(randomProductId(), "R", new BigDecimal("0.40")),
            new Product(randomProductId(), "Sausages", new BigDecimal("1.00")),
            new Product(randomProductId(), "Toothpaste", new BigDecimal("2.30")),
            new Product(randomProductId(), "U", new BigDecimal("0.40")),
            new Product(randomProductId(), "V", new BigDecimal("0.40")),
            new Product(randomProductId(), "W", new BigDecimal("0.40")),
            new Product(randomProductId(), "X", new BigDecimal("0.40")),
            new Product(randomProductId(), "Y", new BigDecimal("0.40")),
            new Product(randomProductId(), "Zhoug", new BigDecimal("2.99"))
    );

    public static final List<String> firstNames = asList(
            "Marie",
            "Camille",
            "Léa",
            "Manon",
            "Chloé",
            "Laura",
            "Julie",
            "Sarah",
            "Pauline",
            "Mathilde",
            "Marine",
            "Emma",
            "Marion",
            "lucie",
            "Anaïs",
            "Océane",
            "Justine",
            "Morgane",
            "Clara",
            "Charlotte",
            "Juliette",
            "Emilie",
            "Lisa",
            "Mélanie",
            "Elodie",
            "Claire",
            "Inès",
            "margaux",
            "Alice",
            "Amandine",
            "Audrey",
            "Louise",
            "Noémie",
            "Clémence",
            "Maéva",
            "Melissa",
            "Amélie",
            "Eva",
            "Caroline",
            "Céline",
            "Célia",
            "Fanny",
            "Elise",
            "Sophie",
            "Margot",
            "Elisa",
            "Aurélie",
            "Jade",
            "Estelle",
            "Romane",
            "Jeanne",
            "ophélie",
            "Laurine",
            "Alexandra",
            "Valentine",
            "Solène",
            "lola",
            "Coralie",
            "Laëtitia",
            "Alexia",
            "Aurore",
            "Cécile",
            "Alicia",
            "Zoé",
            "Agathe",
            "Julia",
            "Anna",
            "Emeline",
            "Léna",
            "Laurie",
            "Lou",
            "Nina",
            "coline",
            "jessica",
            "Maëlle",
            "elsa",
            "Lucile",
            "Laure",
            "Salomé",
            "Axelle",
            "Andréa",
            "Charlène",
            "gaelle",
            "helene",
            "Clementine",
            "Victoria",
            "myriam",
            "éloïse",
            "heloise",
            "Cindy",
            "Marina",
            "Cassandra",
            "sara",
            "Carla",
            "Ambre",
            "ludivine",
            "anaelle",
            "sabrina",
            "Angélique",
            "Sandra",
            "Thomas",
            "nicolas",
            "Julien",
            "QUENTIN",
            "Maxime",
            "Alexandre",
            "Antoine",
            "Kevin",
            "clement",
            "Romain",
            "Pierre",
            "lucas",
            "Florian",
            "GUILLAUME",
            "valentin",
            "Jérémy",
            "hugo",
            "Alexis",
            "anthony",
            "Theo",
            "Paul",
            "mathieu",
            "Benjamin",
            "ADRIEN",
            "Vincent",
            "Alex",
            "arthur",
            "Louis",
            "Baptiste",
            "Dylan",
            "Corentin",
            "Thibault",
            "jordan",
            "Nathan",
            "Simon",
            "axel",
            "Matthieu",
            "léo",
            "sebastien",
            "Aurélien",
            "victor",
            "Loïc",
            "Rémi",
            "Arnaud",
            "tom",
            "david",
            "Jonathan",
            "Damien",
            "Enzo",
            "Bastien",
            "raphael",
            "Mickael",
            "François",
            "Robin",
            "martin",
            "Dorian",
            "Gabriel",
            "tristan",
            "Mathis",
            "Samuel",
            "Thibaut",
            "charles",
            "Benoit",
            "fabien",
            "Florent",
            "Maxence",
            "Cédric",
            "Marc",
            "yann",
            "Jérôme",
            "steven",
            "Mehdi",
            "Gaëtan",
            "Erwan",
            "Cyril",
            "jean",
            "max",
            "rémy",
            "yanis",
            "Tony",
            "Jules",
            "William",
            "olivier",
            "laurent",
            "christopher",
            "sylvain",
            "Ludovic",
            "Xavier",
            "Stephane",
            "Tanguy",
            "mael",
            "Morgan",
            "Adam",
            "Franck",
            "Grégory",
            "Christophe",
            "Alan",
            "antonin",
            "Mohamed",
            "Philippe"
    );
    public static final List<String> surnames = asList(
            "ABEL",
            "ABRAHAM",
            "ADAM",
            "ALBERT",
            "ALLARD",
            "ANDRÉ",
            "ARCHAMBAULT",
            "ARTHUR",
            "AUGUSTIN",
            "BABIN",
            "BABINEAUX",
            "BARRE",
            "BAUDIN",
            "BEAUCHÊNE",
            "BEAUFORT",
            "BEAULIEU",
            "BEAUMONT",
            "BÉLANGER",
            "BELLAMY",
            "BELLEROSE",
            "BELMONT",
            "BELROSE",
            "BÉRANGER",
            "BERGER",
            "BÉRINGER",
            "BERNARD",
            "BERTRAND",
            "BLAISE",
            "BLANC",
            "BLANCHARD",
            "BLANCHET",
            "BLANCHETT",
            "BOIVIN",
            "BONFILS",
            "BONHEUR",
            "BONHOMME",
            "BONNAIRE",
            "BONNAY",
            "BONNET",
            "BORDE",
            "BOUCHARD",
            "BOUCHER",
            "BOURDILLON",
            "BOURREAU",
            "BRET",
            "BRISBOIS",
            "BRODEUR",
            "BUREAU",
            "CARON",
            "CHAPUT",
            "CHARBONNEAU",
            "CHARPENTIER",
            "CHARRON",
            "CHASTAIN",
            "CHEVALIER",
            "CHEVROLET",
            "CHRISTIAN",
            "CLÉMENT",
            "CLOUTIER",
            "COLBERT",
            "COMTOIS",
            "COSTE",
            "CÔTÉ",
            "COURTEMANCHE",
            "COUSINEAU",
            "COUTURE",
            "DANIAU",
            "DANIEL",
            "DAVIAU",
            "DAVID",
            "DEFOREST",
            "DEGARMO",
            "DELACROIX",
            "DE",
            "DENIAU",
            "DENIAUD",
            "DENIEL",
            "DENIS",
            "DENNEL",
            "DESCHAMPS",
            "DESCOTEAUX",
            "DESJARDINS",
            "DESROCHES",
            "DESROSIERS",
            "DROIT",
            "DUBOIS",
            "DUCHAMPS",
            "DUFORT",
            "DUFOUR",
            "DUGUAY",
            "DUMONT",
            "DUPOND",
            "DUPONT",
            "DURAND",
            "DURANT",
            "DUVAL",
            "ÉMILE",
            "FABIEN",
            "FABRE",
            "FABRON",
            "FAUCHER",
            "FAUCHEUX",
            "FAURE",
            "FAVAGER",
            "FAVRE",
            "FAVREAU",
            "FAY",
            "FÉLIX",
            "FÈVRE",
            "FIRMIN",
            "FONTAINE",
            "FOREST",
            "FORESTIER",
            "FORTIER",
            "FOSSE",
            "FOURNIER",
            "FRANÇOIS",
            "GAGE",
            "GAGNE",
            "GAGNEUX",
            "GAGNIER",
            "GAGNON",
            "GARÇON",
            "GARDINIER",
            "GARNIER",
            "GAUTHIER",
            "GERMAIN",
            "GÉROUX",
            "GIRARD",
            "GIROUX",
            "GOSSE",
            "GOSSELIN",
            "GRANGER",
            "GROS",
            "GUÉRIN",
            "GUILLORY",
            "HARDY",
            "HARMAN",
            "HÉBERT",
            "HERBERT",
            "HERRIOT",
            "JACQUES",
            "JANVIER",
            "JORDAN",
            "JOUBERT",
            "LABELLE",
            "LACHANCE",
            "LACHAPELLE",
            "LAMAR",
            "LAMBERT",
            "LANE",
            "LANGLAIS",
            "LANGLOIS",
            "LAPOINTE",
            "LARUE",
            "LAURENT",
            "LAVIGNE",
            "LAVOIE",
            "LEANDRES",
            "LEBEAU",
            "LEBLANC",
            "LECLAIR",
            "LECLERC",
            "LÉCUYER",
            "LEFEBVRE",
            "LEFÈVRE",
            "LEFURGEY",
            "LEGRAND",
            "LEMAIRE",
            "LÉMIEUX",
            "LEON",
            "LEROY",
            "LESAUVAGE",
            "LESTRANGE",
            "LÉVÊQUE",
            "LÉVESQUE",
            "LINVILLE",
            "LUCAS",
            "LYON",
            "LYON",
            "MAÇON",
            "MARCHAND",
            "MARIE",
            "MARION",
            "MARTEL",
            "MARTEL",
            "MARTIN",
            "MASSON",
            "MASSON",
            "MATHIEU",
            "MERCIER",
            "MERLE",
            "MICHAUD",
            "MICHEL",
            "MONET",
            "MONETTE",
            "MONTAGNE",
            "MOREAU",
            "MOREL",
            "MOULIN",
            "MULLINS",
            "NICOLAS",
            "NOEL",
            "NOYER",
            "OLIVER",
            "OLIVIER",
            "PAGE",
            "PAGET",
            "PALOMER",
            "PAN",
            "PAPE",
            "PAQUET",
            "PAQUET",
            "PARENT",
            "PARIS",
            "PARRIS",
            "PASCAL",
            "PATENAUDE",
            "PATERNOSTER",
            "PAUL",
            "PELLETIER",
            "PERRAULT",
            "PERREAULT",
            "PERRIN",
            "PERROT",
            "PETIT",
            "PETTIGREW",
            "PIERRE",
            "PLAMONDON",
            "PLOURDE",
            "POINGDESTRE",
            "POIRIER",
            "PORCHER",
            "POULIN",
            "PROULX",
            "RENAUD",
            "REY",
            "REYER",
            "RICHARD",
            "RICHELIEU",
            "ROBERT",
            "ROCHE",
            "ROME",
            "ROMILLY",
            "ROSE",
            "ROUSSEAU",
            "ROUSSEL",
            "ROUX",
            "ROY",
            "ROYER",
            "SALMON",
            "SALOMON",
            "SALVAGE",
            "SAMSON",
            "SAMUEL",
            "SARGENT",
            "SARKOZI",
            "SARKOZY",
            "SARTRE",
            "SAULT",
            "SAUVAGE",
            "SAUVAGEAU",
            "SAUVAGEON",
            "SAUVAGEOT",
            "SAUVETERRE",
            "SAVATIER",
            "SEGAL",
            "SERGEANT",
            "SÉVERIN",
            "SIMON",
            "SOUCY",
            "ST MARTIN",
            "ST PIERE",
            "TAILLER",
            "TASSE",
            "THAYER",
            "THIBAULT",
            "THOMAS",
            "TRAVER",
            "TRAVERE",
            "TRAVERS",
            "TRAVERSE",
            "TRAVERT",
            "TREMBLAY",
            "TREMBLE",
            "VICTOR",
            "VILLENEUVE",
            "VINCENT",
            "VOCLAIN"
    );

    private static String randomName() {
        return firstNames.get(rng.nextInt(firstNames.size())) + " " + surnames.get(rng.nextInt(surnames.size()));
    }

    private static int productId = 747172;

    private static String randomProductId() {
        return String.valueOf(productId++);
    }

    public static List<Product> products() {
        return PRODUCTS;
    }

    private static long orderId = 0;
    private static Random rng = new Random();

    public static Order randomOrder() {
        Order order = new Order();
        order.setOrderId(orderId++);
        order.setCreditCardDetails(randomCreditCardDetails());
        order.setItems(randomItems(rng.nextInt(9) + 1));
        order.setCustomerId(rng.nextInt(1_000_000));
        return order;
    }

    private static CreditCardDetails randomCreditCardDetails() {
        CreditCardDetails result = new CreditCardDetails();
        result.setCardNumber(rng.nextLong() & 1_0000_0000_0000_0000L);
        result.setCvc(rng.nextInt(1000));
        result.setNameOnCard(randomName());
        result.setExpiryDate(new Date());
        result.setValidFromDate(new Date());
        return result;
    }

    public static List<Order.LineItem> randomItems(int num) {

        List<Product> products = Utils.products();
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < num; i++) {
            s.add(rng.nextInt(products.size()));
        }
        List<Order.LineItem> result = new ArrayList<>();
        for (int i : s) {
            Order.LineItem item = new Order.LineItem();
            Product product = products.get(i);
            item.setProduct(product);
            item.setQuantity(rng.nextInt(100) + 1);
            item.setUnitPrice(product.getUnitPrice());
            result.add(item);
        }

        return result;
    }

}
