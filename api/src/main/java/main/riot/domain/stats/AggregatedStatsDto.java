package main.riot.domain.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-17.
 */
public class AggregatedStatsDto {

    @JsonProperty
    private int averageAssists;
    @JsonProperty
    private int averageChampionsKilled;
    @JsonProperty
    private int averageCombatPlayerScore;
    @JsonProperty
    private int averageNodeCapture;
    @JsonProperty
    private int averageNodeCaptureAssist;
    @JsonProperty
    private int averageNodeNeutralize;
    @JsonProperty
    private int averageNodeNeutralizeAssist;
    @JsonProperty
    private int averageNumDeaths;
    @JsonProperty
    private int averageObjectivePlayerScore;
    @JsonProperty
    private int averageTeamObjective;
    @JsonProperty
    private int averageTotalPlayerScore;
    @JsonProperty
    private int botGamesPlayed;
    @JsonProperty
    private int killingSpree;
    @JsonProperty
    private int maxAssists;
    @JsonProperty
    private int maxChampionsKilled;
    @JsonProperty
    private int maxCombatPlayerScore;
    @JsonProperty
    private int maxLargestCriticalStrike;
    @JsonProperty
    private int maxLargestKillingSpree;
    @JsonProperty
    private int maxNodeCapture;
    @JsonProperty
    private int maxNodeCaptureAssist;
    @JsonProperty
    private int maxNodeNeutralize;
    @JsonProperty
    private int maxNodeNeutralizeAssist;
    @JsonProperty
    private int maxNumDeaths;
    @JsonProperty
    private int maxObjectivePlayerScore;
    @JsonProperty
    private int maxTeamObjective;
    @JsonProperty
    private int maxTimePlayed;
    @JsonProperty
    private int maxTimeSpentLiving;
    @JsonProperty
    private int maxTotalPlayerScore;
    @JsonProperty
    private int mostChampionKillsPerSession;
    @JsonProperty
    private int mostSpellsCast;
    @JsonProperty
    private int normalGamesPlayed;
    @JsonProperty
    private int rankedPremadeGamesPlayed;
    @JsonProperty
    private int rankedSoloGamesPlayed;
    @JsonProperty
    private int totalAssists;
    @JsonProperty
    private int totalChampionKills;
    @JsonProperty
    private int totalDamageDealt;
    @JsonProperty
    private int totalDamageTaken;
    @JsonProperty
    private int totalDeathsPerSession;
    @JsonProperty
    private int totalDoubleKills;
    @JsonProperty
    private int totalFirstBlood;
    @JsonProperty
    private int totalGoldEarned;
    @JsonProperty
    private int totalHeal;
    @JsonProperty
    private int totalMagicDamageDealt;
    @JsonProperty
    private int totalMinionKills;
    @JsonProperty
    private int totalNeutralMinionsKilled;
    @JsonProperty
    private int totalNodeCapture;
    @JsonProperty
    private int totalNodeNeutralize;
    @JsonProperty
    private int totalPentaKills;
    @JsonProperty
    private int totalPhysicalDamageDealt;
    @JsonProperty
    private int totalQuadraKills;
    @JsonProperty
    private int totalSessionsLost;
    @JsonProperty
    private int totalSessionsPlayed;
    @JsonProperty
    private int totalSessionsWon;
    @JsonProperty
    private int totalTripleKills;
    @JsonProperty
    private int totalTurretsKilled;
    @JsonProperty
    private int totalUnrealKills;

    public int getAverageAssists() {
        return averageAssists;
    }

    public void setAverageAssists( int averageAssists ) {
        this.averageAssists = averageAssists;
    }

    public int getAverageChampionsKilled() {
        return averageChampionsKilled;
    }

    public void setAverageChampionsKilled( int averageChampionsKilled ) {
        this.averageChampionsKilled = averageChampionsKilled;
    }

    public int getAverageCombatPlayerScore() {
        return averageCombatPlayerScore;
    }

    public void setAverageCombatPlayerScore( int averageCombatPlayerScore ) {
        this.averageCombatPlayerScore = averageCombatPlayerScore;
    }

    public int getAverageNodeCapture() {
        return averageNodeCapture;
    }

    public void setAverageNodeCapture( int averageNodeCapture ) {
        this.averageNodeCapture = averageNodeCapture;
    }

    public int getAverageNodeCaptureAssist() {
        return averageNodeCaptureAssist;
    }

    public void setAverageNodeCaptureAssist( int averageNodeCaptureAssist ) {
        this.averageNodeCaptureAssist = averageNodeCaptureAssist;
    }

    public int getAverageNodeNeutralize() {
        return averageNodeNeutralize;
    }

    public void setAverageNodeNeutralize( int averageNodeNeutralize ) {
        this.averageNodeNeutralize = averageNodeNeutralize;
    }

    public int getAverageNodeNeutralizeAssist() {
        return averageNodeNeutralizeAssist;
    }

