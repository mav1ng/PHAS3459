package exam1617;

import java.util.ArrayList;

public class ExamPart1 {
	
	public static void setInstrumentName(Index index, Sound sound0, Sound sound1, Sound sound2, 
			Sound sound3, Sound sound4, Sound sound5, Sound sound6) throws Exception {
		
		int counter = 0;
		
		for ( String key : index.hm.keySet() ) {
			
			if (counter == 1) {
				sound0.filename = key;
				sound0.instrument = index.hm.get(key);
				sound0.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}
			
			if (counter == 2) {
				sound1.filename = key;
				sound1.instrument = index.hm.get(key);
				sound1.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			if (counter == 3) {
				sound2.filename = key;
				sound2.instrument = index.hm.get(key);
				sound2.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			if (counter == 4) {
				sound3.filename = key;
				sound3.instrument = index.hm.get(key);
				sound3.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			if (counter == 5) {
				sound4.filename = key;
				sound4.instrument = index.hm.get(key);
				sound4.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			if (counter == 6) {
				sound5.filename = key;
				sound5.instrument = index.hm.get(key);
				sound5.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			if (counter == 7) {
				sound6.filename = key;
				sound6.instrument = index.hm.get(key);
				sound6.dataFromLine("http://www.hep.ucl.ac.uk/undergrad/3459"
						+ "/exam-data/2016-17/" + key);
			}

			counter++;
		}
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

			setInstrumentName(index, sound0, sound1, sound2, sound3, sound4, sound5, sound6);

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

	}



}


