package Model;

public class MultipleChoiceQuestion implements Question {
    private String Instructions; 
    private int MarkValue;
    private String Question;
    private String[] Answers;
    private int ChosenAnswer;
	
    public MultipleChoiceQuestion(String Question, String[] Answers, String Instructions) {
        this.Question = Question;
        this.Instructions = Instructions;

        int ArraySize = Answers.length;
        this.Answers = new String[ArraySize];
        for (int i = 0; i<ArraySize; i++) {
                this.Answers[i] = Answers[i];
        }
    }
	
    @Override
    public String getInstructions() {
        return Instructions;
    }
	
    @Override
    public String getQuestion() {
        return Question;
    }

    public int GetNumberOfAnswers() {
        return Answers.length;
    }

    public String GetAnswer(int ID) {
        return Answers[ID];
    }
    
    public void SetAnswer(int ChosenAnswer) {
        this.ChosenAnswer = ChosenAnswer;
    }
    
    public int GetChosenAnswer() {
        return ChosenAnswer;
    }
    
    @Override
    public String toXML() {
        String XML = "<Question type=\"MCQ\">\n";
        
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<QuestionText>" + Question + "</QuestionText>\n";
        System.out.println("Number of answers:" + Answers.length);
        for (int i = 0; i<Answers.length; i++) {
            if (Answers[i] != null)
                XML += "<Answer>" + Answers[i] + "</Answer>\n";
        }
        
        XML += "</Question>\n";
        
        return XML;
    }
}