    public void setAverageNodeNeutralizeAssist( int averageNodeNeutralizeAssist ) {
        this.averageNodeNeutralizeAssist = averageNodeNeutralizeAssist;
    }

    public int getAverageNumDeaths() {
        return averageNumDeaths;
    }

    public void setAverageNumDeaths( int averageNumDeaths ) {
        this.averageNumDeaths = averageNumDeaths;
    }

    public int getAverageObjectivePlayerScore() {
        return averageObjectivePlayerScore;
    }

    public void setAverageObjectivePlayerScore( int averageObjectivePlayerScore ) {
        this.averageObjectivePlayerScore = averageObjectivePlayerScore;
    }

    public int getAverageTeamObjective() {
        return averageTeamObjective;
    }

    public void setAverageTeamObjective( int averageTeamObjective ) {
        this.averageTeamObjective = averageTeamObjective;
    }

    public int getAverageTotalPlayerScore() {
        return averageTotalPlayerScore;
    }

    public void setAverageTotalPlayerScore( int averageTotalPlayerScore ) {
        this.averageTotalPlayerScore = averageTotalPlayerScore;
    }

    public int getBotGamesPlayed() {
        return botGamesPlayed;
    }

    public void setBotGamesPlayed( int botGamesPlayed ) {
        this.botGamesPlayed = botGamesPlayed;
    }

    public int getKillingSpree() {
        return killingSpree;
    }

    public void setKillingSpree( int killingSpree ) {
        this.killingSpree = killingSpree;
    }

    public int getMaxAssists() {
        return maxAssists;
    }

    public void setMaxAssists( int maxAssists ) {
        this.maxAssists = maxAssists;
    }

    public int getMaxChampionsKilled() {
        return maxChampionsKilled;
    }

    public void setMaxChampionsKilled( int maxChampionsKilled ) {
        this.maxChampionsKilled = maxChampionsKilled;
    }

    public int getMaxCombatPlayerScore() {
        return maxCombatPlayerScore;
    }

    public void setMaxCombatPlayerScore( int maxCombatPlayerScore ) {
        this.maxCombatPlayerScore = maxCombatPlayerScore;
    }

    public int getMaxLargestCriticalStrike() {
        return maxLargestCriticalStrike;
    }

    public void setMaxLargestCriticalStrike( int maxLargestCriticalStrike ) {
        this.maxLargestCriticalStrike = maxLargestCriticalStrike;
    }

    public int getMaxLargestKillingSpree() {
        return maxLargestKillingSpree;
    }

    public void setMaxLargestKillingSpree( int maxLargestKillingSpree ) {
        this.maxLargestKillingSpree = maxLargestKillingSpree;
    }

    public int getMaxNodeCapture() {
        return maxNodeCapture;
    }

    public void setMaxNodeCapture( int maxNodeCapture ) {
        this.maxNodeCapture = maxNodeCapture;
    }

    public int getMaxNodeCaptureAssist() {
        return maxNodeCaptureAssist;
    }

    public void setMaxNodeCaptureAssist( int maxNodeCaptureAssist ) {
        this.maxNodeCaptureAssist = maxNodeCaptureAssist;
    }

    public int getMaxNodeNeutralize() {
        return maxNodeNeutralize;
    }

    public void setMaxNodeNeutralize( int maxNodeNeutralize ) {
        this.maxNodeNeutralize = maxNodeNeutralize;
    }

    public int getMaxNodeNeutralizeAssist() {
        return maxNodeNeutralizeAssist;
    }

    public void setMaxNodeNeutralizeAssist( int maxNodeNeutralizeAssist ) {
        this.maxNodeNeutralizeAssist = maxNodeNeutralizeAssist;
    }

    public int getMaxNumDeaths() {
        return maxNumDeaths;
    }

    public void setMaxNumDeaths( int maxNumDeaths ) {
        this.maxNumDeaths = maxNumDeaths;
    }

    public int getMaxObjectivePlayerScore() {
        return maxObjectivePlayerScore;
    }

    public void setMaxObjectivePlayerScore( int maxObjectivePlayerScore ) {
        this.maxObjectivePlayerScore = maxObjectivePlayerScore;
    }

    public int getMaxTeamObjective() {
        return maxTeamObjective;
    }

    public void setMaxTeamObjective( int maxTeamObjective ) {
        this.maxTeamObjective = maxTeamObjective;
    }

    public int getMaxTimePlayed() {
        return maxTimePlayed;
    }

    public void setMaxTimePlayed( int maxTimePlayed ) {
        this.maxTimePlayed = maxTimePlayed;
    }

    public int getMaxTimeSpentLiving() {
        return maxTimeSpentLiving;
    }

    public void setMaxTimeSpentLiving( int maxTimeSpentLiving ) {
        this.maxTimeSpentLiving = maxTimeSpentLiving;
    }

    public int getMaxTotalPlayerScore() {
        return maxTotalPlayerScore;
    }

    public void setMaxTotalPlayerScore( int maxTotalPlayerScore ) {
        this.maxTotalPlayerScore = maxTotalPlayerScore;
    }

