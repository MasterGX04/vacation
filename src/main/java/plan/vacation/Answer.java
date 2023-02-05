package plan.vacation;


/**                                                                                                                                               
       * Constructs a {@link plan.vacation.Answer} game with an ID that links to the qustion,
       * and keeps track of the answers chosen compared to all the possible answers listed.                                                                                                                                                                                                          
       *                                                                                                                                                                                                                                                                   
       */
public class Answer {

    private int questionID;
    private String[] answerList;
    static int culturePoints, budgetPoints, climatePoints;
    static int[][] results = new int[][] {
        {0, 3, 2, 1}, {3, 0, 2, 1}, {2, 3, 0, 1}, {0, 1, 2, 3},
        {0, 0, 0, 0}, {0, 3, 1, 2}, {0, 0, 0, 0}, {1, 3, 0, 2},
        {1, 3, 0, 2}, {0, 2, 3, 3}
    };
    /*
    final private String[] spanishAnswerList = new String[] {
        "Solo Ingles!",
        "Hola, bonjour, ni hao!",
        "No tengo miedo para aprender los basicos de idiomas.",
        "En general, la mayória de personas saben inglés.",
        
        "Me encanta el sol.",
        "Nieve y frío. (Brrr!)",
        "Regular, pero no calor.",
        "Regular, pero no frío.",

        "He estado ahorrando durante meses y puedo pagar esto.",
        "¿Presupuesto? ¿Qué presupuesto?",
        "Soy quebrado.",
        "Pagaré más de vez en cuando.",

        "¿Seguridad? Un pequeño crimen nunca le hace daño a nadie",
         "Déjame dejar mi billetera en este banco...",
         "Un poco más que un poco",
         "Sí.",

         "Asiático",
         "Latinoamericano",
         "Africano",
         "Europeo",

         "Caminaré a cualquier parte y a todas partes",
         "Haciendo zoom en el CAR",
         "Preferiría el tren si fuera una opción",
         "Me encanta un buen autobús",

         "Fútbol, Messi gobierna",
         "El baloncesto hace que la sangre bombee",
         "Cricket, amo la Copa del Mundo, pero el T-20 tiene un lugar en mi corazón",
         "Hockey",

         "Un pueblo pequeño, pintoresco y encantador con rincones tranquilos",
         "Ciudad bulliciosa con aventuras en cada esquina",
         "No quiero ver a otra persona",
         "Vendedores ambulantes y mercados llenos de encanto local",

         "Soy una chica de senderismo",
         "Natación, kayak, cualquier cosa con agua",
         "Biss de esquí",
         "Me quedaré adentro, me gusta más la vida de la ciudad",
        
         "Brillantes picos de montañas que se elevan hacia las nubes",
         "Árboles, hierba y todo lo verde en el medio",
         "Un impresionante océano, lago o cuerpo de agua brillante azul cerúleo",
         "Dunas y cañones ondulados del desierto recortados por una puesta de sol"
    }; */

    final private String[] possibleAnswers = new String[] {
        "Ingles only!",
        "Hola, bonjour, ni hao!",
        "I'm not afraid to learn the basics of any language!",
        "Ideally, most people know English",

        "Fun in the sun!",
        "Cold and snowy (brrr)",
        "Warm, but not hot",
        "Cool, but not cold",
        
        "I've been saving up for months & can afford this",
        "Budget, what budget??",
        "I'm broke",
        "Cheap is my jam, but I'll splurge on some excursions",

        "Safety? A little crime never hurt anyone",
        "Let me just leave my wallet on this bench...",
        "A little more than a little",
        "Yes.",

        "Asian",
        "Latin-American",
        "African",
        "European",

        "I'll walk anywhere and everywhere",
        "Zoooooming in the CAR",
        "I'd prefer the train if it was an option",
        "I love a good bus",

        "Soccer (Football), Messi rules",
        "Basketball gets the blood pumpin'",
        "Cricket, I love the World Cup, but T-20 has a place in my heart",
        "Hockey",

        "A small, quaint and charming town with quiet corners",
        "Bustling city with adventures at every corner",
        "I don't want to see another person",
        "Street vendors and markets filled with local charm",

        "I'm a hiking kinda gal",
        "Swimming, kayaking, anything with water",
        "Skiing biss",
        "I'll stay indoors--I'm more about city life",
        
        "Bright mountain peaks rising towards the clouds",
        "Trees, grass and everything green in between",
        "A stunning ocean, lake or water body sparkling cerulean blue",
        "Rolling desert dunes and canyons silhouetted by a sunset"

    };


    /**
    * 
    *
    *
    *
    */
    public Answer(int questionID) {
        this.questionID = questionID;
        this.answerList = new String[4];

    } // Answer constructor

    public void setAnswer(String input, int index) {
        this.answerList[index] = input;

    } // setAnswer

    public String[] getAnswer() {
        int aIndex = 0;
        for (int i = questionID * 4; i < questionID  * 4 + answerList.length; i++) { 
            answerList[aIndex] = this.possibleAnswers[i];
            aIndex++;
        }
        return answerList;

    } // getAnswer

    public static String getCountry() {
        String country = "USA";
        // Canada
        if (climatePoints < 4 && climatePoints > 0) {
            if (budgetPoints < 4) {
                if (culturePoints < 3) {
                    country = "Canada";
                } else if (culturePoints >= 3) { //Serbia
                    country = "Serbia";
                }
            } else if (budgetPoints >= 4) { //UK
                if (culturePoints < 3) {
                    country = "UK";
                } else if (culturePoints >= 3) { //Switzerland
                    country = "Switzerland";
                }
            }
        }
        // South Africa
        else if (climatePoints >= 4) {
            if (budgetPoints < 4) {
                if (culturePoints < 3) {
                    country = "South Africa";
                } else if (culturePoints >= 3) { //Mexico
                    country = "Mexico";
                }
            } else if (budgetPoints >= 4) { //Australia
                if (culturePoints < 3) {
                    country = "Australia";
                } else {
                    country = "Singapore";  //Singapore
                }
            }
        } //else if
        return country;
    } // getCountry 

    public static void addBudgetPoints(int points) {
        budgetPoints += points;
    } // addBudgetPoints

        public static void addCulturePoints(int points) {
        culturePoints += points;
    } // addCulturePoints

        public static void addClimatePoints(int points) {
        climatePoints +=  points;
    } // addClimatePoints

} // Answer