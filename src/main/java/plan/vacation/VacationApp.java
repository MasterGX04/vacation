package plan.vacation;

//import java.lang.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TextArea;

public class VacationApp extends Application {
    private Stage stage;
    private Scene scene;
    private VBox root;
    private Button startButton;
    private Button[] answerButtons = new Button[4];
    private Image image;
    private ImageView imageView;
    private Label questions;
    private ComboBox<String> languageOptions;
    private Label answerLabels[] = new Label[4];
    private Question questionList[] = new Question[10];
    private int questionNum = 0;
    private VBox choices;

    /** Language choices because I'm a polyglot */
    private final String[] LANGUAGES = {"English", "中文 Chinese", "한국어 Korean", "Español", "Português", "Français", "Italiano"};
    
    /** 
     * Creates instance "vacation app", with {@code stage}, {@code scene}, and {@code root} all
     * set to root.
     */
     
    public VacationApp() {
        this.stage = null;
        this.scene = null;
        this.root = new VBox(5);
        this.choices = new VBox();
        this.startButton = new Button("START");

        this.questions = new Label("Answer these questions to find your ideal vacation");
        for (int i = 0; i < answerLabels.length; i++) {
            Label answerLabel = new Label();
            this.answerLabels[i] = answerLabel;
        }
        for (int i = 0; i < answerButtons.length; i++) {
            Button answerButton = new Button("Select");
            this.answerButtons[i] = answerButton;
        }
        this.image = new Image("file:resources/assets/paradise.jpg", 750, 450, false, true);
        this.imageView = new ImageView(image);
        this.languageOptions = new ComboBox<>();

        for (int i = 0; i < questionList.length; i++) {
            Question question = new Question(i);
            questionList[i] = question;
        }
        
        //Adds different options with distinct buttons.
        for (int i = 0; i < 4; i++) {
            HBox option = new HBox(5);
            option.getChildren().addAll(answerLabels[i], answerButtons[i]);
            this.choices.getChildren().add(option);
        }
        //Function of start button
        startButton.setOnAction(e -> {
            this.root.getChildren().remove(2);
            this.root.getChildren().add(2, choices);
            loadQuestion();
        });
    }   