    public int getMostChampionKillsPerSession() {
        return mostChampionKillsPerSession;
    }

    public void setMostChampionKillsPerSession( int mostChampionKillsPerSession ) {
        this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    }

    public int getMostSpellsCast() {
        return mostSpellsCast;
    }

    public void setMostSpellsCast( int mostSpellsCast ) {
        this.mostSpellsCast = mostSpellsCast;
    }

    public int getNormalGamesPlayed() {
        return normalGamesPlayed;
    }

    public void setNormalGamesPlayed( int normalGamesPlayed ) {
        this.normalGamesPlayed = normalGamesPlayed;
    }

    public int getRankedPremadeGamesPlayed() {
        return rankedPremadeGamesPlayed;
    }

    public void setRankedPremadeGamesPlayed( int rankedPremadeGamesPlayed ) {
        this.rankedPremadeGamesPlayed = rankedPremadeGamesPlayed;
    }

    public int getRankedSoloGamesPlayed() {
        return rankedSoloGamesPlayed;
    }

    public void setRankedSoloGamesPlayed( int rankedSoloGamesPlayed ) {
        this.rankedSoloGamesPlayed = rankedSoloGamesPlayed;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists( int totalAssists ) {
        this.totalAssists = totalAssists;
    }

    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    public void setTotalChampionKills( int totalChampionKills ) {
        this.totalChampionKills = totalChampionKills;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt( int totalDamageDealt ) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken( int totalDamageTaken ) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    public void setTotalDeathsPerSession( int totalDeathsPerSession ) {
        this.totalDeathsPerSession = totalDeathsPerSession;
    }

    public int getTotalDoubleKills() {
        return totalDoubleKills;
    }

    public void setTotalDoubleKills( int totalDoubleKills ) {
        this.totalDoubleKills = totalDoubleKills;
    }

    public int getTotalFirstBlood() {
        return totalFirstBlood;
    }

    public void setTotalFirstBlood( int totalFirstBlood ) {
        this.totalFirstBlood = totalFirstBlood;
    }

    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }

    public void setTotalGoldEarned( int totalGoldEarned ) {
        this.totalGoldEarned = totalGoldEarned;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal( int totalHeal ) {
        this.totalHeal = totalHeal;
    }

    public int getTotalMagicDamageDealt() {
        return totalMagicDamageDealt;
    }

    public void setTotalMagicDamageDealt( int totalMagicDamageDealt ) {
        this.totalMagicDamageDealt = totalMagicDamageDealt;
    }

    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    public void setTotalMinionKills( int totalMinionKills ) {
        this.totalMinionKills = totalMinionKills;
    }

    public int getTotalNeutralMinionsKilled() {
        return totalNeutralMinionsKilled;
    }

    public void setTotalNeutralMinionsKilled( int totalNeutralMinionsKilled ) {
        this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
    }

    public int getTotalNodeCapture() {
        return totalNodeCapture;
    }

    public void setTotalNodeCapture( int totalNodeCapture ) {
        this.totalNodeCapture = totalNodeCapture;
    }

    public int getTotalNodeNeutralize() {
        return totalNodeNeutralize;
    }

    public void setTotalNodeNeutralize( int totalNodeNeutralize ) {
        this.totalNodeNeutralize = totalNodeNeutralize;
    }

    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    public void setTotalPentaKills( int totalPentaKills ) {
        this.totalPentaKills = totalPentaKills;
    }

    public int getTotalPhysicalDamageDealt() {
        return totalPhysicalDamageDealt;
    }

    public void setTotalPhysicalDamageDealt( int totalPhysicalDamageDealt ) {
        this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    }

    public int getTotalQuadraKills() {
        return totalQuadraKills;
    }

    public void setTotalQuadraKills( int totalQuadraKills ) {
        this.totalQuadraKills = totalQuadraKills;
    }

    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    public void setTotalSessionsLost( int totalSessionsLost ) {
        this.totalSessionsLost = totalSessionsLost;
    }

    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    public void setTotalSessionsPlayed( int totalSessionsPlayed ) {
        this.totalSessionsPlayed = totalSessionsPlayed;
    }

    public int getTotalSessionsWon() {
        return totalSessionsWon;
    }

    public void setTotalSessionsWon( int totalSessionsWon ) {
        this.totalSessionsWon = totalSessionsWon;
    }

    public int getTotalTripleKills() {
        return totalTripleKills;
    }

    public void setTotalTripleKills( int totalTripleKills ) {
        this.totalTripleKills = totalTripleKills;
    }

    public int getTotalTurretsKilled() {
        return totalTurretsKilled;
    }

    public void setTotalTurretsKilled( int totalTurretsKilled ) {
        this.totalTurretsKilled = totalTurretsKilled;
    }

    public int getTotalUnrealKills() {
        return totalUnrealKills;
    }

    public void setTotalUnrealKills( int totalUnrealKills ) {
        this.totalUnrealKills = totalUnrealKills;
    }
}
