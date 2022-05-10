package org.ssglobal.training.codes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Score{
	
	ScoreInfo[] scores = new ScoreInfo[] {
			new ScoreInfo("Smith","John",70),
			new ScoreInfo("Doe","Mary",85),
			new ScoreInfo("Page","Alice",82),
			new ScoreInfo("Cooper","Jill",97),
			new ScoreInfo("Flintstone","Fred",66),
			new ScoreInfo("Rubble","Barney",80),
			new ScoreInfo("Smith","Judy",48),
			new ScoreInfo("Dean","James",90),
			new ScoreInfo("Russ","Joe",55),
			new ScoreInfo("Wolfe","Bill",73),
			new ScoreInfo("Dart","Mary",54),
			new ScoreInfo("Rogers","Chris",78),
			new ScoreInfo("Toole","Pat",51),
			new ScoreInfo("Khan","Omar",93),
			new ScoreInfo("Smith","Ann",95)	
	};
	
	public int getNumScores() {
		 int studentCount = (int) Arrays.stream(scores).count();
	        System.out.format("The number of students are: %d \n", studentCount);
			return studentCount;
	}
	
	Function<ScoreInfo, Integer> mapScoreInfoToScore = (s)-> {
		return s.getScore();
	};
	
	public double getAverage() {
		 double averageScore = Arrays.stream(scores).map(mapScoreInfoToScore).mapToInt(Integer::intValue).average().orElse(0);
		 System.out.format("The average score is: %.2f \n", averageScore);
		return averageScore;
	}
	
	Predicate<ScoreInfo> filterAListers = (s)-> {
		if (s.getScore() >= 90) {
			return true;
		} else {
			return false;
		}
	};
	
	public int getNumberAListers() {
		int aListersCount = (int) Arrays.stream(scores).filter(filterAListers).count();
		System.out.format("The number of students who got an A: %d \n", aListersCount);
		return aListersCount;
	}
	
	Predicate<ScoreInfo> filterFailingListers = (s)-> {
		if (s.getScore() < 70) {
			return true;
		} else {
			return false;
		}
	};
	public List<ScoreInfo> getFailingStudentList(){
		List<ScoreInfo> scoreList = Arrays.stream(scores).filter(filterFailingListers).collect(Collectors.toList());
		return scoreList;
	}
}

