package Model.Recruitment;

public class Model {
    private int id;
    private String name;
    private String path;
    private float writingExam;
    private float codingTest;
    private float interviewTest;
    private float finalScore;
    private String status;

    public Model(String name, String path, float writingExam, float codingTest, float interviewTest) {
        this.name = name;
        this.path = path;
        this.writingExam = writingExam;
        this.codingTest = codingTest;
        this.interviewTest = interviewTest;
        calculateFinalScore();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getWritingExam() {
        return writingExam;
    }

    public void setWritingExam(float writingExam) {
        this.writingExam = writingExam;
    }

    public float getCodingTest() {
        return codingTest;
    }

    public void setCodingTest(float codingTest) {
        this.codingTest = codingTest;
    }

    public float getInterviewTest() {
        return interviewTest;
    }

    public void setInterviewTest(float interviewTest) {
        this.interviewTest = interviewTest;
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calculateFinalScore() {
        float writingWeight = path.equals("Android Developer") ? 0.2f : 0.4f;
        float codingWeight = path.equals("Android Developer") ? 0.5f : 0.35f;
        float interviewWeight = path.equals("Android Developer") ? 0.3f : 0.25f;

        finalScore = writingExam * writingWeight + codingTest * codingWeight + interviewTest * interviewWeight;
        status = finalScore >= 85 ? "ACCEPTED" : "NOT ACCEPTED";
    }
}
