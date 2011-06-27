import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import riso.numerical.LBFGS;

import mlfs.maxent.GIS;
import mlfs.maxent.model.ComparableEvent;
import mlfs.maxent.model.Event;
import mlfs.maxent.model.GISModel;
import mlfs.maxent.model.TrainDataHandler;
import mlfs.numerical.AbstractLBFGS;
import mlfs.textClassification.corpus.CorpusReader;
import mlfs.textClassification.corpus.TestCorpusReader;


public class ttt {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
//		double[] x = new double[2];
//		AbstractLBFGS lbfgs = new TestLBFGS(2);
//		double f = lbfgs.getSolution(x);
//		System.out.println(x[0]);
//		System.out.println(x[1]);
//		System.out.println(f);
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("CHINESE_SEGMENT_CRF.train")));
		String line = null;
		int i=0;
		while ((line = reader.readLine()) != null)
		{
			i++;
			line.split("\\s");
			System.out.println(i);
		}
		reader.close();
	}
}

class TestLBFGS extends AbstractLBFGS
{

	public TestLBFGS(int dimetion) {
		super(dimetion);
	}

	@Override
	public double calFunctionVal(double[] x) {
		return (x[0]-2)*(x[0]-2) + (x[1]-3)*(x[1]-3)+5;
	}

	@Override
	public void calGradientVal(double[] x, double[] g) {
		g[0] = 2*(x[0]-2);
		g[1] = 2*(x[1]-3);
	}
	
}
