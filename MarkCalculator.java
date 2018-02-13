//Project1 for CompSci Programming I @author Student8
public class MarkCalculator {
	

	//	moduleMarks=(computeMarks(courseworkMarks,examMarks,moduleWeighting));


	public int[] computeMarks(int[] coursework, int[] exams, int[] weighting){//module marks calculation
		int[] moduleMarks= new int[6];
		for (int i=0;i<6;i=i+1){
			if ((coursework[i]<35) || (exams[i]<35))//sub-35 grade reduction
				moduleMarks[i]=Math.min(coursework[i],exams[i]);
			else
			moduleMarks[i]=((coursework[i]*weighting[i])+(exams[i]*(100-weighting[i])))/100;//final mark calculation
		}
		return moduleMarks;
	}
	public String computeResult(int[]moduleMarks){
		int average=0;
		boolean pass=true;
		int CFcounter=0;
		for (int i=0;i<6;i=i+1){ //average calculation
			average=moduleMarks[i]+average;
			if (moduleMarks[i]<35){
				pass=false;
			}
			else if ((moduleMarks[i]>35)&&(moduleMarks[i]<40)) //compensatable fail counter
				CFcounter=CFcounter+1;
		}
		average=average/6;	
		if ((pass==false)||(CFcounter>=3))
		return "Fail";	//stage grade calculation
		else if ((average>39)&&(CFcounter<3)&&(CFcounter>0))
			return "Pass By Compensation";
		else
			return "Pass";
	}


}
