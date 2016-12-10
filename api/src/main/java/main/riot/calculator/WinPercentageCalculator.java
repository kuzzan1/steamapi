package main.riot.calculator;

/**
 *
 */

import java.util.Arrays;
import java.util.List;

/**
 * @author Petteri
 *
 */
public class WinPercentageCalculator {

    private WinPercentageCalculator() {
    }

    /**
     *
     * @param playerWins
     */



    public static double getWinPercentOnPlayer(Boolean[] playerWins) {
        return calculateParticipantsWinProbability(playerWins);
    }


    public static List<Double> calculateTeamWinPercents( double [] team1participantProbs, double [] team2participantProbs) {
        double team1Winning = 1.0;
        double team2Winning = 1.0;
        double team1Losing = 1.0;
        double team2Losing = 1.0;

        if (testIfZeroInput(team1participantProbs) && testIfZeroInput(team2participantProbs)) {
            // no data
            return Arrays.asList( 0.0, 0.0 );
        }
        else if (testIfZeroInput(team1participantProbs)) {
            // team2 100%
            return Arrays.asList( 0.0, 100.0 );
        }
        else if (testIfZeroInput(team2participantProbs)) {
            // team1 100%
            return Arrays.asList( 100.0, 0.0 );
        }
        else {
            for (int i = 0; i < team1participantProbs.length; i++) {
                team1Winning = team1Winning * testProbability(team1participantProbs[i]);
            }
            //System.out.println(team1Winning);

            for (int i = 0; i < team2participantProbs.length; i++) {
                team2Winning = team2Winning * testProbability(team2participantProbs[i]);
            }
            //System.out.println(team2Winning);

            for (int i = 0; i < team1participantProbs.length; i++) {
                team1Losing = team1Losing * testProbability((1.0 - team1participantProbs[i]));
            }
            //System.out.println(team1Losing);

            for (int i = 0; i < team2participantProbs.length; i++) {
                team2Losing = team2Losing * testProbability((1.0 - team2participantProbs[i]));
            }
            //System.out.println(team2Losing);

            double t1Winning = team1Winning * team2Losing;
            double t1Losing = team1Losing * team2Winning;

            //System.out.println("t1 wins likelyhood=" + t1Winning);
            //System.out.println("t1 loses likelyhood=" + t1Losing);

            double t1WinPercent = 100.0 * (t1Winning / (t1Winning + t1Losing));
            double t2WinPercent = 100.0 - t1WinPercent;

            return Arrays.asList( t1WinPercent, t2WinPercent );
        }
    }

    public static double [] calculateTeamWinPercents(double [] team1participantProbs, double [] team1participantProbsWithChampion, double [] team2participantProbs, double [] team2participantProbsWithChampion) {
        double team1Winning = 1.0;
        double team2Winning = 1.0;
        double team1Losing = 1.0;
        double team2Losing = 1.0;

        double weightImportanceWins = 0.63;
        double weightImporanceWinsWithChampion = 0.37;

		if (testIfZeroInput(team1participantProbs) && testIfZeroInput(team2participantProbs)) {
			// no data
			return new double[] {0.0, 0.0};
		}
		else if (testIfZeroInput(team1participantProbs)) {
			// team2 100%
			return new double[] {0.0, 100.0};
		}
		else if (testIfZeroInput(team2participantProbs)) {
			// team1 100%
			return new double[] {100.0, 0.0};
		}
		else {
			for (int i = 0; i < team1participantProbs.length; i++) {
				team1Winning = team1Winning * testProbability((team1participantProbs[i] * weightImportanceWins + team1participantProbsWithChampion[i] * weightImporanceWinsWithChampion));
			}
			//System.out.println(team1Winning);

			for (int i = 0; i < team2participantProbs.length; i++) {
				team2Winning = team2Winning * testProbability((team2participantProbs[i] * weightImportanceWins + team2participantProbsWithChampion[i] * weightImporanceWinsWithChampion));
			}
			//System.out.println(team2Winning);

			for (int i = 0; i < team1participantProbs.length; i++) {
				team1Losing = team1Losing * testProbability(((1.0 - team1participantProbs[i]) * weightImportanceWins + (1.0 - team1participantProbs[i]) * weightImporanceWinsWithChampion));
			}
			//System.out.println(team1Losing);

			for (int i = 0; i < team2participantProbs.length; i++) {
				team2Losing = team2Losing * testProbability(((1.0 - team2participantProbs[i]) * weightImportanceWins + (1.0 - team2participantProbs[i]) * weightImporanceWinsWithChampion));
			}
			//System.out.println(team2Losing);

			double t1Winning = team1Winning * team2Losing;
			double t1Losing = team1Losing * team2Winning;

			//System.out.println("t1 wins likelyhood=" + t1Winning);
			//System.out.println("t1 loses likelyhood=" + t1Losing);

			double t1WinPercent = 100.0 * (t1Winning / (t1Winning + t1Losing));
			double t2WinPercent = 100.0 - t1WinPercent;

			return new double[] {t1WinPercent, t2WinPercent};
		}
	}

