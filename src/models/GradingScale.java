package models;

public class GradingScale {

	private String type;
	private double lowerA;
	private double lowerAMinus;
	private double lowerBPlus;
	private double lowerB;
	private double lowerBMinus;
	private double lowerCPlus;
	private double lowerC;
	private double lowerCMinus;
	private double lowerDPlus;
	private double lowerD;
	private double lowerDMinus;

	// ABC/NC Assumed
	public GradingScale(double lowerA, double lowerAMinus, double lowerBPlus, double lowerB,
			double lowerBMinus, double lowerCPlus, double lowerC) {
		
		this.type = "ABC/NC";
		this.lowerA = lowerA;
		this.lowerAMinus = lowerAMinus;
		this.lowerBPlus = lowerBPlus;
		this.lowerB = lowerB;
		this.lowerBMinus = lowerBMinus;
		this.lowerCPlus = lowerCPlus;
		this.lowerC = lowerC;
		
	}
	
	// ABCDF Assumed
	public GradingScale(double lowerA, double lowerAMinus, double lowerBPlus, double lowerB,
			double lowerBMinus, double lowerCPlus, double lowerC, double lowerCMinus, double lowerDPlus, double lowerD,
			double lowerDMinus/*, double lowerF*/) {
		
		this.type = "ABCDF";
		this.lowerA = lowerA;
		this.lowerAMinus = lowerAMinus;
		this.lowerBPlus = lowerBPlus;
		this.lowerB = lowerB;
		this.lowerBMinus = lowerBMinus;
		this.lowerCPlus = lowerCPlus;
		this.lowerC = lowerC;
		this.lowerCMinus = lowerCMinus;
		this.lowerDPlus = lowerDPlus;
		this.lowerD = lowerD;
		this.lowerDMinus = lowerDMinus;
	
	}

	public double getLowerA() {
		return lowerA;
	}

	public void setLowerA(double lowerA) {
		this.lowerA = lowerA;
	}

	public double getLowerAMinus() {
		return lowerAMinus;
	}

	public void setLowerAMinus(double lowerAMinus) {
		this.lowerAMinus = lowerAMinus;
	}

	public double getLowerBPlus() {
		return lowerBPlus;
	}

	public void setLowerBPlus(double lowerBPlus) {
		this.lowerBPlus = lowerBPlus;
	}

	public double getLowerB() {
		return lowerB;
	}

	public void setLowerB(double lowerB) {
		this.lowerB = lowerB;
	}

	public double getLowerBMinus() {
		return lowerBMinus;
	}

	public void setLowerBMinus(double lowerBMinus) {
		this.lowerBMinus = lowerBMinus;
	}

	public double getLowerCPlus() {
		return lowerCPlus;
	}

	public void setLowerCPlus(double lowerCPlus) {
		this.lowerCPlus = lowerCPlus;
	}

	public double getLowerC() {
		return lowerC;
	}

	public void setLowerC(double lowerC) {
		this.lowerC = lowerC;
	}

	public double getLowerCMinus() {
		return lowerCMinus;
	}

	public void setLowerCMinus(double lowerCMinus) {
		this.lowerCMinus = lowerCMinus;
	}

	public double getLowerDPlus() {
		return lowerDPlus;
	}

	public void setLowerDPlus(double lowerDPlus) {
		this.lowerDPlus = lowerDPlus;
	}

	public double getLowerD() {
		return lowerD;
	}

	public void setLowerD(double lowerD) {
		this.lowerD = lowerD;
	}

	public double getLowerDMinus() {
		return lowerDMinus;
	}

	public void setLowerDMinus(double lowerDMinus) {
		this.lowerDMinus = lowerDMinus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isValid() {
		
		boolean isValid = lowerA > lowerAMinus && lowerAMinus > lowerBPlus && lowerBPlus > lowerB && lowerB > lowerBMinus && lowerBMinus > lowerCPlus && lowerCPlus > lowerC;
		
		if (type.equals("ABCDF")) {
			isValid = isValid & lowerC > lowerCMinus && lowerCMinus > lowerDPlus && lowerDPlus > lowerD && lowerD > lowerDMinus;
		}
		
		return isValid;
	}
	
	public String getGrade(double percentEarned) {
		if (type.equals("ABC/NC")) {
			if (percentEarned >= lowerA) {
				return "A";
			}
			else if (percentEarned >= lowerAMinus) {
				return "A-";
			}
			else if (percentEarned >= lowerBPlus) {
				return "B+";
			}
			else if (percentEarned >= lowerB) {
				return "B";
			}
			else if (percentEarned >= lowerBMinus) {
				return "B-";
			}
			else if (percentEarned >= lowerCPlus) {
				return "C+";
			}
			else if (percentEarned >= lowerC) {
				return "C";
			}
			else {
				return "NC";
			}
		}
		else {
			if (percentEarned >= lowerA) {
				return "A";
			}
			else if (percentEarned >= lowerAMinus) {
				return "A-";
			}
			else if (percentEarned >= lowerBPlus) {
				return "B+";
			}
			else if (percentEarned >= lowerB) {
				return "B";
			}
			else if (percentEarned >= lowerBMinus) {
				return "B-";
			}
			else if (percentEarned >= lowerCPlus) {
				return "C+";
			}
			else if (percentEarned >= lowerC) {
				return "C";
			}
			else if (percentEarned >= lowerCMinus) {
				return "C-";
			}
			else if (percentEarned >= lowerDPlus) {
				return "D+";
			}
			else if (percentEarned >= lowerD) {
				return "D";
			}
			else if (percentEarned >= lowerDMinus) {
				return "D-";
			}
			else {
				return "F";
			}
		}
	}
	
	public double getCredits(String grade) {
		double credits;
		switch(grade) {
		case "A": credits = 4.0; break;
		case "A-": credits = 3.7; break;
		case "B+": credits = 3.3; break;
		case "B": credits = 3.0; break;
		case "B-": credits = 2.7; break;
		case "C+": credits = 2.3; break;
		case "C": credits = 2.0; break;
		case "C-": credits = 1.7; break;
		case "D+": credits = 1.3; break;
		case "D": credits = 1.0; break;
		case "D-": credits = 0.7; break;
		default: credits = 0.0;
		}
		
		return credits;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("type: " + type + "\n");
		output.append("valid: " + isValid() + "\n");
		output.append("A: >= " +lowerA + "\n");
		output.append("A-: >= " +lowerAMinus + "\n");
		output.append("B+: >= " +lowerBPlus + "\n");
		output.append("B: >= " +lowerB + "\n");
		output.append("B-: >= " +lowerBMinus + "\n");
		output.append("C+: >= " +lowerCPlus + "\n");
		output.append("C: >= " +lowerC + "\n");
		
		if (type.equals("ABC/NC")) {
			output.append("NC otherwise \n");
		}
		else {
			output.append("C-: >= " +lowerCMinus + "\n");
			output.append("D+: >= " +lowerDPlus + "\n");
			output.append("D: >= " +lowerD + "\n");
			output.append("D-: >= " +lowerDMinus + "\n");
			output.append("F otherwise \n");
		}
		
		return output.toString();
	}
	
}
