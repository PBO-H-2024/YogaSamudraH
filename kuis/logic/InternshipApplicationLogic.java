package logic;

public class InternshipApplicationLogic {
    // Method to handle calculation logic
    public static String calculateResult(double writingScore, double codingScore, double interviewScore) {
        // Hitung rata-rata dari tiga nilai
        double averageScore = (writingScore + codingScore + interviewScore) / 3.0;

        // Tentukan hasil berdasarkan nilai rata-rata
        if (averageScore >= 70) {
            return "Keterima";
        } else {
            return "Tidak keterima";
        }
    }
}