	private static double calculateParticipantsWinProbability( Boolean[] wins ) {
		double count = 0.0;
		double winCount = 0.0;
		for (int i = 0; i < wins.length; i++) {
			if (wins[i]) {
				winCount = winCount + 1.0;
			}
			count = count + 1.0;
		}
		if (count == 0.0) {
			return 0.0;
		}
		return winCount / count;
	}


	public static double calculateParticipantsWinProbability(boolean [] wins) {
		double count = 0.0;
		double winCount = 0.0;
		for (int i = 0; i < wins.length; i++) {
			if (wins[i] == true) {
				winCount = winCount + 1.0;
			}
			count = count + 1.0;
		}
		if (count == 0.0) {
			return 0.0;
		}
		return winCount / count;
	}

	private static double testProbability(double probability) {
		if (probability == 0.0) {
			// 8th time is a charm, giving 50% chance to assumingly 8th match...
			return 0.06125;
		}
		return probability;
	}

	private static boolean testIfZeroInput(double[] probs) {
		for (int i = 0; i < probs.length; i++) {
			if (probs[i] != 0.0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		boolean [] t1Participant1Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t1Participant2Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t1Participant3Wins = new boolean [] {false,false,false,false,false,false,false};
		boolean [] t1Participant4Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t1Participant5Wins = new boolean [] {true,false,false,true,true,true,true};

		boolean [] t2Participant1Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t2Participant2Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t2Participant3Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t2Participant4Wins = new boolean [] {true,false,false,true,true,true,true};
		boolean [] t2Participant5Wins = new boolean [] {false,false,false,false,false,false,false};

		boolean [] t1Participant1WinsWithChampions = new boolean [] {true,true};
		boolean [] t1Participant2WinsWithChampions = new boolean [] {false};
		boolean [] t1Participant3WinsWithChampions = new boolean [] {};
		boolean [] t1Participant4WinsWithChampions = new boolean [] {true,true,false,true,false};
		boolean [] t1Participant5WinsWithChampions = new boolean [] {true};

		boolean [] t2Participant1WinsWithChampions = new boolean [] {true,false};
		boolean [] t2Participant2WinsWithChampions = new boolean [] {false};
		boolean [] t2Participant3WinsWithChampions = new boolean [] {false,false,false,true};
		boolean [] t2Participant4WinsWithChampions = new boolean [] {true,true,false,true,false};
		boolean [] t2Participant5WinsWithChampions = new boolean [] {};

		WinPercentageCalculator calc = new WinPercentageCalculator();

		double [] team1WinningWithoutChampions = new double [] {
				calc.calculateParticipantsWinProbability(t1Participant1Wins),
				calc.calculateParticipantsWinProbability(t1Participant2Wins),
				calc.calculateParticipantsWinProbability(t1Participant3Wins),
				calc.calculateParticipantsWinProbability(t1Participant4Wins),
				calc.calculateParticipantsWinProbability(t1Participant5Wins)};
		double [] team2WinningWithoutChampions = new double [] {
				calc.calculateParticipantsWinProbability(t2Participant1Wins),
				calc.calculateParticipantsWinProbability(t2Participant2Wins),
				calc.calculateParticipantsWinProbability(t2Participant3Wins),
				calc.calculateParticipantsWinProbability(t2Participant4Wins),
				calc.calculateParticipantsWinProbability(t2Participant5Wins)};

		System.out.println("Before the champions have been selected...");
		System.out.println("Team1 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team2WinningWithoutChampions)[0] + "%" + 
				"\t" + "Team2 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team2WinningWithoutChampions)[1] + "%");

		double [] team1WinningWithChampionsPartiallySelected = new double [] {
				calc.calculateParticipantsWinProbability(t1Participant1Wins),
				calc.calculateParticipantsWinProbability(t1Participant2Wins),
				calc.calculateParticipantsWinProbability(t1Participant3Wins),
				calc.calculateParticipantsWinProbability(t1Participant4Wins),
				calc.calculateParticipantsWinProbability(t1Participant5Wins)};
		double [] team2WinningWithChampionsPartiallySelected = new double [] {
				calc.calculateParticipantsWinProbability(t2Participant1Wins),
				calc.calculateParticipantsWinProbability(t2Participant2Wins),
				calc.calculateParticipantsWinProbability(t2Participant3Wins),
				calc.calculateParticipantsWinProbability(t2Participant4WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant5Wins)};

		System.out.println("One team member has selected champion (t2,p4)...");
		System.out.println("Team1 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampionsPartiallySelected, team2WinningWithoutChampions, team2WinningWithChampionsPartiallySelected)[0] + "%" + 
				"\t" + "Team2 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampionsPartiallySelected, team2WinningWithoutChampions, team2WinningWithChampionsPartiallySelected)[1] + "%");

		
		double [] team1WinningWithChampions = new double [] {
				calc.calculateParticipantsWinProbability(t1Participant1WinsWithChampions),
				calc.calculateParticipantsWinProbability(t1Participant2WinsWithChampions),
				calc.calculateParticipantsWinProbability(t1Participant3WinsWithChampions),
				calc.calculateParticipantsWinProbability(t1Participant4WinsWithChampions),
				calc.calculateParticipantsWinProbability(t1Participant5WinsWithChampions)};
		double [] team2WinningWithChampions = new double [] {
				calc.calculateParticipantsWinProbability(t2Participant1WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant2WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant3WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant4WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant5WinsWithChampions)};

		System.out.println("Final estimate with champions have been selected...");
		System.out.println("Team1 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[0] + "%" + 
				"\t" + "Team2 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[1] + "%");
		
		System.out.println("Live betting, one champion is dead...");
		// participant2 is dead but with us in spirit 
		team1WinningWithoutChampions = new double [] {
				calc.calculateParticipantsWinProbability(t1Participant1Wins),
				0.0,
				calc.calculateParticipantsWinProbability(t1Participant3Wins),
				calc.calculateParticipantsWinProbability(t1Participant4Wins),
				calc.calculateParticipantsWinProbability(t1Participant5Wins)};

		team2WinningWithChampions = new double [] {
				calc.calculateParticipantsWinProbability(t2Participant1WinsWithChampions),
				0.0,
				calc.calculateParticipantsWinProbability(t2Participant3WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant4WinsWithChampions),
				calc.calculateParticipantsWinProbability(t2Participant5WinsWithChampions)};

		System.out.println("Team1 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[0] + "%" + 
				"\t" + "Team2 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[1] + "%");

		System.out.println("Final result...");
		team1WinningWithoutChampions = new double [] {
				0.0,
				0.0,
				0.0,
				0.0,
				0.0};

		team2WinningWithChampions = new double [] {
				calc.calculateParticipantsWinProbability(t2Participant1WinsWithChampions),
				0.0,
				0.0,
				0.0,
				calc.calculateParticipantsWinProbability(t2Participant5WinsWithChampions)};

		System.out.println("Team1 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[0] + "%" + 
				"\t" + "Team2 to win " + calc.calculateTeamWinPercents(team1WinningWithoutChampions, team1WinningWithChampions, team2WinningWithoutChampions, team2WinningWithChampions)[1] + "%");
		
	}*/

}
