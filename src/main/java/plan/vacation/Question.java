package plan.vacation;


public class Question {

    private String question;
    private String imageLink;
    private int ID;

    final String spanishQuestionsList[] = new String[] {
        "¿Cual es tu voluntad para hablar un idioma extranjero otro de inglés?",
        "¿Cual es tu clima ideal para la vacación?",
        "¿Como está tu presupuesto?",
    	"¿Que tan preocupado estas por tu seguridad?",
        "¿Que tipo de la comida te gusta?",
        "¿Que tipo de transporte gostarias usar?",
        "¿Cual es tu deporte favorito?",
        "¿Populación?",
        "¿Cual es tu actividad al aire libre favorita?",
        "¿Que tipo de escenario gostarias?"
    };

    final String portugueseQuestionsList[] = new String[] {
        "Qual é sua vontade para falar um idioma estrangeiro outro do inglès",
        "Qual é o clima ideal para as férias?",
        "Como está seu orçamento?",
        "Quão preocupado você está com sua segurança?",
        "Que tipo de comida você gosta?",
        "Que tipo de transporte você gostaria de usar?",
        "Qual é seu esporte favorito?",
        "População?",
        "Qual é a sua atividade ao ar livre favorita?",
        "Que tipo de cenário você quer?"
    };

    final String koreanQuestionsList[] = new String[] {
        "영어 이외의 외국어를 할 의향은 무엇입니까?",
        "휴가를 보내기에 이상적인 날씨는 언제인가요?",
        "예산은 어떻습니까?",
        "니 안전에 얼마나 관심이 있습니까?",
        "어떤 종류의 음식을 좋아하나요?",
        "어떤 교통수단을 이용하시겠습니까?",
        "좋아하는 스포츠는 무엇일까?",
        "인구?",
        "가장 좋아하는 야외 활동은 무엇입니까?",
        "어떤 풍경을 원하세요?"
    };

    final String chineseQuestionsList[] = new String[] {
        "你愿意说英语以外的外语吗?",
        "你度假的理想天气是什么?",
        "你的预算是多少?",
        "你有多关心你的安全?",
        "你喜欢吃什么样的食物?",
        "您想使用哪种交通工具?",
        "你最喜欢的运动是什么?",
        "人口呢?",
        "你最喜欢的户外活动是什么?",
        "你想要什么样的风景?"
    };

    final String frenchQuestionsList[] = new String[] {
        "Quelle est votre volonté de parler une langue étrangère autre que l'anglais?",
        "Quel est votre temps idéal pour les vacances?",
        "Quel est votre budget?",
        "Dans quelle mesure êtes-vous inquiet pour votre sécurité?",
        "Quel genre de nourriture aimez-vous?",
        "Quel type de transport souhaitez-vous utiliser?",
        "Quel est ton sport préféré?",
        "Population?",
        "Quelle est votre activité de plein air préférée?",
        "Quel genre de paysage voulez-vous?"
    };
    
    final String italianQuestionsList[] = new String[] {
        "Qual è la tua disponibilità a parlare una lingua straniera diversa dall'inglese?",
        "Qual è il tempo ideale per le vacanze?",
        "Qual è il tuo budget?",
        "Quanto sei preoccupato per la tua sicurezza?",
        "Che tipo di cibo ti piace?",
        "Che tipo di trasporto vorresti usare?",
        "Qual'è il tuo sport preferito?",
        "Popolazione?",
        "Qual è la tua attività all'aperto preferita?",
        "Che tipo di scenario vuoi?"
    };

    final String questionsList[] = new String[] {
        "What is your willingness to speak a foreign language other than English?",
        "What is your ideal weather for vacation?",
        "What's your budget like?",
        "How concerned are you for your safety?",
        "What kind of food do you like?",
        "What kind of transportation would you like to use?",
        "What is your favorite sport?",
        "Population?",
        "What is your favorite outdoor activity?",
        "What kind of scenery do you want?"
    };


    /** Image correlation */
    final String imageLinks[] = new String[] {
        "file:resources/assets/noenglish.png",
        "file:resources/assets/Hot_or_cold.jpg",
        "file:resources/assets/rainingmoney.jpg",
        "file:resources/assets/safetyfirst.jpg",
        "file:resources/assets/ilikefood.jpg",
        "file:resources/assets/Public-Transport.jpg",
        "file:resources/assets/manysports.jpg",
        "file:resources/assets/many_people.jpg",
        "file:resources/assets/outdooractivities.jpg",
        "file:resources/assets/beautiful_sky.jpg"
    };

    public Question() {
        question = "No question found";
        imageLink = "No image found";
        ID = -1;
    } // Questions constructor

    public Question(int questionNum) {
        this.question = questionsList[questionNum];
        this.imageLink = imageLinks[questionNum];
        this.ID = questionNum;
    } // Questions constructor with parameters

    public String getQuestion() {
        return this.question;
    } // getQuestion

    public String getLink() {
        return this.imageLink;
    } // getLink

    public int getID() {
        return this.ID; 
    }


} // Question