    /** {@inheritDoc} */
    @Override
    public void init() {
        
        VBox.setVgrow(root, Priority.ALWAYS);
        
        try {
            root.getChildren().addAll(questions, imageView, startButton, languageOptions);
        } catch (Exception e) { // leave try-catch for testing, can work on in a bit
            System.err.println(e.getMessage());
        } 
        //Adds language options to dropbox
        for (int i = 0; i < LANGUAGES.length; i++) {
            this.languageOptions.getItems().add(LANGUAGES[i]);
        }
        languageOptions.setValue(LANGUAGES[0]);
        
        //Which button user clicked
        answerButtons[0].setOnAction(e -> {
            if (questionNum == 10) {
                String country = Answer.getCountry();
                loadCountry(country);
            } else {
                getPoints(questionNum, 0);
                loadQuestion();
            }
        });
        answerButtons[1].setOnAction(e -> {
            if (questionNum == 10) {
                String country = Answer.getCountry();
                loadCountry(country);
            } else {
                getPoints(questionNum, 1);
                loadQuestion();
            }
        });
        answerButtons[2].setOnAction(e -> {
            if (questionNum == 10) {
                String country = Answer.getCountry();
                loadCountry(country);
            } else {
                getPoints(questionNum, 2);
                loadQuestion();
            }
        });
        answerButtons[3].setOnAction(e -> {
            if (questionNum == 10) {
                String country = Answer.getCountry();
                loadCountry(country);
            } else {
                getPoints(questionNum, 3);
                loadQuestion();
            }
        });

    }
    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.scene = new Scene(this.root, 800, 700);
        this.stage.setOnCloseRequest(event -> Platform.exit());
        this.stage.setTitle("Vacation Plan");
        this.stage.setScene(this.scene);
        this.stage.sizeToScene();
        this.stage.show();
        Platform.runLater(() -> this.stage.setResizable(false));
    } // start

    /** {@inheritDoc} */
    @Override
    public void stop() {
        // feel free to modify this method
        System.out.println("stop() called");
    } // stop
     /**
     * Show a modal error alert based on {@code cause}.
     * @param cause a {@link java.lang.Throwable Throwable} that caused the alert
     */
    public static void alertError(Throwable cause) {
        TextArea text = new TextArea(cause.toString());
        text.setEditable(false);
        Alert alert = new Alert(AlertType.ERROR);
        alert.getDialogPane().setContent(text);
        alert.setResizable(true);
        alert.showAndWait();
    } // alertError
    
    /**
     * Loads the next question in the class Question's questionList.
     */
    public void loadQuestion() {
        this.questions.setText("Question #" + (questionNum + 1) + " " + questionList[questionNum].getQuestion());

        //Changes image
        this.imageView.setImage(new Image(questionList[questionNum].getLink(), 750, 450, false, true));
        Answer answers = new Answer(questionNum);
        String[] questionAnswers = answers.getAnswer();
        for (int i = 0; i < questionAnswers.length; i++) {
            answerLabels[i].setText(questionAnswers[i]);
        }
        questionNum++;
    }

    public void getPoints (int questionIndex, int whichAnswer) {
        // Answer.addClimate(2) or (1) depending on button pressed
        if (questionIndex == 1 || questionIndex == 8 || questionIndex == 9) { // Climate
            int climatePoints = Answer.results[questionIndex][whichAnswer];
            Answer.addClimatePoints(climatePoints);
        } else if (questionIndex == 2 || questionIndex == 3 || questionIndex == 5) { // Budget
            int budgetPoints = Answer.results[questionIndex][whichAnswer];
            Answer.addBudgetPoints(budgetPoints);
        } else { // Culture
            int culturePoints = Answer.results[questionIndex][whichAnswer];
            Answer.addCulturePoints(culturePoints);
        }
    } // nextButton

    /**
     * Loads the correct country picture with flag, food, and attraction.
     * @param country to be shown
     */
    private void loadCountry(String country) {
        this.questions.setText("Country Result: You should go to " + country + "!!!");
        VBox countryPictures = new VBox(5);
        //Country attributes we want to show
        String[] attributes = {"Flag", "Food", "Attraction"};
        for (int i = 0; i < 3; i++) {
            HBox result = new HBox();
            Label flag = new Label(attributes[i] + ": ");
            String imageLink = "file:src/main/resources/assets/" + country + "-" + attributes[i] + ".png";
            Image newImage = new Image(imageLink, 250, 175, false, true);
            ImageView picture = new ImageView();
            picture.setImage(newImage);
            result.getChildren().addAll(flag, picture);
            countryPictures.getChildren().add(result);
        }
        this.root.getChildren().remove(1);
        this.root.getChildren().add(1, countryPictures);
        this.root.getChildren().remove(2);
        Label information = new Label();
        switch (country) {
            case "Australia":
                information.setText("Go to the Great Barrier Reef to view beautiful nature, especially the sea life.\nMake sure to also visit Sydney and go to Australia's most famous attractions,\nThe Sydney Opera House. Their food isn't that bad too.");
                break; 
            case "Canada":
                information.setText("Canada is basically United States's younger brother. If you want to get out of\n the country but still want to be comfortable, go to Canada for America Lite.\nHowever, there is a large French-speaking population in Quebec.\nGo try Poutine!");
                break;
            case "Mexico":
                information.setText("Mexico has one of the most interesting cultures in the world, and you should \ndefinitely see the historical sites there. It is a more dangerous country than\n the other ones, but if you know where you're going, you should be fine.");
                break;
            case "Serbia":
                information.setText("Exercise increased caution in Serbia due to crime. The nature, history and culture\nand the amazing food are all great reasons to go. It's also a great choice to go\nif you are on a budget.");
                break;
            case "Singapore":
                information.setText("One of the wealthiest and developed countries in the world, Singapore has three \nofficial languages: English, Mandarin, and Tamil. It is very hot and humid there, but\nit is also one of the cleanest in the world as well");
                break;
            case "South Africa":
                information.setText("South Africa is supposedly no longer racist, but you can still see it clearly.\nHowever, definitely go to see the awesome African wilderness and animals like Elephants\n and Rhinoceroses. It's also rather easy to communicate with people in English because of colonialism!");
                break;
            case "Switzerland":
                information.setText("Switzerland is one of the most beautiful countries, with awesome mountainous views\n and a very comfortable lifestyle. However, make sure you have enough\nmoney to survive because it is one of the most expensive countries to visit.");
                break;
            case "UK":
                information.setText("There are many beautiful sights to see, especially the Elizabeth Tower in London\n and listen to the British's better English. However, you're gonna\nnot have a good time with the food if their best food is baked beans.");
                break;
            case "USA":
                information.setText("I think you're very boring in you maybe should just stay in the United States.\n The US has some nice places, especially New York, but the problem\nis you really have to be good at driving or you won't get anywhere.");
                break;
        }
        this.root.getChildren().add(information);
    }
}