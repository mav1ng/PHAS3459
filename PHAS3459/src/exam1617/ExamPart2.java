package exam1617;

import java.util.ArrayList;


public class ExamPart2 {

	public static String data(Sound s, Classification cl, Classification cl2) {

		String output = "Filename:  " + s.filename + "    Duration: " + cl.classify(s)
		+ "   Volume: " + cl2.classify(s);

		return output;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Index index = new Index();
		Sound sound0 = new Sound();
		Sound sound1 = new Sound();
		Sound sound2 = new Sound();
		Sound sound3 = new Sound();
		Sound sound4 = new Sound();
		Sound sound5 = new Sound();
		Sound sound6 = new Sound();


		try {
			index.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2016-17/index.txt");

			ExamPart1.setInstrumentName(index, sound0, sound1, sound2, sound3, sound4, sound5, sound6);

		}
		catch (Exception e) {
			System.out.println(e);
		}


		double duration;
		double amplitude;

		ArrayList<Sound> alSound = new ArrayList<Sound>();
		alSound.add(sound0);
		alSound.add(sound1);
		alSound.add(sound2);
		alSound.add(sound3);
		alSound.add(sound4);
		alSound.add(sound5);
		alSound.add(sound6);



		for (Sound s : alSound) {

			double totalSumSquare = 0;

			for (Long l : s.recording) {
				totalSumSquare = totalSumSquare + Math.pow(l, 2);
			}

			double xrms = Math.sqrt(totalSumSquare/s.samples);

			duration = s.samples/s.frequency;
			amplitude = 20 * Math.log10( xrms/ s.maxAmp);

			s.amplitude = amplitude;
			s.duration = duration;

			System.out.println("Filename: " + s.filename + "  Duration: " + duration + "sek" 
					+ "  Amplitude: " + amplitude + "dBFS" + "  Instrument: " + s.instrument);

		}

		System.out.println();
		System.out.println("Data Analysis");
		System.out.println();
		
		DurationClassification dC = new DurationClassification();
		VolumeClassification vC = new VolumeClassification();

		for (Sound s : alSound) {
			System.out.println(data(s, dC, vC));
		}
		
	}


}
