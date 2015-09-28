package test;

public class Results {
	private Boolean hasCertificate;
	private int courseId;
    private int scoredCredits;
    String icon="course-book";
    String titel="";
    public Results(int courseId ,int scoredCredits,    String titel) {
    	this.courseId=courseId;
    	this.setScoredCredits(scoredCredits, false);
    	this.titel=titel;
    	
    }
	public Boolean getHasCertificate() {
		return hasCertificate;
	}

	public int getCourseId() {
		
		return courseId;
	}

	public int getScoredCredits() {
		return scoredCredits;
	}
	public void setScoredCredits(int scoredCredits,Boolean hasCertificate) {
		if(scoredCredits>100){
			this.scoredCredits=100;
		}else if(scoredCredits<0){
			this.scoredCredits=100;
		}else{
			this.scoredCredits = scoredCredits;
		}
	}
    
}
