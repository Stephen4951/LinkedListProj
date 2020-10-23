package scores;

public class Score {
	
	private String studentId;
	private int koreanScore;
	private int englishScore;
	
	public Score(String studentId, int koreanScore, int englishScore) {
		super();
		this.studentId = studentId;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
	}

	
	
	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public int getKoreanScore() {
		return koreanScore;
	}



	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}



	public int getEnglishScore() {
		return englishScore;
	}



	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}



	@Override
	public String toString() {
		return String.format("%s %d %d", studentId, koreanScore, englishScore);
	}
	
	
	
	

}
